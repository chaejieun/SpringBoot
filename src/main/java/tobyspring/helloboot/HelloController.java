package tobyspring.helloboot;

import java.util.Objects;

public class HelloController {
	
	private final HelloService helloService;
	
	public HelloController(HelloService helloService) {
		this.helloService = helloService;
	}

	public String hello(String name) {
		//SimpleHelloService helloService = new SimpleHelloService();
		
		return helloService.sayHello(Objects.requireNonNull(name));	// null인 경우 방지 처리 해주는 메소드
	}

}
