package d230803;

// 2차원 배열의 사다리맵을 만들고 필드로 저장하는 기능
// 도착지점의 등수를 배열로 입력받아 필드로 저장하는 기능

import java.util.Random;

public class Ladder {
	Random random = new Random();

	int[][] map;
	int[] rankArray;
	
	public Ladder(int floorNum, int playerNum) {
		this.map = new int[floorNum][playerNum];
		this.rankArray = new int[playerNum];
			
		// [입력층수][플레이어수] 크기의 map 만들기
		// 1의 오른쪽은 2가 와야함, 1열은 2가 오면 안됨, 4열은 1이 오면 안됨
		for(int i = 0; i < floorNum; i++) {
			for(int j = 0; j < playerNum; j++) {
				map[i][j] = random.nextInt(3);
				if (j != 0) {
					if (map[i][j-1] == 1) {
						map[i][j] = 2;
					}
				}

				if (j != 0) {
					if (map[i][j-1] == 2) {
						map[i][j] = 0;
					}
				}
				
				if (map[i][0] == 2) {
					map[i][0] = random.nextInt(2);
				}
				if (map[i][playerNum-1] == 1) {
					int not1 = random.nextInt(2);
					map[i][playerNum-1] = (not1 == 0) ? 0 : 2;
				}
			}
		}
	}

	public int[] getRankArray() {
		return rankArray;
	}

	public void setRankArray(int[] rankArray) {
		this.rankArray = rankArray;
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}


}
