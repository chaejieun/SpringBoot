package tobyspring.helloboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan
public class HellobootApplication {
	
	@Bean
	public ServletWebServerFactory servletWebServerFactory() {
		return new TomcatServletWebServerFactory();
	}

	@Bean
	public DispatcherServlet dispatcherServlet() {
		return new DispatcherServlet();
	}
	
	public static void main(String[] args) {
		// MySpringApplication.run(HellobootApplication.class, args);
		SpringApplication.run(HellobootApplication.class, args);
		
		/* MySpringApplication이라는 함수를 만들어서 실행시켰으나
		 * SpringBoot에서 제공하고 있는 SpringApplication 안에 내장되어 있는 기능으로 작동 가능하기 때문에
		 * MySpringApplication을 삭제하고 사용가능함.
		 */
		
	}


}
