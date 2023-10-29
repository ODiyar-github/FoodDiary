package exceptions;
/**
 * Exception, die geworfen wird, wenn versucht wird ein Medikament zu bearbeitn, ohne eins auszuwählen.
 * 
 * @author sopr096
 *
 */
public class NoCurrentDrugException extends Exception{
	public NoCurrentDrugException(){
		super("Bitte ein Medikament auswählen.");
	}
}
