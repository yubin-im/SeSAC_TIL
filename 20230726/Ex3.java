// 20230726
// 실습3: 목록에 있는 음료를 입력하면 해당 음료의 가격이 출력됩니다.
package d230726;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// 음료 가격
		int sy = 4500;
		int mt = 3500;
		int cl = 3500;
		int ia = 2000;
		
		System.out.print("음료 메뉴 입력: ");
		String menu = scanner.next();
		
		if (menu.equals("딸기요거트")) {
			System.out.print(menu + "는 " + sy + "원입니다");
			int money = scanner.nextInt();
			if (money >= sy) {
				System.out.println("잔돈 " + (money - sy) + "원입니다");
				} else {
					System.out.println("금액이 부족합니다");
				}
		} else if (menu.equals("밀크티")) {
			System.out.print(menu + "는 " + mt + "원입니다");
			int money = scanner.nextInt();
			if (money >= mt) {
				System.out.println("잔돈 " + (money - mt) + "원입니다");
				} else {
					System.out.println("금액이 부족합니다");
				}
		} else if (menu.equals("카페라떼")) {
			System.out.print(menu + "는 " + cl + "원입니다");
			int money = scanner.nextInt();
			if (money >= cl) {
				System.out.println("잔돈 " + (money - cl) + "원입니다");
				} else {
					System.out.println("금액이 부족합니다");
				}
		} else if (menu.equals("아메리카노")) {
			System.out.print(menu + "는 " + ia + "원입니다");
			int money = scanner.nextInt();
			if (money >= ia) {
				System.out.println("잔돈 " + (money - ia) + "원입니다");
				} else {
					System.out.println("금액이 부족합니다");
				}
		} else {
			System.out.println("메뉴가 없습니다");
		}
		scanner.close();
	}
}
