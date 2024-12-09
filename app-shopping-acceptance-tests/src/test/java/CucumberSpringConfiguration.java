import com.shopping.ShoppingApiApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@CucumberContextConfiguration
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = ShoppingApiApplication.class)
public class CucumberSpringConfiguration {

    @Configuration
    @ComponentScan("com.shopping")
    static class StepsConfigScan {

    }
}
