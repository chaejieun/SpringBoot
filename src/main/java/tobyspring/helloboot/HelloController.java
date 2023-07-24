package tobyspring.helloboot;

import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/hello")
public class HelloController {
	
	private final HelloService helloService;
	
	public HelloController(HelloService helloService) {
		this.helloService = helloService;
	}

	@GetMapping
	@ResponseBody
	public String hello(String name) {
		return helloService.sayHello(Objects.requireNonNull(name));	// null인 경우 방지 처리 해주는 메소드
	}

	
	
}