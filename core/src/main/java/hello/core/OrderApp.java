package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {

	public static void main(String[] args) {
		/*
		// AppConfig 사용 버전 
		AppConfig appConfig = new AppConfig();
		MemberService memberService = appConfig.memberService();
		OrderService orderService = appConfig.orderService();
		*/
		
		// Spring 사용 버전 (컨테이너 생성)
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		OrderService orderService = ac.getBean("orderService", OrderService.class);
		
		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(1L, "itemA", 20000);
		System.out.println(order.calculatePrice());
	}

}
