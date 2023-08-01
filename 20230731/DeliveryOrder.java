package d230731;

public class DeliveryOrder extends Order{
	private OnDelivery onDelivery;
	private String locate;
	
	interface OnDelivery{
		void successDelivery(String locate, String menu, int count);
	}

	public void setOnDelivery(OnDelivery onDelivery) {
		this.onDelivery = onDelivery;
	}
	
	public DeliveryOrder(String menu, int count, int price) {
		super(menu, count, price);
	}
	
	public void setLocate(String locate) {
		this.locate =locate;
	}
	
	
	@Override
	public void runOrder(int deposit) {
		int change = deposit - orderPrice;
		if (change == 0) {
			onDelivery.successDelivery(locate, menu, count);
		} else {
			System.out.println("금액이 맞지 않습니다.");
		}
	}
	
	@Override
	public void setOrderPrice(int price) {
		// TODO Auto-generated method stub
		this.orderPrice = price * count + 3000;
		System.out.print("배달비 3000원 추가되어 ");
		System.out.println(orderPrice + "원 입니다.");
		System.out.println("배달 주문은 정확한 금액을 결제해주세요");
	}

}