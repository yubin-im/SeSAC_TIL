package d230810;

import java.util.List;

public class DeliveryOrder extends Order{
	private OnDelivery onDelivery;
	private String locate;
	
	public interface OnDelivery{
		void successDelivery(String locate, List<Menu> menus);
		void outDelivery(String locate, List<Menu> menus);
	}
	
	public void setOnDelivery(OnDelivery onDelivery) {
		this.onDelivery = onDelivery;
	}
	
	public DeliveryOrder(List<Menu> menus) {
		super(menus, 1);
	}
	
	public void setLocate(String locate) {
		this.locate =locate;
	}
	
	
	@Override
	public void runOrder(int deposit) {
		int change = deposit - orderPrice;
		if (change == 0) {
			onDelivery.successDelivery(locate, menus);
		} else {
			System.out.println("금액이 맞지 않습니다.");
		} 
	}
	
	@Override
	public void outOrder() {
		onDelivery.outDelivery(locate, menus);
	}
	
	@Override
	public void setOrderPrice() {
		// TODO Auto-generated method stub
		super.setOrderPrice();
		this.orderPrice += 3000;
		System.out.print("배달비 3000원 추가되어 ");
		System.out.println(orderPrice + "원 입니다.");
		System.out.println("배달 주문은 정확한 금액을 결제해주세요");
	}

}