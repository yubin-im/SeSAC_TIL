package d230810_2;

// OTT 만들기 (새싹플릭스)

import java.util.Scanner;

public class RunOTT {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 사용자는 다음과 같이 컨텐츠 목록을 선택하여 볼 수 있다.
		System.out.println("1. 컨텐츠 순위 \n2. 영화 컨텐츠 \n3. 시리즈 컨텐츠 \n4. 관심목록 컨텐츠 \n");
		System.out.print("컨텐츠 번호를 입력해주세요: ");
		int runCode = scanner.nextInt();
		System.out.println();
		
		
		if (runCode == 1) {
			// 순위 컨텐츠는 영화, 시리즈 둘 다 표기된다.
			System.out.println("컨텐츠 순위!");
			
		} else if (runCode == 2) {
			// 영화 컨텐츠 목록은 영화 컨텐츠만 표기된다.
			MovieContents mc = new MovieContents();
			mc.movieContentsList();
			
		} else if (runCode == 3) {
			// 시리즈 컨텐츠 목록은 시리즈 컨텐츠만 표기된다.
			SeriesContents sc = new SeriesContents();
			sc.seriesContentsList();
			
		} else if (runCode == 4) {
			// 관심 컨텐츠는 영화, 시리즈 둘 다 표기된다.
			
		}
		
		

		
		scanner.close();
	}

}
