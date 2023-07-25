// 20230725_7일차
// 실습2: Scanner를 통해 초(sec) 값을 입력받고 입력받은 초를 시, 분, 초로 포맷하여 출력하는 프로그램 만들기

package test;

import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("변환할 초를 정수로 입력하세요: ");
		int input_sec = scanner.nextInt();
		
		int time = (input_sec/60) / 60;
		int min = (input_sec/60) % 60;
		int sec = input_sec % 60;
		
		System.out.println("변환된 포맷은 시간:" + time + " 분:" + min + " 초:" + sec + " 입니다.");
		
		scanner.close();
	}

}
