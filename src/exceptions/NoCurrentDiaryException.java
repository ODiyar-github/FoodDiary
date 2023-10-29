package exceptions;

public class NoCurrentDiaryException extends Exception {
	public NoCurrentDiaryException(){
		super("Es ist kein Tagebuch geladen.");
	}
}
