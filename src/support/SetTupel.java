package support;
import java.util.TreeSet;
import java.util.SortedSet;

import model.DiaryEntry;

/**
 * @author sopr099
 *  Hilfsklasse damit aus zwei ArrayListen, ein Tupel entsteht.
 * 
 */
public class SetTupel {

	@SuppressWarnings("unused")
	private SortedSet<DiaryEntry> firstSet;

	@SuppressWarnings("unused")
	private SortedSet<DiaryEntry> secondSet;

	/**
	 * Übergabe Objekt für compare(), welches die beiden zu vergleichenden Listen beeinhaltet
	 * @param firstList = erste ArrayListe
	 * @param secondList = zweite ArrayListe 
	 */
	public SetTupel(SortedSet<DiaryEntry> firstSet, SortedSet<DiaryEntry> secondSet) {
		this.firstSet = firstSet;
		this.secondSet = secondSet;
	}

}
