package tobyspring.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationTest {
	
	@Test
	void configuration() {
//		Common common = new Common();
//		Assertions.assertThat(common).isSameAs(common);
		
		// 1. 불일치 발생
		MyConfig myConfig = new MyConfig();
		Bean1 bean1 = myConfig.bean1();
		Bean2 bean2 = myConfig.bean2();
		Assertions.assertThat(bean1.common).isSameAs(bean2.common);
		
		
		// 2. 일치 발생
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(MyConfig.class);
		ac.refresh();
		
		Bean1 bean1_1 = ac.getBean(Bean1.class);
		Bean2 bean2_1 = ac.getBean(Bean2.class);
		
		Assertions.assertThat(bean1_1.common).isSameAs(bean2_1.common);
		
	}
	
	@Test
	void proxyCommonMehtod() {
		MyConfigProxy myConfigProxy = new MyConfigProxy();
		
		Bean1 bean1 = myConfigProxy.bean1();
		Bean2 bean2 = myConfigProxy.bean2();
		
		Assertions.assertThat(bean1.common).isSameAs(bean2.common);
	}
	
	
	// MyConfig를 확장한 MyConfigProxy 생성
	static class MyConfigProxy extends MyConfig {

		private Common common;
		
		@Override
		Common common() {
			if( this.common == null) this.common = super.common();
			return super.common();
		}
		
	}
	
	
	// proxyBeanMethods (spring 5.2에서 제공하는)
	// bean 오브젝트를 만들 때, 또 다른 bean 오브젝트를 재사용할 때 기본적으로 제공해주는 기능
	// false 일 경우 재사용이 불가능 
	@Configuration(proxyBeanMethods = true)
	static class MyConfig {
		@Bean
		Common common() {
			return new Common();
		}
		
		@Bean
		Bean1 bean1() {
			return new Bean1(common());
		}
		
		@Bean
		Bean2 bean2() {
			
			return new Bean2(common());
		}
	}
	
	static class Bean1{
		private final Common common;
		
		Bean1(Common common){
			this.common = common;
		}
	}
	
	static class Bean2{
		private final Common common;
		
		Bean2(Common common){
			this.common = common;
		}
	}
	
	 static class Common {
		
	}

}
