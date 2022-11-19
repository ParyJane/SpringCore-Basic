package hello.core.order;

/* 주문서 - 할인 후 말들어지는 객체 */
public class Order {
	
	private Long memberId;
	private String itemName;
	private int itemPrice;
	private int discountPrice;
	
	public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
		this.memberId = memberId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.discountPrice = discountPrice;
	}
	
	// 할인 금액 계산(비지니스 로직)
	public int calculatePrice() {
		return itemPrice - discountPrice;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

	@Override
	public String toString() {
		return "Order [memberId=" + memberId + 
					", itemName=" + itemName + 
					", itemPrice=" + itemPrice + 
					", discountPrice=" + discountPrice + 
					"]";
	}
	
	

}
