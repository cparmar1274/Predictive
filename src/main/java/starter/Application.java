package starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan(basePackages = { "starter", "analytics", "authentications" })
public class Application extends WebMvcAutoConfigurationAdapter {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		// templates
		registry.addResourceHandler("/resources/templates/**")
				.addResourceLocations("/resources/templates/")
				.addResourceLocations("classpath:/app/views/");

		// ui/ux libraries
		registry.addResourceHandler("/resources/node_modules/angular/**")
				.addResourceLocations("/resources/node_modules/angular/");
		registry.addResourceHandler("/resources/node_modules/bootstrap/**")
				.addResourceLocations("/resources/node_modules/bootstrap/");
		registry.addResourceHandler("/resources/node_modules/djquery/**")
				.addResourceLocations("/resources/node_modules/jquery/");
	}

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}