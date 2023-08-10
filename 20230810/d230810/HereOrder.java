package d230810;

import java.util.List;

public class HereOrder extends Order{
	private OnHere onHere;
	private int orderNum;
	
	interface OnHere{
		void successHere(int change, int orderNum, List<Menu> menus);
		void outHere(int orderNum, List<Menu> menus);

	}
	
	public void setOnHere(OnHere onHere) {
		this.onHere = onHere;
	}
	
	public HereOrder(List<Menu> menus) {
		super(menus, 3);
		// TODO Auto-generated constructor stub
	}
	
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	
	@Override
	public void runOrder(int deposit) {
		int change = deposit - orderPrice;
		if (change >= 0) {
			onHere.successHere(change, orderNum, menus);
		} else {
			System.out.println("금액이 부족합니다.");
		}
	}
	
	@Override
	public void outOrder() {
		onHere.outHere(orderNum, menus);
	}
	
	@Override
	public void setOrderPrice() {
		// TODO Auto-generated method stub
		super.setOrderPrice();
		System.out.println(orderPrice + "원 입니다.");
	}
}