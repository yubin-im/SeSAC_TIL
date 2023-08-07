package d230804_2;

/* 
 * 게임이 시작되면 블록(정수)이 들어갈 수 있는 라인 개수를 입력
 * 블록은 1~라인개수*2 의 값 중 랜덤한 값이 나온다
 * 블록이 나오면 블록을 담을 라인 번호를 입력한다
 * 같은 라인에 같은 블록값 2개가 연속적으로 담기면 해당 2개 블록은 제거된다
 * 하나의 라인이라도 담긴 블록의 개수가 5개 이상이면 게임 종료
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// 라인 개수만큼 deque 생성

public class PlayTetris {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		List<Deque<Integer>> dequeList = new ArrayList<>();
		
		System.out.println("블록이 들어갈 라인의 개수를 입력하세요");
		int lineNum = scanner.nextInt();
		
		System.out.println("----------------------");
		int blockNum = random.nextInt(lineNum) + 1;
		System.out.println(blockNum + " 블록이 들어갈 라인의 번호를 입력하세요");
		
		
		
		for(int i = 0; i < lineNum; i++) {
			Deque<Integer> intDeque = new LinkedList<>();
			
			
			for(int j = 0; j < 5; j++) {
				intDeque.add(blockNum);
			}
			
			dequeList.add(intDeque);
		}
		
		
		
		for (int i = 0; i < dequeList.size(); i++) {
            Deque<Integer> intDeque = dequeList.get(i);
            System.out.println();
		}
		
		
		
		scanner.close();
	}
}
