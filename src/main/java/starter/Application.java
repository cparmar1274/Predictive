package starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = { "starter", "analytics", "authentications" })
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}


-------------
LanguageTool - for spell checking
Bd155-create custom 
Learn javascript syntax for drupal
BD207 -
docker