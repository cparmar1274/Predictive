package starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
@EnableWebMvc
@ComponentScan(basePackages = { "starter", "analytics", "authentications" })
public class Application extends WebMvcAutoConfigurationAdapter {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		/* Views */
		registry.addResourceHandler("/resources/templates/**")
				.addResourceLocations("/");
		registry.addResourceHandler("/resources/custom_modules/app/views/**")
				.addResourceLocations("/portal/");

		/* Resources */
		registry.addResourceHandler("/resources/custom_modules/app/scripts/**")
				.addResourceLocations("/scripts/");
		registry.addResourceHandler("/resources/lib/node_modules/**")
				.addResourceLocations("/modules/");
	}

}