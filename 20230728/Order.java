package d230728;

public class Order {
	protected String menu;
	protected int count;
	protected int orderPrice;
	
	// 생성자
	public Order(String menu, int count, int menuPrice) {
		this.menu = menu;
		this.count = count;
		setOrderPrice(menuPrice);
	}
	
	public boolean runOrder(int deposit) {
		boolean runOrder;
		
		if (deposit >= this.orderPrice) {
			System.out.println(deposit - this.orderPrice);
			runOrder = true;
		} else {
			System.out.println("금액이 부족합니다.");
			runOrder = false;
		}
		return runOrder;
	};
	
	public void setOrderPrice(int menuPrice) {
		this.orderPrice = menuPrice * this.count;
	};
	
	public int getOrderPrice() {
		return this.orderPrice;
	};

}
