package d230808;

import java.util.Map;

public class Pokemon {
	// 포켓몬 닉네임(문자열), 포켓몬 현재체력(정수), 포켓몬 스텟(맵), 포켓몬 스킬(맵) 필드 구성
	String pkNname;
	int power;
	Map<String, Object> statMap;
	Map<String, String> skillMap;
	
	// Pokemon 생성자
	public Pokemon() {
		
	}

	
	// 유즈케이스에 맞게 이후 메소드 구성

	// 현재 체력
	public void getHp(int[][] pkStat, String pkNname) {
		
		System.out.println("현재 체력 ");
	}

}
