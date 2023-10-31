package dev.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyRoom {

	public static void main(String[] args) {
		
		// 1. 별도의 XML 설정 파일 없이, Annotation 기반으로 빈을 등록하고, 컨테이너를 설정 
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaBasedConfig.class);
		
		String[] beanNames = context.getBeanDefinitionNames();
		
		for (String beanName: beanNames) {
			Object bean = context.getBean(beanName);
			System.out.println("beanName: " + beanName + ", bean: " + bean);
		}
		
		TapeReader reader = context.getBean(TapeReader.class);
		System.out.println(reader);
		
		reader.test();

	}

}
