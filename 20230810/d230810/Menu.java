package d230810;

public class Menu {
	public String name;
	public int price;
	public int count;
	
	public Menu(String name, int price, int count){
		this.name = name;
		this.price =price*count;
		this.count = count;
	}
	
}