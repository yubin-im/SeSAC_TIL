// 20230726
// 실습6: 로또 번호 뽑기
// 6개의 0~46의 랜덤한 숫자를 5회 뽑는 로또번호 뽑기 만들기
// 중첩 for 문 이용, 랜덤한 숫자 뽑기
package d230726;

import java.util.Random;

public class Ex6 {
	public static void main(String[] args) {
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		
		for (int i =1; i <= 5; i++) {
			System.out.print(i + " 번째 로또 뽑기 : ");
			
			for (int j = 1; j <= 6; j++) {
				System.out.print(random.nextInt(46) + " ");
			}
			System.out.println();
		}
	}
}
