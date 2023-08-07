package d230803;

// 2차원 배열의 사다리맵을 만들고 필드로 저장하는 기능
// 도착지점의 등수를 배열로 입력받아 필드로 저장하는 기능

import java.util.Random;

public class Ladder {
	int[][] map;
	int[] rankArray;
	private int playerNum;
	private int floorNum;
	
	public Ladder(int playerNum, int floorNum) {
		this.map = new int[playerNum][floorNum];
		this.rankArray = new int[playerNum];
		this.playerNum = playerNum;
		this.floorNum = floorNum;
		setLadder();
	}

	private void setLadder() {
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());

		for (int i = 0; i < floorNum; i++) {
			for (int j = 0; j < playerNum; j++) {
				map[i][j] = 0;
			}
			int ladder = random.nextInt(playerNum-1);
			map[i][ladder] = 1;
			map[i][ladder+1] = 2;
		}
	}

	public void setRank(int[] rankArray) {
		this.rankArray = rankArray;
	}

	public void show() {
		for (int i = 0; i < floorNum; i++) {
			for (int j = 0; j < playerNum; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println("");
		}
	}


}
