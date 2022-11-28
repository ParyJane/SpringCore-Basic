package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import hello.core.member.MemberService;

public class SingletonTest {
	
	@Test
	@DisplayName("스프링 없는 순수한 DI 컨테이너")
	void pureContainer() {
		
		AppConfig appConfig = new AppConfig();
		
		// 1. 조회 : 호출할 때 객체를 생성 
		MemberService memberService1 = appConfig.memberService();
		// 2. 조회 : 호출할 때 객체를 생성
		MemberService memberService2 = appConfig.memberService();
		
		// 참조값이 다른 것을 확인
		System.out.println("memberService1 = " + memberService1);
		System.out.println("memberService2 = " + memberService2);
		
		// memberService1 != memberService2
		Assertions.assertThat(memberService1).isNotSameAs(memberService2);
	}
	
	@Test
	@DisplayName("싱글톤 패턴을 적용한 객체 사용")
	void singletonServiceTest() {
		
		// 컴파일 오류 : private로 생성작을 막아
		// new SingletonService();
		
		// 1. 조회: 호출할 때 같은 객체를 반환
		SingletonService sc1 = SingletonService.getInstance();
		// 2. 조회: 호출할 때 같은 객체를 반환
		SingletonService sc2 = SingletonService.getInstance();
		
		// 참조값이 같은 것을 확인
		Assertions.assertThat(sc1).isSameAs(sc2);
		
		System.out.println("sc1 = " + sc1);
		System.out.println("sc2 = " + sc2);
		sc1.logic();
	}
}
