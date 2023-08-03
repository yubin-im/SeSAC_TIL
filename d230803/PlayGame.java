package d230803;

import java.util.Scanner;

public class PlayGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
			
		System.out.println("플레이어수와 사다리 층수를 입력해 주세요");
		int playerNum = scanner.nextInt();
		int floorNum = scanner.nextInt();
		
		Ladder ladder = new Ladder(floorNum, playerNum);
		int[] rankArray = ladder.getRankArray();
		int[][] map = ladder.getMap();
		
		System.out.println("플레이어수만큼 등수를 정해주세요");
		for (int i = 0; i < playerNum; i++) {
			int rank = scanner.nextInt();
			rankArray[i] = rank;
		}
		
		
		

		
		System.out.println("-----확인용 map:");
		for(int[] vec: map) {
			for(int i: vec) {
				System.out.print(i + " ");
			}
			System.out.println("");
		}
		System.out.println("-----확인용 rankArray:");
		for(int i: rankArray) {
			System.out.print(i + " ");
		}
		
		
		scanner.close();
	}
}
