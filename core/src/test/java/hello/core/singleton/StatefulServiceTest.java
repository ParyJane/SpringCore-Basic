package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {
	
	@Test
	void statefulServiceSingleton() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		StatefulService ss1 = ac.getBean(StatefulService.class);
		StatefulService ss2 = ac.getBean(StatefulService.class);
		
		// ThreadA: A사용자 10000원 주문
		int price1 = ss1.order("userA", 10000);
		// ThreadB: B사용자 20000원 주문
		int price2 = ss2.order("userB", 20000);
		
		System.out.println("price1 = " + price1);
		System.out.println("price2 = " + price2);
		
		/*
		// ThreadA: 사용자A 주문 금액 조회 (사용자A는 10000원을 기대했지만, 기대와 다르게 20000원 출력)
		System.out.println("price = " + ss1.getPrice());
		Assertions.assertThat(ss1.getPrice()).isEqualTo(20000);
		*/
	}
	
	static class TestConfig {
		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
		}
	}

}
