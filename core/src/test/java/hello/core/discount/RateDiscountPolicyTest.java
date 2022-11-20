package hello.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

/* 정률 할인 정책 Junit 테스트 */
public class RateDiscountPolicyTest {
	
	DiscountPolicy discountPolicy = new RateDiscountPolicy();
	
	@Test
	@DisplayName("VIP는 10% 할인이 적용되어야 한")
	void vip_o() {
		// given
		Member member = new Member(1L, "memberA", Grade.VIP);
		
		// when
		int discountPrice = discountPolicy.discount(member, 20000);
		
		// then 
		Assertions.assertThat(discountPrice).isEqualTo(2000);
	}
	
	@Test
	@DisplayName("VIP가 아니면 할인이 적용되지 않아야 한")
	void vip_x() {
		// given
		Member member = new Member(2L, "memberA", Grade.BASIC);
		
		// when
		int discountPrice = discountPolicy.discount(member, 20000);
		
		// then 
		Assertions.assertThat(discountPrice).isEqualTo(0);
	}
}
