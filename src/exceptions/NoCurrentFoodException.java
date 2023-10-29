package exceptions;
/**
 * Exception, die geworfen wird, wenn versucht wird ein Lebensmittel zu bearbeitn, ohne eins auszuwählen.
 * 
 * @author sopr096
 *
 */
public class NoCurrentFoodException extends Exception {
	public NoCurrentFoodException(){
		super("Bitte ein Lebensmittel auswählen.");
	}
}
