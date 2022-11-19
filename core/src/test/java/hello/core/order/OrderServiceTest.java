package hello.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class OrderServiceTest {
	
	// 회원 정보
	MemberService memberService = new MemberServiceImpl();
	// 주문 기능
	OrderService orderService = new OrderServiceImpl();
	
	@Test
	void createOrder() {
		// given
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		System.out.println(memberService.findMember(memberId).getName());
		
		// when
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		System.out.println(order.toString());
		
		// then
		System.out.println(order.getDiscountPrice());
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}

}
