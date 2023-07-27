// 20230727
package d230727;

public class Order {
	public String menu;  // 메뉴
	private int order;  // 개수
	private int order_price;  // 주문금액

	
	public Order(String menu, int order, int menu_price) {
		this.menu = menu;
		this.order = order;
		setOrderPrice(menu_price);
	}
	
	public void setOrderPrice(int menu_price) {
		this.order_price = menu_price * this.order;
		
	}
	
	public boolean runOrder(int deposit) {
		boolean runorder;
		
		if (deposit >= this.order_price) {
			System.out.println(deposit - this.order_price);
			runorder = true;
		} else {
			System.out.println("금액이 부족합니다.");
			runorder = false;
		}
		return runorder;
	}
	
	public int getOrderPrice() {
		return this.order_price;
	}
}
