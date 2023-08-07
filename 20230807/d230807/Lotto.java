package d230807;

//1개의 당첨 로또번호 랜덤하게 생성
//로또 번호를 비교하여 등수를 반환
//1등 전부맞음, 2등 1개빼고 맞음, 3등 2개빼고 맞음, 4등 3개빼고 맞음
//로또봇을 통해 생성한 로또번호의 등수 출력, 4등 이후는 꽝으로 출력

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Lotto {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashSet<TreeSet<Integer>> lottoSets = new HashSet<>();
		
		System.out.println("로또를 몇개 생성하시겠습니까?");
		int setCount = scanner.nextInt();

		// 사용자가 입력한 횟수만큼의 로또 생성
		for (int i = 0; i < setCount; i++) {
			LottoBot lottoBot = new LottoBot();
			TreeSet<Integer> lottoSet = lottoBot.lottoSet;
			lottoSets.add(lottoSet);
		}

		// 비교할 1개의 메인 로또번호 생성
		LottoBot lottoBot = new LottoBot();
		TreeSet<Integer> mainLotto = lottoBot.lottoSet;
		
		
		// 메인 로또와 생성된 로또 번호의 비교		
		for (TreeSet<Integer> lottoSet: lottoSets) {
			int matchCount = LottoBot.getMatchCount(lottoSet, mainLotto);
			
			if (matchCount == 3) {
	            System.out.println("4 등!");
	        } else if (matchCount == 4) {
	            System.out.println("3 등!");
	        } else if (matchCount == 5) {
	            System.out.println("2 등!");
	        } else if (matchCount == 6) {
	            System.out.println("1 등!");
	        } else {
	            System.out.println("꽝!");
	        }
		}


		// 확인용 출력
		System.out.println("---------------------------------");
		System.out.println("비교할 1개의 로또번호: ");
		for(Integer n : mainLotto) {
			System.out.print(n + " ");
		}
		System.out.println("\n");
		
		System.out.println("lottoSets: ");
		for (TreeSet<Integer> lottoSet: lottoSets) {
            System.out.println(lottoSet);
        }
		
		scanner.close();		
	}
			
		
}
	
	
	


