package d230731;

public class HereOrder extends Order{
	private OnHere onHere;
	private int orderNum;
	
	interface OnHere{
		void successHere(int change, int orderNum, String menu, int count);
	}
	
	public void setOnHere(OnHere onHere) {
		this.onHere = onHere;
	}
	
	public HereOrder(String menu, int count, int price) {
		super(menu, count, price);
		// TODO Auto-generated constructor stub
	}
	
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	
	@Override
	public void runOrder(int deposit) {
		int change = deposit - orderPrice;
		if (change >= 0) {
			onHere.successHere(change, orderNum, menu, count);
		} else {
			System.out.println("금액이 부족합니다.");
		}
	}
	
}