package d230728;

public class Kiosk {
	protected int inventory;
	
	public Kiosk(int inventory) {
		this.inventory = inventory;
	}
	
	public Order initOrder(String menu, int count) {
		int menuPrice = 0;
		
		if (menu.equals("딸기요거트")) {
			menuPrice = 4500;
		} else if (menu.equals("밀크티") || menu.equals("카페라떼")) {
			menuPrice = 3500;
		} else if (menu.equals("아메리카노")) {
			menuPrice = 2000;
		} else {
			System.out.println("메뉴가 없습니다");
			return null;
		}
		
		if (menuPrice > 0) {
			subInventory(count);
		}
		
		Order order = new Order(menu, count, menuPrice);
		
		return order;
	}
	
	public boolean isInventory(int count) {
		boolean isInventory;
		
		if (this.inventory > count) {
			isInventory = true;
		} else {
			isInventory = false;
		}
		return isInventory;
	}
	
	
	public void subInventory(int count) {
		this.inventory = this.inventory - count;
	}

}
