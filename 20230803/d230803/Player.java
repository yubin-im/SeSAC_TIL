package d230803;

//해당 번호의 플레이어가 Ladder의 사다리 맵을 타는 기능

public class Player {
    private int pNum;

    public Player(int pNum) {
        this.pNum = pNum;
    }

    public int runLadder(int[][] map, int[] rank) {
        int p = pNum;
        for (int i = 0; i < map.length; i++) {
            int go = map[i][p];
            if (go == 1) {
                p += 1;
            } else if (go == 2) {
                p -= 1;
            }
        }
        return rank[p];
    }
}