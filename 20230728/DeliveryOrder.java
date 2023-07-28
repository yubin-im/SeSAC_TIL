package d230728;

public class DeliveryOrder extends Order{
	protected String locate;

	public DeliveryOrder(String menu, int count, int orderPrice) {
		super(menu, count, orderPrice);
	}

	@Override
	public boolean runOrder(int deposit) {
		boolean runOrder;
		
		if (deposit >= orderPrice) {
			System.out.println(deposit - orderPrice);
			runOrder = true;
		} else {
			System.out.println("금액이 부족합니다.");
			runOrder = false;
		}
		return runOrder;
	}
	
	public void setLocate(String address) {
		System.out.println(address + " 주소로 " + this.menu + " 배달 주문이 완료 되었습니다.");
	}
	
	@Override
	public void setOrderPrice(int menuPrice) {
		super.setOrderPrice(menuPrice);
		menuPrice = menuPrice + 3000;
		System.out.println("배달비 3000원 추가되어 " + menuPrice + "원 입니다.");
		System.out.println("배달 주문은 정확한 금액을 결제해주세요");
		
	}
}
