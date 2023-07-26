// 20230726
// 실습5: for 문을 이용하여 19단 만들기, 곱해지는 숫자가 홀수인 경우만 출력하기
package d230726;

public class Ex5 {

	public static void main(String[] args) {
		int dan = 0;
		
		for(int i=1; i<20; i++) {
			if (i % 2 == 1) {
				dan = 19 * i;
				System.out.println("19 X " + i + " = " + dan);
			}
		}
	}
}
