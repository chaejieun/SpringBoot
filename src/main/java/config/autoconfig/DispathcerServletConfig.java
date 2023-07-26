package config.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class DispathcerServletConfig {


	@Bean
	public DispatcherServlet dispatcherServlet() {
		return new DispatcherServlet();
	}

}
