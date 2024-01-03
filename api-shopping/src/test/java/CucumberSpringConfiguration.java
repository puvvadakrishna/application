import org.springframework.boot.test.context.SpringBootTest;

import com.shopping.ShoppingApiApplication;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ShoppingApiApplication.class )
public class CucumberSpringConfiguration {
	
}