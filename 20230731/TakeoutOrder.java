package d230731;

public class TakeoutOrder extends Order{
	private OnTakeout onTakeout;
	private int time;
	
	interface OnTakeout{
		void successTakeout(int change, int time, String menu, int count);
	}
	
	public void setOnTakeout(OnTakeout onTakeout) {
		this.onTakeout = onTakeout;
	}
	
	public TakeoutOrder(String menu, int count, int price) {
		super(menu, count, price);
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	@Override
	public void runOrder(int deposit) {
		int change = deposit - orderPrice;
		if (change >= 0) {
			onTakeout.successTakeout(change, time, menu, count);
		} else {
			System.out.println("금액이 부족합니다.");
		}
	}
	
	@Override
	public void setOrderPrice(int price) {
		// TODO Auto-generated method stub
		this.orderPrice = price * count + -500;
		System.out.print("테이크 아웃은 500원 할인되어 ");
		System.out.println(orderPrice + "원 입니다.");
	}
}