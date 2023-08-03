package d230803_2;

import java.util.List;

import d230803_2.DeliveryOrder.OnDelivery;
import d230803_2.HereOrder.OnHere;
import d230803_2.TakeoutOrder.OnTakeout;

public class Kiosk implements OnDelivery, OnHere, OnTakeout{
	public static int key = 3;
	private int inventory;
	
	public Kiosk(int inventory) {
		this.inventory = inventory;
	}
	
	public Order initOder(List<Menu> menuArray, int orderType) throws KioskException{

		if (isInventory(menuArray.size())) {
			if (orderType == 1) {
				DeliveryOrder order = new DeliveryOrder(menuArray);
				order.setOnDelivery(this);
				return order;
			} else if (orderType == 2){
				TakeoutOrder order = new TakeoutOrder(menuArray);
				order.setOnTakeout(this);
				return order;
			} else {
				HereOrder order = new HereOrder(menuArray);
				order.setOnHere(this);
				return order;
			}
		} else {
			System.out.println("재고가 부족합니다.");
			throw new KioskException("error code", 101);
		}
	}
	
	private boolean isInventory(int count) {
		if (inventory >= count) {
			return true;
		} else {
			return false;
		}
	}
		
	public void subInventory(int count) {
		inventory -= count;
	}
	
	@Override
	public void successDelivery(String locate, List<Menu> menuArray) {
		System.out.println(locate + " 주소로 배달 주문이 완료 되었습니다.");
		System.out.print("주문 내역: ");
		for(Menu menu: menuArray) {
			System.out.print(menu.menu + " ");
		}
		System.out.println("");
		// subInventory(menyArray.size());		
	}
	@Override
	public void successHere(int change, int orderNum, List<Menu> menuArray) {
		System.out.println("잔돈 "+change+"입니다. ");
		System.out.println(orderNum+ "번 주문번호로 주문 완료되었습니다. ");
		System.out.print("주문 내역: ");
		for(Menu menu: menuArray) {
			System.out.print(menu.menu + " ");
		}
		System.out.println("");
		// subInventory(menyArray.size());

	}
	@Override
	public void successTakeout(int change, int time, List<Menu> menuArray) {
		System.out.println("잔돈 "+change+"입니다. ");
		System.out.println(time+ " 분후 포장주문 완료되었습니다.");
		System.out.print("주문 내역: ");
		for(Menu menu: menuArray) {
			System.out.print(menu.menu + " ");
		}
		System.out.println("");
		// subInventory(menyArray.size());
	}
	
}
