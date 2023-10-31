package dev.spring.step02factory;

// TapeReader를 생성해주는 공장(Factory)
public class TapeReaderFactory {
	
	public TapeReader createTapeReader() {
		return new TapeReader();
	}

}
