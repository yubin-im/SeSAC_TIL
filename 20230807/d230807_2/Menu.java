package d230807_2;

import java.util.HashMap;
import java.util.Map;

public class Menu {
	public String name;
	public int price;
	public int count;
	Map<String, Integer> menuMap = new HashMap<String, Integer>();
	
	public Menu(String name, int count) throws KisokException {
		this.name = name;
		this.count = count;
		menuMap = new HashMap<String, Integer>();
		
//		if (name.equals("딸기요거트")){
//			price = 4500;
//		} else if (name.equals("카페라떼") || name.equals("밀크티")){
//			price = 3500;
//		} else if (name.equals("아메리카노")){
//			price = 2000;
//		} else {
//			price = 0;
//			throw new KisokException(101);
//		}
		
		menuMap.put("딸기요거트", 4500);
		menuMap.put("카페라떼", 3500);
		menuMap.put("밀크티", 3500);
		menuMap.put("아메리카노", 2000);
		
		
		
	}
	
}