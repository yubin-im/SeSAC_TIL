package d230802_2;

import java.util.Scanner;

public class PlayGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("플레이어수와 사다리 층수를 입력해 주세요");
		int playerNum = scanner.nextInt();
		int floorNum = scanner.nextInt();

		Ladder ladder = new Ladder(playerNum, floorNum);
		ladder.show();

		System.out.println("플레이어수만큼 등수를 정해주세요");
		int[] rank = new int[playerNum];
		for (int i = 0; i < playerNum; i++) {
			rank[i] = scanner.nextInt();
		}
		ladder.setRank(rank);

		for(int i = 0; i < playerNum; i++) {
			Player player = new Player(i);
			int rat = player.runLadder(ladder.map, ladder.rankArray);
			System.out.println(i + 1 + "번째 플레이어의 등수는 " + rat);
		}

		scanner.close();
	}
}
