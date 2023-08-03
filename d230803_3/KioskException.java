package d230803_3;

public class KioskException extends Exception{
	public int code;
	
	public KioskException(String message, int code) {
		super(message);
		this.code = code;
	}
}
