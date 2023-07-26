package tobyspring.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {
	
	private final HelloService helloService;
	
	public HelloController(HelloService helloService) {
		this.helloService = helloService;
	}

	@GetMapping
	public String hello(String name) {
		//return helloService.sayHello(Objects.requireNonNull(name));	// null인 경우 방지 처리 해주는 메소드
		
		if(name == null || name.length() == 0) {
			throw new IllegalArgumentException();
		}
		
		return helloService.sayHello(name);
	}

	
}
