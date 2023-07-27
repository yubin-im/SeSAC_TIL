// 20230727
package d230727;

import java.util.Scanner;

public class Kiosk_main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("키오스크 키를 입력해주세요");
		int key = scanner.nextInt();
		
		if(Kiosk.KEY == key) {
			System.out.println("매장 재고개수를 입력해주세요");
			int stock = scanner.nextInt();
			
			while (true) {
				System.out.println("메뉴와 개수를 입력해주세요");
				String menu = scanner.next();
				if (menu.equals("종료")) {
					System.out.println("프로그램 종료");
					break;
				}
				int order = scanner.nextInt();
				
				Kiosk kiosk = new Kiosk(stock);
				
				if (kiosk.isInventory(order) == true) {
					Order order1 = kiosk.initOrder(menu, order);
					if (order1 != null) {
						System.out.println(order1.getOrderPrice() + "원 입니다");
						
						int deposit = scanner.nextInt();
						
						if (order1.runOrder(deposit) == true) {
							int change = deposit - order1.getOrderPrice();
							System.out.print("잔돈 " + change + "와 ");
							System.out.println(menu + " 나왔습니다.");
							}
					} else if (order1 == null){
						continue;
						}
				} else {
					System.out.println("재고가 부족합니다.");
				}

			}	
			
		}
		scanner.close();

	}

}
