// 20230726
// 실습7: 간단한 키오스크 만들기2
package d230726;

import java.util.Scanner;

public class Ex7 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int price = 0;
		
		while (true) {
			System.out.println("메뉴 개수 입력");
			
			String menu = scanner.next();			
			if (menu.equals("종료")) {
				System.out.println("프로그램 종료");
				break;
			}
			int num = scanner.nextInt();
			
			if (menu.equals("딸기요거트")) {
				price = 4500 * num;
			} else if (menu.equals("밀크티") || menu.equals("카페라떼")) {
				price = 3500 * num;
			} else if (menu.equals("아메리카노")) {
				price = 2000 * num;
			} else {
				System.out.println("메뉴가 없습니다");
				continue;
			}
			
			if (price != 0) {
				System.out.println("총가격은 " + price + "원입니다");
				int money = scanner.nextInt();
				int change = money - price;
				
				if (change >= 0) {
					System.out.println("잔돈 " + change + "원 입니다");
					for(int i=1; i<=num; i++) {
						System.out.println(menu + " 나왔습니다.");
					}
				} else {
					System.out.println("금액이 부족합니다");
				}
			}
		}
		scanner.close();
	}
}
