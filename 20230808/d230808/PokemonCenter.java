package d230808;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PokemonCenter {
	Random random = new Random();
	PokemonArchive pa;
	Pokemon pk;
	
	// 출현 가능한 포켓몬이름 배열을 필드로 할당
	String[] pkName = {"파이리", "꼬북이", "이상해씨"};
	
	Map<String, Object> statMap;
	Map<String, Object> inPokemonMap;
	Map<String, Integer> skillMap;
	List<String> typeList;
	
	// 생성자에서 포켓몬아카이브 인스턴스를 인자로 받아 필드로 할당
	public PokemonCenter(PokemonArchive pa) {
		this.pa = pa;
	}
	
	// 포켓몬 생성 메소드 정의, 밑에 두 메소드를 활용하여 포켓몬 인스턴스를 반환
	
	
	
	// 포켓몬 스텟 초기화 메소드 정의
	public void setStat(String pkName) {
		statMap = new LinkedHashMap<>();
		inPokemonMap = new LinkedHashMap<>();
		inPokemonMap = pa.pokemonMap.get(pkName);
		
		// 스탯은 해당 포켓몬의 기본 스탯을 따르되
		// hp, power, speed는 기본값에서 -10~+10의 범위로 랜덤하게 선택됨
		int hp = ((int) inPokemonMap.get("hp")) + (random.nextInt(21) - 10);
		int power = ((int) inPokemonMap.get("power")) + (random.nextInt(21) - 10);
		int speed = ((int) inPokemonMap.get("speed")) + (random.nextInt(21) - 10);
		
		statMap.put("pkName", pkName);
		statMap.put("hp", hp);
		statMap.put("power", power);
		statMap.put("type", inPokemonMap.get("type"));
		statMap.put("speed", speed);
		
		System.out.println("현재 체력 " + hp);
		System.out.println("능력창 " + statMap.toString());
	}
	
	// 포켓몬 스킬 초기화 메소드 정의
	public void setSkill(String pkName) {
		skillMap = new LinkedHashMap<>();
		inPokemonMap = new LinkedHashMap<>();
		typeList =  new ArrayList<>();
		
		inPokemonMap = pa.pokemonMap.get(pkName);
		String type = (String) inPokemonMap.get("type");
		
		typeList = pa.typeMap.get(type);
		
		// 스킬은 타입에 맞게 랜덤하게 2개가 선택된다
		while(skillMap.size() < 2) {
			int randomIndex = random.nextInt(typeList.size());
			
			String skill = typeList.get(randomIndex);
			int skillPower = pa.skillMap.get(skill);
			
			skillMap.put(skill, skillPower);
		}
		
		System.out.println("스킬창 " + skillMap.toString());
	}
	
	// 이후 유즈케이스에 맞추어 추가 메소드 구성
	
	
	
}
