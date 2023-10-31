package dev.summer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DrinkTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("dev.summer");
		
		Drink drink = context.getBean(Drink.class);	
		System.out.println(drink);
		

	}

}
