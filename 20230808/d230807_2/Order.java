package d230807_2;

import java.util.List;

public abstract class Order {
	protected List<Menu> menus;
	protected int orderPrice;
	public int orderType;
	
	public Order(List<Menu> menus, int orderType) {
		this.menus = menus;
		this.orderType = orderType;
		setOrderPrice();
	}
	
	public abstract void runOrder(int deposit);
	public abstract void outOrder();
	
	public void setOrderPrice() {
		for (Menu m : menus) {
			if (m == null) {
				break;
			}
			this.orderPrice += m.price;
		}
	}

	public int getOrderPrice() {
		return this.orderPrice;
	}

}