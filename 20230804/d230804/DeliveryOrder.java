package d230804;

import java.util.ArrayList;
import java.util.List;

public class DeliveryOrder extends Order{
	private OnDelivery onDelivery;
	private String locate;
	List<Menu> menuArray = new ArrayList<Menu>();
	
	interface OnDelivery{
		void successDelivery(String locate, List<Menu> menuArray);
	}

	public void setOnDelivery(OnDelivery onDelivery) {
		this.onDelivery = onDelivery;
	}
	
	public DeliveryOrder(List<Menu> menuArray) {
		super(menuArray);
		this.menuArray = menuArray;
	}
	
	public void setLocate(String locate) {
		this.locate = locate;
	}
	
	
	@Override
	public void runOrder(int deposit) {
		int change = deposit - orderPrice;
		if (change == 0) {
			onDelivery.successDelivery(locate, menuArray);
		} else {
			System.out.println("금액이 맞지 않습니다.");
		}
	}
	
	@Override
	public void setOrderPrice(List<Menu> menuArray) {
		super.setOrderPrice(menuArray);
		this.orderPrice = this.orderPrice + 3000;
		System.out.print("배달비 3000원 추가되어 ");
		System.out.println(orderPrice + "원 입니다.");
		System.out.println("배달 주문은 정확한 금액을 결제해주세요");
	}

}