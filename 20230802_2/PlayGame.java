package d230802_2;

import java.util.Scanner;

public class PlayGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("플레이어수와 사다리 층수를 입력해 주세요");
		int playerNum = scanner.nextInt();
		int floorNum = scanner.nextInt();
		Ladder ladder = new Ladder(playerNum, floorNum);
		
		System.out.println("플레이어수만큼 등수를 정해주세요");
		for (int i=0; i < playerNum; i++) {
			int rank = scanner.nextInt();
			ladder.rankArray[i] = rank;
		}
		
		
		System.out.println("확인용");
//		for (int[] vec: ladder.map) {
//			for(int i: vec) {
//				System.out.println(i);
//			}
//			System.out.println("");
//		}
		
		for(int i: ladder.rankArray) {
			System.out.println(i + " ");
		}
		
		
		
		scanner.close();
	}
}
