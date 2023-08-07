package d230804;

// 키오스크에 주문 대기열 추가하기
// 주문이 만들어지면 주문 대기열에 추가 된다.
// 주문 대기열에 주문이 3개 이상이면 제일 처음 추가된 주문을 제거하고 문구를 출력한다.
/* 배달: 00주소로 배달이 시작되었습니다.
 * 포장: 포장주문하신 메뉴 나왔습니다.
 * 매장: 00번호 주문 메뉴 나왔습니다.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class RunKiosk {
	
	public static void main(String[] args) throws KioskException {
		Scanner scanner = new Scanner(System.in);
		String input_menu = null;		
		// WaitOrder waitOrder = new WaitOrder();
		Queue<Order> waitqueue = new LinkedList<Order>();
		
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
				//
				List<Menu> menuArray = new ArrayList<Menu>();
				
				int menuCount = 0;
				
				while (menuCount < 10) {
					System.out.println("메뉴 또는 주문을 입력해주세요");
					input_menu = scanner.next();
					
					if (input_menu.equals("주문")) {
						break;
					}	
					menuArray.add(new Menu(input_menu));
					menuCount++;
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
					
					// 주문 대기열 추가
					waitqueue.offer(order);
					
					if (waitqueue.size() >= 3) {	
						Order pollOrder = waitqueue.poll();
						pollOrder.outOrder();
						
					}
					
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
