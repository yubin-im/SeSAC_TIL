package d230808;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PokemonArchive {
	// 메인에서 입력받은 배열로부터 다음과 같은 3개의 맵 구조의 필드 할당
	// 포켓몬이름= 내부맵(hp= hp값, power= power값, speed= speed값, type= type값)
	Map<String, Map<String, Object>> pokemonMap; 
	// 스킬이름= skillpower
	Map<String, Integer> skillMap;
	// type값= 해당 타입 스킬이름의 리스트
	Map<String, List<String>> typeMap;
	
	
	// 생성자 또는 메소드를 활용하여 초기화
	public PokemonArchive(int[][] pkStat, String[] pkType, String[] pks, String[] skills, int[] skillPower, String[][] skillType) {
		pokemonMap = new LinkedHashMap<String, Map<String, Object>>();
		skillMap = new LinkedHashMap<String, Integer>();
		typeMap = new LinkedHashMap<String, List<String>>();
		
		// pokemonMap 맵 생성
		for (int i = 0; i < pks.length; i++) {
			// pokemonMap 맵의 내부맵 생성
			Map<String, Object> inPokemonMap = new LinkedHashMap<>();
			
			inPokemonMap.put("hp", pkStat[i][0]);
			inPokemonMap.put("power", pkStat[i][1]);
			inPokemonMap.put("speed", pkStat[i][2]);
			inPokemonMap.put("type", pkType[i]);
			
			pokemonMap.put(pks[i], inPokemonMap);
		}
		
		// skillMap 맵 생성
		for (int i = 0; i < skills.length; i++) {
			skillMap.put(skills[i], skillPower[i]);
		}
		
		// typeMap 맵 생성
		// 스킬 리스트 생성
		ArrayList<String> waterList = new ArrayList<String>();
		ArrayList<String> fireList = new ArrayList<String>();
		ArrayList<String> grassList = new ArrayList<String>();
		
		for (int i = 0; i < skillType.length; i++) {
			for (String type: skillType[i]) {
				if (type == "물") {
					waterList.add(skills[i]);
				} else if (type == "불") {
					fireList.add(skills[i]);
				} else if (type == "풀") {
					grassList.add(skills[i]);
				}
			}
		}
		
		typeMap.put("물", waterList);
		typeMap.put("불", fireList);
		typeMap.put("풀", grassList);
		
		
		
		// 확인용
//		System.out.println("pokemonMap 확인: \n" + pokemonMap.toString());
//		System.out.println("skillMap 확인: \n" + skillMap.toString());
//		System.out.println("typeMap 확인: \n" + typeMap.toString());
//		System.out.println();
		
	}

}
