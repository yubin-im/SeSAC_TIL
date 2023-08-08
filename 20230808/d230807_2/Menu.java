package d230807_2;

// 생성자는 메뉴이름, 가격, 개수를 입력받고 필드로 할당
// 가격 필드는 개수만큼의 총가격으로 세팅

import java.util.HashMap;
import java.util.Map;

public class Menu {
	public String name;
	public int price;
	public int count;
	Map<String, Integer> menuMap;
	
	public Menu(String name, int count) throws KisokException {
		this.name = name;
		this.count = count;
		menuMap = new HashMap<String, Integer>();

		menuMap.put("딸기요거트", 4500);
		menuMap.put("카페라떼", 3500);
		menuMap.put("밀크티", 3500);
		menuMap.put("아메리카노", 2000);
		
		if (name.equals("딸기요거트")) {
			price = menuMap.get(name) * count;
		} else if (name.equals("카페라떼")) {
			price = menuMap.get(name) * count;
		} else if (name.equals("밀크티")) {
			price = menuMap.get(name) * count;
		} else if (name.equals("아메리카노")) {
			price = menuMap.get(name) * count;
		} else {
			price = 0;
			throw new KisokException(101);
		}

		
	}
	
}