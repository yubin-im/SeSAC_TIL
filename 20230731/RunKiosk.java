package d230731;

import java.util.Scanner;

public class RunKiosk {
	
	public static void main(String[] args) throws KioskException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("키오스크 키를 입력해주세요(3)");
		int key = scanner.nextInt();

		if (Kiosk.key == key) {
			System.out.println("재고개수를 입력해주세요");
			int inventory = scanner.nextInt();
			Kiosk kiosk = new Kiosk(inventory);
			
			while (true) {
				System.out.println("1.배달 2.포장 3.매장 주문방식 번호를 입력해주세요");
				int orderCode = scanner.nextInt();
				
				System.out.println("메뉴와 개수를 입력해주세요");
				String menu = scanner.next();
				if (menu.equals("종료")) {
					System.out.println("프로그램을 종료 합니다.");
					break;
				}
				int count = scanner.nextInt();

//				if (order == null) {
//					continue;
//				}
				
				try {
					Order order = kiosk.initOder(menu, count, orderCode);
					int deposit = scanner.nextInt();
					if (orderCode == 1) {
						System.out.println("주소를 입력해주세요");
						String locate = scanner.next();
						((DeliveryOrder) order).setLocate(locate);
					} else if (orderCode == 2) {
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
					continue;
				}	
			}
		} else {
			System.out.println("키오스크 키가 맞지 않습니다.");
		}
		scanner.close();
	}
}
