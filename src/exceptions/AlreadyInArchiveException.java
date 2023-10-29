package exceptions;

/**
 * Exception, die geworfen wird, wenn versucht wird einen Eintrag ins Archiv einzufuegen, den es schon gibt.
 * 
 * @author sopr096
 *
 */
public class AlreadyInArchiveException extends Exception {
	public AlreadyInArchiveException(String name){
		super("Der Eintrag " + name + " befindet sich bereits im Archiv.");
	}
}
