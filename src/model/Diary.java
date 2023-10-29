package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.SortedSet;

/** Tagebuch eines Nutzers anlegen
 * 
 * Über diese Klasse können Tagebücher für Nutzer angelegt werden.
 * 
 * @author sopr097
 *
 */

public class Diary implements Serializable {

	/**
	 * Name des Tagebuchs
	 */
	private String name;

	/**
	 * Liste der unvertraeglichen Stoffe fuer den Nutzer des Tagebuchs
	 */
	private List<Ingredient> intolerance;

	/**
	 * Liste aller Eintraege dieses Tagebuchs
	 */
	private SortedSet<DiaryEntry> diaryEntrySet;

	
	/**
	 * Konstruktor des Diaries
	 * 
	 * @param name Name des Diaries
	 * @param intolerance Liste der unvertraeglichen Stoffe fuer den Nutzer des Tagebuchs
	 * @param diaryEntrySet Liste aller Eintraege dieses Tagebuchs
	 */
	public Diary(String name) {
		this.name = name;
		intolerance = new ArrayList<Ingredient>();
		diaryEntrySet = new TreeSet<DiaryEntry>();
		
	}

	/**
	 * Fügt einen Gefahrenstoff hinzu
	 * 
	 * @param ingredient Inhaltstoff der als Gefahrenstoff gekennzeichnet werden soll
	 */
	public void addIntolerance(Ingredient ingredient) {
		try{
			intolerance.add(ingredient);
		}
		catch(IllegalArgumentException e) {
			//Fehlermeldung anzeigen
			return;
		}
	}

	/**
	 * Löschen einer Intoleranz
	 * 
	 * @param ingredient Inhaltsstoff der nicht mehr als Gefahrenstoff gekennzeichnet werden soll
	 */
	public void removeIntolerance(Ingredient ingredient){
		int index = intolerance.indexOf(ingredient);
		
		try {
			if(index > -1) {
				intolerance.remove(index);
			}
			else {
				throw new IllegalArgumentException();
			}
		}
		catch(IllegalArgumentException e) {
			//Fehlermeldung anzeigen
			return;
		}	
		
	}
	
//	/** Alle Einträge eines Tagebuch suchen
//	 * 
//	 * Sucht alle Tagebucheinträge, die mit dem vom Benutzer ausgewählten Daten übereinstimmen
//	 * 
//	 * 
//	 * @param name: Name des Tagebuchs
//	 * @param date: Das von Benutzer ausgesuchte Datum zur Anzeige
//	 * @return: Es wird die Liste zur Aktuellen Ansicht ausgegeben
//	 * 
//	 * TODO: name?
//	 */
//	public List<DiaryEntry> getDiaryEntries(String name, Date date) {
//		List<DiaryEntry> list = new ArrayList<DiaryEntry>();
//		
//		for(DiaryEntry entry : diaryEntrySet) {
//			if(entry.getDate() == date) {
//				list.add(entry);
//			}
//		}
//		return list;
//	}

	/**
	 * @return Gibt den Namen des Tagebuchs zurück
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name Setzt den Namen eines Tagebuch auf den Parammeter
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Gibt eine Liste von Gefahrenstoffen zurück
	 */
	public List<Ingredient> getIntolerance() {
		return intolerance;
	}

	/**
	 * @return Gibt eine Liste von Tagebucheinträgen zurück
	 */
	public SortedSet<DiaryEntry> getDiaryEntrySet() {
		return diaryEntrySet;
	}

	public String toString(){
		return name;
	}

}
