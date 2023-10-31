package dev.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyRoom {

	public static void main(String[] args) {
		
		// 1. XML 파일을 사용하지만 Annotation이 적용되어 보다 간소화된 방식, field 기반 주입
		ApplicationContext context = new ClassPathXmlApplicationContext("component-scan-config.xml");
		
		TapeReader reader = context.getBean(TapeReader.class);
		System.out.println(reader);
		
		reader.test();

	}

}
