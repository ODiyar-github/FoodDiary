package exceptions;

public class DiaryAlreadyExistsException extends Exception {
	public DiaryAlreadyExistsException(){
		super("Es gibt schon ein Tagebuch mit diesem Namen");
	}
}
