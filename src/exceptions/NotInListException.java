/**
 * 
 */
package exceptions;

/**
 * @author sopr099
 *
 */
public class NotInListException extends Exception {

	public NotInListException() {
		super("Der Eintrag befindet sich nicht in der Liste.");
	}
}

