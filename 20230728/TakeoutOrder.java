package d230728;

public class TakeoutOrder extends Order{
	protected int time;

	public TakeoutOrder(String menu, int count, int menuPrice) {
		super(menu, count, menuPrice);
	}

	@Override
	public boolean runOrder(int deposit) {
		return super.runOrder(deposit);
	}
	
	public void setTime(int time) {
		System.out.println(time + " 분뒤 " + this.menu + " 포장주문 완료되었습니다.");
	}

	@Override
	public void setOrderPrice(int menuPrice) {
		super.setOrderPrice(menuPrice);
		menuPrice = menuPrice - 500;
		System.out.println("테이크 아웃은 500원 할인되어 " + menuPrice + "원 입니다.");
	}
	
	

}
