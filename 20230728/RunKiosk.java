package d230728;

import java.util.Scanner;

public class RunKiosk {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int deposit = 0;
		
		System.out.println("재고개수를 입력해주세요");
		int inventory = scanner.nextInt();
		Kiosk kiosk = new Kiosk(inventory);
		
		while (true) {
			System.out.println("1.배달 2.포장 3.매장 주문방식 번호를 입력해주세요");
			int orderWay = scanner.nextInt();
			
			System.out.println("메뉴와 개수를 입력해주세요");
			String menu = scanner.next();
			int count = scanner.nextInt();
			
			if (kiosk.isInventory(count) == true) {
				Order order = kiosk.initOrder(menu, count);
				int orderPrice = order.orderPrice;
				
				if (order != null) {
					if (orderWay == 1) {
						DeliveryOrder dO = new DeliveryOrder(menu, count, orderPrice);
						//dO.setOrderPrice(orderPrice);
						deposit = scanner.nextInt();
						
						System.out.println("주소를 입력해주세요");
						String address = scanner.next();
						dO.setLocate(address);

					} else if (orderWay == 2) {
						TakeoutOrder tO = new TakeoutOrder(menu, count, orderPrice);
						//tO.setOrderPrice(orderPrice);
						deposit = scanner.nextInt();
						
						if (order.runOrder(deposit) == true) {
							System.out.println("포장시간을 입력해주세요");
							int time = scanner.nextInt();
							
							System.out.println("잔돈 " + (deposit - (orderPrice-500)) + "입니다.");
							tO.setTime(time);
							
							System.out.println("주문번호를 입력해주세요");
							int orderNum = scanner.nextInt();
							tO.runOrder(orderNum);
						}
							
					} else if (orderWay == 3) {
						System.out.println(orderPrice + "원 입니다.");
						deposit = scanner.nextInt();
						
						System.out.println("주문번호를 입력해주세요");
						int orderNum = scanner.nextInt();
						
						HereOrder hO = new HereOrder(menu, count, orderPrice);
						if (order.runOrder(deposit) == true) {
							System.out.println("잔돈 " + (deposit - order.getOrderPrice()) + "입니다.");
							hO.setOrderNum(orderNum);
						}
					}
				}
			} else {
				System.out.println("재고가 부족합니다.");
			}
		}
	}
}
