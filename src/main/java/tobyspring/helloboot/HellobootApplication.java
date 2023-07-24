package tobyspring.helloboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class HellobootApplication {

	public static void main(String[] args) {
		GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
		applicationContext.registerBean(SimpleHelloService.class);
		applicationContext.registerBean(HelloController.class);
		applicationContext.refresh();
		
		//SpringApplication.run(HellobootApplication.class, args);
		
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(ServletContext -> {
			ServletContext.addServlet("dispatcherServlet",new DispatcherServlet(applicationContext)
					).addMapping("/*");
		});
		
		webServer.start();
	}

}
