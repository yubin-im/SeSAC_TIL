package d230801;

import java.util.Random;
import java.util.Scanner;

public class CardGame {

	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		// 사용자, 컴퓨터 배열 초기화
		int[] playerArray = new int[4];
		int[] computerArray = new int[4];
		
		System.out.println("카드가 분배됩니다.");
		
		// 사용자, 컴퓨터 배열 랜덤 값 생성
		for (int i=0; i<playerArray.length; i++) {
			playerArray[i] = random.nextInt(10) + 1;
			computerArray[i] = random.nextInt(10) + 1;
			System.out.print(playerArray[i] + " ");
		}
		
		// 사용자 카드 선택 인덱스 받기
		System.out.println("두개의 카드를 선택해주세요 (인덱스 값으로 입력)");
		int playerindex1 = scanner.nextInt();
		int playerindex2 = scanner.nextInt();
		
		// 사용자가 선택한 카드 값 합
		int playerValue = playerArray[playerindex1] + playerArray[playerindex2];
		
		// 컴퓨터의 카드 값 중 가장 높은 값 2개의 합
		int computerNum1 = 0;
		int computerNum2 = 0;
		for (int j: computerArray) {
			if (j > computerNum1) {
				computerNum2 = computerNum1;
				computerNum1 = j;
			}
			else if (j > computerNum2) {
				computerNum2 = j;
			}
		}
		int computerValue = computerNum1 + computerNum2;
		
		System.out.print(playerValue + " vs " + computerValue);
		
		// 사용자와 컴퓨터의 카드 합 비교
		if (playerValue > computerValue) {
			System.out.println(" 플레이어의 승리 입니다.");
		} else if (playerValue < computerValue) {
			System.out.println(" 컴퓨터의 승리 입니다.");
		} else {
			System.out.println(" 동점입니다.");
		}
		
		
		System.out.println("-------------------확인용-------------------");
		System.out.println("컴퓨터 플레이어 배열: ");
		for (int j: computerArray) {
			System.out.print(j + " ");
		}
		System.out.println();
		System.out.println("컴퓨터 플레이어 배열 중 가장 높은 값 2개: " + computerNum1 + ", " + computerNum2);
		
		scanner.close();
	}
}
