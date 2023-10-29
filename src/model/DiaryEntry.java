package model;

import java.util.Date;

import exceptions.NotInListException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/** Tagebucheintrag eines Nutzers anlegen
 * 
 * Ueber diese Klasse koennen Tagebucheintraege für Nutzer angelegt werden und verwaltet werden.
 * Speziell die Listen für Medikamente und Essen werden hier verwaltet.
 * 
 * @author sopr098
 *
 */

public class DiaryEntry implements Comparable<DiaryEntry>, Serializable {

	/**
	 * Zeitpunkt des Tagebucheintrags
	 */
	private Date date;

	/**
	 * Gab es zu diesem Zeitpunkt eine Beschwerde?
	 */
	private boolean complaint;

	/**
	 * Beschreibung des Essens, Medikaments, der Beschwerde
	 */
	private String description;

	/**
	 * Die Lebensmittel, die gegessen wurden
	 */
	private ArrayList<FoodEntry> foodEntryList;

	/**
	 * Die Medikamnte, die eingenommen wurden
	 */
	private ArrayList<DrugEntry> drugEntryList;

	
	
	/**
	 * Erzuegt einen neuen Tagebucheintrag mit den dazugehoerigen Informationen
	 * 
	 * @param date
	 * 		Zeitpunkt des Eintrags
	 * @param complaint
	 * 		Gab eis eine Beschwerde?
	 * @param description
	 * 		Beschreibung des Essens, Medikaments, der Beschwerde
	 */
	public DiaryEntry(Date date, boolean complaint, String description) {
		foodEntryList = new ArrayList<FoodEntry>();
		drugEntryList = new ArrayList<DrugEntry>();
		this.complaint = complaint;
		this.description = description;
		this.date = date;
		
	}

	public int compareTo(DiaryEntry entry){
		return date.compareTo(entry.getDate());
	}

	/**
	 * Die Methode fuegt den uebergebenen FoodEntry in die foodList hinzu
	 * @param foodEntry Der einzufuegende Eintag in die foodList
	 */
	public void addFoodEntry(FoodEntry foodEntry) {
		foodEntryList.add(foodEntry);
	}
	
	/**
	 * @param foodEntryList
	 */
	public void addFoodEntries(List<FoodEntry> foodEntryList) {
		this.foodEntryList.addAll(foodEntryList);
	}


	/**
	 * Die Methode entfernt den uebergebenen FoodEntry aus der foodList
	 *
	 * @param foodEntry
	 * @throws NotInListException
	 */
	public void removeFoodEntry(FoodEntry foodEntry) throws NotInListException{
		int index = foodEntryList.indexOf(foodEntry);
		
		if(index > -1) {
			foodEntryList.remove(index);
		}
		else{
			throw new NotInListException();

		}
	}


	/**
	 * Die Methode fuegt den uebergebenen DrugEntry in die drugList
	 * @param drugEntry Der einzufuegende Eintrag in die drugList
	 */
	public void addDrugEntry(DrugEntry drugEntry) {
		drugEntryList.add(drugEntry);
	}
	
	/**
	 * @param drugEntryList
	 */
	public void addDrugEntries(List<DrugEntry> drugEntryList) {
		this.drugEntryList.addAll(drugEntryList);
	}


	/**
	 * Die Methode entfernt den uebergebenen DrugEntry aus der drugList

	 * @param drugEntry
	 * @throws NotInListException
	 */
	public void removeDrugEntry(DrugEntry drugEntry) throws NotInListException {
		int index = drugEntryList.indexOf(drugEntry);
		
		if(index > -1) {
			drugEntryList.remove(index);
		}
		else{
			throw new NotInListException();

		}
	}

	/**
	 * @return Gibt einen Datumwert zurueck
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date setzt ein Datum
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return Gibt zurueck ob eine Beschwerde vorliegt
	 */
	public boolean isComplaint() {
		return complaint;
	}

	/**
	 * @param complaint Setzt eine Beschwerde
	 */
	public void setComplaint(boolean complaint) {
		this.complaint = complaint;
	}

	/**
	 * @return Gibt die Beschreibung eines Eintrags zurueck
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description Setzt die Beschreibung eines Eintrags 
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return Gibt eine Lebensmittelliste zurueck
	 */
	public List<FoodEntry> getFoodEntryList() {
		return foodEntryList;
	}


	/**
	 * @return Gibt eine Medikamentenliste zurueck
	 */
	public List<DrugEntry> getDrugEntryList() {
		return drugEntryList;
	}

}
