package d230807_2;

// 키오스크 클래스에 두 개의 맵구조 추가
// 메뉴 이름과 가격이 맵핑되어 있는 맵구조
// 메뉴 이름과 재고 개수가 맵핑되어 있는 맵구조
// 메뉴 이름과 가격을 맵핑하여 키오스크 생성자에서 초기화
// 메뉴 이름에 사용자가 입력한 재고 개수로 전부 초기화 (키오스크 생성자)

// 키오스크에는 추가로 Menu클래스의 인스턴스를 만들고 반환하는 메소드 정의 (메인메소드에서 Menu 직접초기화 X)

// 맵구조를 활용하여 isInventory와 subInventory 메소드 수정
// 주문에 있는 메뉴 리스트를 반복하여 전부 체크하는 방식으로 수정

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import d230807_2.DeliveryOrder.OnDelivery;
import d230807_2.HereOrder.OnHere;
import d230807_2.TakeoutOrder.OnTakeout;

public class Kiosk implements OnDelivery, OnHere, OnTakeout{
	public static int key = 3;
	private int inventory;
	private Deque<Order> orderQ;
	// 키오스크 클래스에 두 개의 맵구조 추가(메뉴이름과 가격, 메뉴이름과 재고개수)
	Map<String, Integer> menuMap;
	Map<String, Integer> invenMap;
	
	// 메뉴 이름에 사용자가 입력한 재고 개수로 전부 초기화 (키오스크 생성자)
	public Kiosk(int inventory) {
		this.inventory = inventory;
		orderQ = new LinkedList<Order>();
		
		menuMap = new HashMap<String, Integer>();
		invenMap = new HashMap<String, Integer>();

		invenMap.put("딸기요거트", inventory);
		invenMap.put("카페라떼", inventory);
		invenMap.put("밀크티", inventory);
		invenMap.put("아메리카노", inventory);
	}
	
	// Menu클래스의 인스턴스를 만들고 반환하는 메소드 정의
	public int getPrice(String name, int count) throws KisokException{
		Menu menu = new Menu(name, count);
		return menu.price;
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

	public void offerOrder(Order order) {
		orderQ.offerLast(order);
	}
	
	public void outOrder() {
		if (orderQ.size() >= 3) {
			Order order = orderQ.pollFirst();
			order.outOrder();
		}
	}
	
	// 맵구조를 활용하여 isInventory와 subInventory 메소드 수정
	public void subInventory(List<Menu> menus) {
		for (Menu m: menus) {
			int inv = invenMap.get(m.name);
			invenMap.replace(m.name, inv - m.count);
		}
		
		System.out.print("현재 재고상황: ");
		System.out.println(invenMap.toString());
		
	}
	
	// 주문에 있는 메뉴 리스트를 반복하여 전부 체크하는 방식으로 수정
	private boolean isInventory(List<Menu> menus) {
		for (Menu m: menus) {
			int inv = invenMap.get(m.name);
			if (inv < m.count) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void successDelivery(String locate, List<Menu> menus) {
		System.out.println(locate + " 주소로 배달 주문이 완료 되었습니다.");
		System.out.print("주문 내역--------------\n");
		for (Menu m: menus) {
			System.out.println(m.name + " " + m.count + "개");
		}
		System.out.println("---------------------");
		subInventory(menus);		
	}
	@Override
	public void successHere(int change, int orderNum, List<Menu> menus) {
		System.out.println("잔돈 "+change+"입니다. ");
		System.out.println(orderNum+ " 주문번호로 주문 완료되었습니다.");
		System.out.print("주문 내역--------------\n");
		for (Menu m: menus) {
			System.out.println(m.name + " " + m.count + "개");
		}
		System.out.println("---------------------");
		subInventory(menus);		
	}
	@Override
	public void successTakeout(int change, int time, List<Menu> menus) {
		System.out.println("잔돈 "+change+"입니다. ");
		System.out.println(time+ " 분후 포장주문 완료되었습니다.");
		System.out.print("주문 내역--------------\n");
		for (Menu m: menus) {
			System.out.println(m.name + " " + m.count + "개");
		}
		System.out.println("---------------------");
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