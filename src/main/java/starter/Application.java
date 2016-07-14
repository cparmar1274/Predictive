package starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableConfigurationProperties(DataSourceProperties.class)
@ComponentScan(basePackages = { "starter", "analytics", "authentications" })
public class Application {
	
	@Autowired
	private DataSourceProperties properties;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
