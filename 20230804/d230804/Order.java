package d230804;

import java.util.ArrayList;
import java.util.List;

public abstract class Order {
	List<Menu> menuArray = new ArrayList<Menu>();
	protected int orderPrice;
	
	public Order(List<Menu> menuArray) {
		this.menuArray = menuArray;
		setOrderPrice(menuArray);
	}
	
	public abstract void runOrder(int deposit);
	
	
	public void setOrderPrice(List<Menu> menuArray) {
		for (Menu menus: menuArray) {
			int price = menus.getPrice();
			this.orderPrice += price;
		}
		System.out.println(orderPrice + "원 입니다.");
	}

	public int getOrderPrice() {
		return this.orderPrice;
	}

	public abstract void outOrder();
	
	

}