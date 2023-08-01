package d230731;

public class KioskException extends Exception{
	public int code;
	
	public KioskException(String message, int code) {
		super(message);
		this.code = code;
		System.out.println(message + ": " + code);
	}
}
