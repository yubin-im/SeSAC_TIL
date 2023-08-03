package d230802_2;

// 2차원 배열의 사다리맵을 만들고 필드로 저장하는 기능
// 도착지점의 등수를 배열로 입력받아 필드로 저장하는 기능

public class Ladder {
	int[][] map;
	int[] rankArray;
	
	public Ladder(int playerNum, int floorNum) {
		this.map = new int[playerNum][floorNum];
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
