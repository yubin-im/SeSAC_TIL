// 20230726
// (정답)실습3: 목록에 있는 음료를 입력하면 해당 음료의 가격이 출력됩니다.
package d230726;

import java.util.Scanner;

public class Ex3_ans {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("음료 메뉴 입력: ");
		String menu = scanner.next();
		
		int price = 0;
		
		switch(menu) {
			case "딸기요거트":{
				price = 4500;
				break;
			}
			case "밀크티":
			case "카페라떼":{
				price = 3500;
				break;
			}
			case "아메리카노":{
				price = 2000;
				break;
			}
			default:{
				System.out.println("메뉴에 없습니다");
			}
		}
		
		/* if문 사용
		if (menu.equals("딸기요거트")) {
			price = 4500;
		} else if (menu.equals("카페라떼") || menu.equals("밀크티")) {
			price = 3500;
		} else if (menu.equals("아메리카노")) {
			price = 2000;
		} else {
			System.out.println("메뉴가 없습니다");
		}
		 */
		
		if(price != 0) {
			System.out.println(menu + "는 " + price + "원입니다");
			int money = scanner.nextInt();
			int change = money - price;
			
			if (change >= 0) {
				System.out.println("잔돈 " + change + "원입니다");
			} else {
				System.out.println("금액이 부족합니다");
			}
		}
		scanner.close();
	}                                                                                                                                                                                                                                                        
}
