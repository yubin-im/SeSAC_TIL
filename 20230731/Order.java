package d230731;

public abstract class Order {
	protected String menu;
	protected int count;
	protected int orderPrice;
	
	public Order(String menu, int count, int price) {
		this.menu = menu;
		this.count = count;
		setOrderPrice(price);
	}
	
	public abstract void runOrder(int deposit);
	
	
	public void setOrderPrice(int price) {
		this.orderPrice = price * count;
		System.out.println(orderPrice + "원 입니다.");
	}

	public int getOrderPrice() {
		return this.orderPrice;
	}

}