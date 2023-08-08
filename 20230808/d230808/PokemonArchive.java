package d230808;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokemonArchive {
	// 메인에서 입력받은 배열로부터 다음과 같은 3개의 맵 구조의 필드 할당
	// 포켓몬이름= 맵(hp, power, speed, type) 구조의 맵
	Map<String, Map<String, Integer>> pokemonMap; 
	// 스킬이름= skillpower 구조의 맵
	Map<String, Integer> skillMap;
	// type값= 해당 타입 스킬이름의 리스트
	Map<String, List<String>> typeMap;
	
	
	// 생성자 또는 메소드를 활용하여 초기화
	public PokemonArchive(Map<String, Map<String, Integer>> pokemonMap, Map<String, Integer> skillMap,
			Map<String, List<String>> typeMap) {
		pokemonMap = new HashMap<String, Map<String, Integer>>();
		skillMap = new HashMap<String, Integer>();
		typeMap = new HashMap<String, List<String>>();
		
		
		
	}
	
	
	
	
	

}
