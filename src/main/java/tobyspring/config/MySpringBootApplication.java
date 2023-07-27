package tobyspring.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import tobyspring.config.autoconfig.DispathcerServletConfig;
import tobyspring.config.autoconfig.JettyWebServerConfig;
import tobyspring.config.autoconfig.TomcatWebServerConfig;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration
@ComponentScan
@Import({DispathcerServletConfig.class, TomcatWebServerConfig.class, JettyWebServerConfig.class})
public @interface MySpringBootApplication {
	

}
