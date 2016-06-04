package starter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan(basePackages = { "starter", "analytics", "authentications" })
public class Application {

	public static EntityManagerFactory EntityManagerFactory = null;
	public static EntityManager EManager = null;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		EntityManagerFactory = Persistence.createEntityManagerFactory("mammoth");
		EManager = EntityManagerFactory.createEntityManager();

	}

}
