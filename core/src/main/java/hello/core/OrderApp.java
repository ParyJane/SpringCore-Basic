package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {

	public static void main(String[] args) {
		AppConfig appConfig = new AppConfig();
		MemberService memberService = appConfig.memberService();
		OrderService orderServie = appConfig.orderService();
		
		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);
		
		Order order = orderServie.createOrder(1L, "itemA", 20000);
		System.out.println(order.calculatePrice());
	}

}
