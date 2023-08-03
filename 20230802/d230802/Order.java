package d230802;

public abstract class Order {
	protected Menu[] menuArray;
	protected int orderPrice;
	
	public Order(Menu[] menuArray) {
		this.menuArray = menuArray;
		setOrderPrice(menuArray);
	}
	
	public abstract void runOrder(int deposit);
	
	
	public void setOrderPrice(Menu[] menuArray) {
		// this.orderPrice = price * count;
		for (Menu menus: menuArray) {
			int price = menus.getPrice();
			this.orderPrice += price;
		}
		System.out.println(orderPrice + "원 입니다.");
	}

	public int getOrderPrice() {
		return this.orderPrice;
	}

}