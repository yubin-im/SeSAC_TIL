package dev.spring.step01dependency;

public class Tape {
	String name;
	boolean isWorked;
	
	public Tape(String name, boolean isWorked) {
		super();
		this.name = name;
		this.isWorked = isWorked;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isWorked() {
		return isWorked;
	}

	public void setWorked(boolean isWorked) {
		this.isWorked = isWorked;
	}

}
