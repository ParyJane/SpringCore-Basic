package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

/* 주문 기능 구현체 */
public class OrderServiceImpl implements OrderService{
	
	// 회원 정보
	private final MemberRepository memberRepository = new MemoryMemberRepository();
	// 할인 정책
	private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		System.out.println(member.getName());
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

}
