package d230810;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

import d230810.DeliveryOrder.OnDelivery;
import d230810.HereOrder.OnHere;
import d230810.TakeoutOrder.OnTakeout;

public class Kiosk implements OnDelivery, OnHere, OnTakeout{
	public static int key = 3;
	private Deque<Order> orderQ;
	private Map<String,Integer> menuPriceMap;
	private Map<String,Integer> inventoryMap;

	
	public Kiosk(int inventory) {
		orderQ = new ConcurrentLinkedDeque<Order>();
		menuPriceMap = new HashMap<String, Integer>();
		inventoryMap = new HashMap<String, Integer>();
		
		menuPriceMap.put("딸기요거트", 4500);
		menuPriceMap.put("밀크티", 3500);
		menuPriceMap.put("카페라떼", 3500);
		menuPriceMap.put("아메리카노", 2000);

		inventoryMap.put("딸기요거트", inventory);
		inventoryMap.put("밀크티", inventory);
		inventoryMap.put("카페라떼", inventory);
		inventoryMap.put("아메리카노", inventory);
		
	}

	public void offerOrder(Order order) {
		orderQ.offerLast(order);
	}
	
	public Deque<Order> getOrderQ() {
		return orderQ;
	}

	public Menu getMenu(String name, int count) throws KisokException {
		if (menuPriceMap.containsKey(name)) {
			return new Menu(name, menuPriceMap.get(name), count);
		} else {
			throw new KisokException(101);
		}
	}
	
	public void subInventory(List<Menu> menus) {
		for (Menu m : menus) {
			int inv = inventoryMap.get(m.name);
			inventoryMap.replace(m.name, inv-m.count);
		}
		
		System.out.print("현재 재고상황: ");
		System.out.println(inventoryMap.toString());
	}
	
	private boolean isInventory(List<Menu> menus) {
		for (Menu m : menus) {
			int inv = inventoryMap.get(m.name);
			if (inv < m.count ) {
				return false;
			}
		}
		return true;
	}
	
	public Order initOder(List<Menu> menus, int orderType) throws KisokException {
	
		if (isInventory(menus)) {
			if (orderType == 1) {
				DeliveryOrder order = new DeliveryOrder(menus);
				order.setOnDelivery(this);
				return order;
			} else if (orderType == 2){
				TakeoutOrder order = new TakeoutOrder(menus);
				order.setOnTakeout(this);
				return order;
			} else {
				HereOrder order = new HereOrder(menus);
				order.setOnHere(this);
				return order;
			}
		} else {
			System.out.println("재고가 부족합니다.");
			throw new KisokException(102);
		}
	}
	
	@Override
	public void successDelivery(String locate, List<Menu> menus) {
		System.out.println(locate + " 주소로 배달 주문이 완료 되었습니다.");
		System.out.println("주문 내역----------------- ");
		for (Menu m : menus) {
			System.out.println(m.name + " " + m.count + "개");
		}
		System.out.println("------------------------");
		subInventory(menus);		
	}
	@Override
	public void successHere(int change, int orderNum, List<Menu> menus) {
		System.out.println("잔돈 "+change+"입니다. ");
		System.out.println(orderNum+ " 주문번호로 주문 완료되었습니다.");
		System.out.println("주문 내역----------------- ");
		for (Menu m : menus) {
			System.out.println(m.name + " " + m.count + "개");
		}
		System.out.println("------------------------");
		subInventory(menus);		
	}
	@Override
	public void successTakeout(int change, int time, List<Menu> menus) {
		System.out.println("잔돈 "+change+"입니다. ");
		System.out.println(time+ " 분후 포장주문 완료되었습니다.");
		System.out.println("주문 내역----------------- ");
		for (Menu m : menus) {
			System.out.println(m.name + " " + m.count + "개");
		}
		System.out.println("------------------------");
		subInventory(menus);	
	}
	
	@Override
	public void outDelivery(String locate, List<Menu> menus) {
		System.out.println("-------------------------");
		System.out.println("주문 하신 "+menus.size() +"개 메뉴 ");
		System.out.println(locate + " 주소로 배달이 시작되었습니다.");
		System.out.println("-------------------------");

	}
	
	@Override
	public void outHere(int orderNum, List<Menu> menus) {
		System.out.println("-------------------------");
		System.out.println(orderNum + "번 고객님");
		System.out.println("주문 하신 "+menus.size() +"개 메뉴 나왔습니다.");
		System.out.println("-------------------------");
	}
	
	@Override
	public void outTakeout(int time, List<Menu> menus) {
		System.out.println("-------------------------");
		System.out.println("주문 하신 "+menus.size() +"개 메뉴 ");
		System.out.println(time +"분 지나 포장주문 나왔습니다.");
		System.out.println("-------------------------");

	}
	
}

class KisokException extends Exception {
	public int code;
	
	public KisokException(int code) {
		 this.code = code;
	}
}