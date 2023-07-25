package tobyspring.helloboot;

import java.util.Objects;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {
	
	private final HelloService helloService;
	private final ApplicationContext applicationContext;
	
	public HelloController(HelloService helloService, ApplicationContext applicationContext) {
		this.helloService = helloService;
		this.applicationContext = applicationContext;
		
		System.out.println(applicationContext);
	}

	@GetMapping
	public String hello(String name) {
		return helloService.sayHello(Objects.requireNonNull(name));	// null인 경우 방지 처리 해주는 메소드
	}

	
}
