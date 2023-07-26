// 20230726
// (정답)실습4: 가위바위보 게임 만들기
package d230726;

import java.util.Scanner;

public class Ex4_ans {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("가위바위보 게임 입니다. 가위:1, 바위:2, 보:3");
		
		System.out.println("a 유저의 번호를 선택해주세요");
		int user_a = scanner.nextInt();
		System.out.println("b 유저의 번호를 선택해주세요");
		int user_b = scanner.nextInt();
		
		if (user_a == user_b) {
	    		System.out.println("비겼습니다");
	    	} else if (user_a == 1) {
	        	if (user_b == 2)
	        	System.out.println("b승리");
	        	else
	        	System.out.println("a승리");
	    	} else if (user_a == 2) {
	        	if (user_b == 1)
	        		System.out.println("a승리");
	       		else
	        		System.out.println("b승리");
	    	} else if (user_a == 3){
	        	if (user_b == 1)
	        		System.out.println("b승리");
	        	else
	        		System.out.println("a승리");
	    	}  
	    	scanner.close();
	}

}
