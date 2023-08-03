package d230803_2;

// 실습한 키오스크의 Menu 배열을 Menu 리스트로 수정하기

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunKiosk {
	
	public static void main(String[] args) throws KioskException {
		Scanner scanner = new Scanner(System.in);
		String input_menu = null;
		
		System.out.println("키오스크 키를 입력해주세요(3)");
		int key = scanner.nextInt();
		
		if (Kiosk.key == key) {
			System.out.println("재고개수를 입력해주세요");
			int inventory = scanner.nextInt();
			Kiosk kiosk = new Kiosk(inventory);
			
			while (true) {
				System.out.println("1.배달 2.포장 3.매장 4.종료 주문방식 번호를 입력해주세요");
				int orderType = scanner.nextInt();
				
				if (orderType == 4) {
					System.out.println("프로그램을 종료 합니다.");
					break;
				}
				List<Menu> menuArray = new ArrayList<Menu>();
				
				int count = 0;
				
				while (count < 10) {
					System.out.println("메뉴 또는 주문을 입력해주세요");
					input_menu = scanner.next();
					
					if (input_menu.equals("주문")) {
						break;
					}	
					menuArray.add(new Menu(input_menu));
					count++;
				}
					
				try {
					Order order = kiosk.initOder(menuArray, orderType);
					int deposit = scanner.nextInt();
					if (orderType == 1) {
						System.out.println("주소를 입력해주세요");
						String locate = scanner.next();
						((DeliveryOrder) order).setLocate(locate);
					} else if (orderType == 2) {
						System.out.println("포장시간을 입력해주세요");
						int time = scanner.nextInt();
						((TakeoutOrder) order).setTime(time);
					} else {
						System.out.println("주문번호를 입력해주세요");
						int orderNum = scanner.nextInt();
						((HereOrder) order).setOrderNum(orderNum);
					}
					order.runOrder(deposit);
				} catch (KioskException e) {
					System.out.println("error code: " + e.code);
				}	
			}
		} else {
			System.out.println("키오스크 키가 맞지 않습니다.");
		}
		scanner.close();
	}
}
