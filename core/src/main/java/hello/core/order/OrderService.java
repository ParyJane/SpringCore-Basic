package hello.core.order;

/* 주문 기능 */
public interface OrderService {
	
	Order createOrder(Long memberId, String itemName, int itemPrice);
	
}
