package com.shopping.kafka.producer.wikimedia;

import java.net.URI;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class WikimediaChangesProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send() throws InterruptedException {

        //// create Producer Properties
        //Properties properties = new Properties();
        //properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        //properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //
        //// create the Producer
        //KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        String topic = "wikimedia.recentchange";


        EventHandler eventHandler = new WikimediaChangeHandler(kafkaTemplate, topic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource = builder.build();

        // start the producer in another thread
        eventSource.start();

        // we produce for 10 minutes and block the program until then
        TimeUnit.MINUTES.sleep(1);
    }
}
