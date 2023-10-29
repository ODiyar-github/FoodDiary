package exceptions;

public class NoValidUnitException extends Exception {
	public NoValidUnitException(){
		super("Diese Einheit wird nicht unterstützt.");
	}
}
