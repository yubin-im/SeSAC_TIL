package d230804;

import java.util.ArrayList;
import java.util.List;

public class HereOrder extends Order{
	private OnHere onHere;
	private int orderNum;
	List<Menu> menuArray = new ArrayList<Menu>();
	
	interface OnHere{
		void successHere(int change, int orderNum, List<Menu> menuArray);
	}
	
	public void setOnHere(OnHere onHere) {
		this.onHere = onHere;
	}
	
	public HereOrder(List<Menu> menuArray) {
		super(menuArray);
		this.menuArray = menuArray;
	}
	
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	
	@Override
	public void runOrder(int deposit) {
		int change = deposit - orderPrice;
		if (change >= 0) {
			onHere.successHere(change, orderNum, menuArray);
		} else {
			System.out.println("금액이 부족합니다.");
		}
	}
	
}