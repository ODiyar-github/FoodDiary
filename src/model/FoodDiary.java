package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** 
 * Ueber diese Klasse koennen Tagebuecher hinzugefuegt und geloescht werden. 
 * Außerdem merkt sich FoodDiary das aktuell geoeffnete/ geladene Tagebuch in current
 * 
 * @author sopr098
 *
 */

public class FoodDiary implements Serializable {

	/**
	 * 
	 */
	private boolean remeberCurrentDiary;
	
	/**
	 * Das aktuell vom Nutzer geoeffnete Tagebuch
	 */
	private Diary currentDiary;
	
	/**
	 * Liste aller Tagebuecher
	 */
	private List<Diary> diaryList;

	/**
	 * Archiv, in dem Informationen ueber Lebensmittel, Inhaltsstoffe und Medikamente gespeichert sind
	 */
	private Archive archive;

	/**
	 * Erzeugt ein neues FoodDiary
	 * 
	 * @param archive
	 * 		Archiv, in dem Informationen ueber Lebensmittel, Inhaltsstoffe und Medikamente gespeichert sind
	 */
	public FoodDiary(Archive archive) {
		diaryList=new ArrayList<Diary>();
		this.archive=archive;
	}

	/**
	 * Die Methode fuegt ein uebergebenes Tagebuch in die diaryList ein
	 * @param diary Das einzufügende Tagebuch
	 */
	public void addDiary(Diary diary) {
		diaryList.add(diary);
	}

	/**
	 * Die Methode loescht ein uebergebenes Tagebuch aus der diaryList heraus
	 * @param diary Das zu loeschende Tagebuch
	 */
	public void removeDiary(Diary diary) {
		this.diaryList.remove(diary);
	}
	
	/**
	 * @return gibt das Archiv des FoodDiarys zurueck
	 */
	public Archive getArchive(){
		return this.archive;
	}
	
	public void setBoolean(boolean remeber){
		remeberCurrentDiary=remeber;
	}
	
	public boolean getBoolean(){
		return remeberCurrentDiary;
	}
	
	public List<Diary> getDiaries(){
		return diaryList;
	}
	
	/**
	 * Setzt das aktuelle Tagebuch
	 * @param diary
	 * 		das neue aktuelle Tagebuch
	 */
	public void setCurrentDiary(Diary diary){
		currentDiary = diary;
	}
	
	/**
	 * Gibt das aktuelle Tagebuch zurück.
	 * @return
	 * 		das aktuelle Tagebuch
	 */
	public Diary getCurrentDiary(){
		return currentDiary;
	}
}
