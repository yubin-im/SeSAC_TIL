package d230807_2;

// 키오스크 실습에 맵구조 추가

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunKiosk {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("키오스크 키를 입력해주세요");
		int key = scanner.nextInt();
		
		if (Kiosk.key == key) {
			System.out.println("재고개수를 입력해주세요");
			int inventory = scanner.nextInt();
			
			Kiosk kiosk = new Kiosk(inventory);
			while (true) {
				try {
					System.out.println("1.배달 2.포장 3.매장 4.종료 주문방식 번호를 입력해주세요");
					int orderCode = scanner.nextInt();
					if (orderCode == 4) {
						System.out.println("프로그램을 종료 합니다.");
						break; 
					}
					
					List<Menu> menus = new ArrayList<Menu>();
					while (true) {
						System.out.println("<메뉴 개수> 또는 <주문>을 입력해주세요");
						String menu = scanner.next();
						if (menu.equals("주문")) {
							break;
						}
						int count = scanner.nextInt();
						menus.add(new Menu(menu, count));
					}
					
					Order order = kiosk.initOder(menus,
							orderCode);
					
					int deposit = scanner.nextInt();
					if (order.orderType == 1) {
						System.out.println("주소를 입력해주세요");
						String locate = scanner.next();
						((DeliveryOrder) order).setLocate(locate);
					} else if (order.orderType == 2) {
						System.out.println("포장시간을 입력해주세요");
						int time = scanner.nextInt();
						((TakeoutOrder) order).setTime(time);
					} else {
						System.out.println("주문번호를 입력해주세요");
						int orderNum = scanner.nextInt();
						((HereOrder) order).setOrderNum(orderNum);
					}
					order.runOrder(deposit);
					kiosk.offerOrder(order);
					kiosk.outOrder();
				} catch (KisokException e) {
					System.out.println("error code: " + e.code);
				}
			}
			
		} else {
			System.out.println("키오스크 키가 맞지 않습니다.");
		}

		scanner.close();
	}

}