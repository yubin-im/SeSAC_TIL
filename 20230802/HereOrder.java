package d230802;

public class HereOrder extends Order{
	private OnHere onHere;
	private int orderNum;
	Menu[] menus;
	
	interface OnHere{
		void successHere(int change, int orderNum, Menu[] menus);
	}
	
	public void setOnHere(OnHere onHere) {
		this.onHere = onHere;
	}
	
	public HereOrder(Menu[] menuArray) {
		super(menuArray);
		this.menus = menuArray;
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
	
}