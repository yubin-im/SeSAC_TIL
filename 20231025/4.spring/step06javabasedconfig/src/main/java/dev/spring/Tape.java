package dev.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component  // 해당 클래스를 bean으로 등록, 스캐닝 대상에 포함시킴
public class Tape {
	private String name; // 필드 기반 기본 값 지정
	private boolean isWorked; // true, false로 바꿔보기
	
	// 기본 생성자 지우면 주입, 기본 생성자 있을때는 여기다가 @Autowired 적으면 이 생성자로 주입됨
	public Tape(@Value("아일랜드") String name, @Value("true") boolean isWorked) {
		super();
		this.name = name;
		this.isWorked = isWorked;
	}

	public String getName() {
		return name;
	}

	public boolean isWorked() {
		return isWorked;
	}

}
