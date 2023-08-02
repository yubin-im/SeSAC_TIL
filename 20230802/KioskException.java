package d230802;

public class KioskException extends Exception{
	public int code;
	
	public KioskException(String message, int code) {
		super(message);
		this.code = code;
	}
}
