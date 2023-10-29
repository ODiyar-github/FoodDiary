package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sopr097
 *  Klasse zum speichern der Medikamente
 */

public class Drug implements Serializable{

	/** Name des Medikaments
	 */
	private String name;

	/**Nebenwirkungen des Medikaments
	 */
	private String sideEffects;

	/** Inhaltsstoffliste
	 */
	private List<Ingredient> ingredientList;


	/** Konstruktor von Drug
	 * 
	 * @param name Name des Medikaments 
	 * @param sideEffects Nebenwirkungen des Medikaments
	 */
	public Drug(String drugName, String sideEffects) {
		this.name = drugName;
		this.sideEffects = sideEffects;
		ingredientList = new ArrayList<Ingredient>();
		
	}


	/**
	 * @return Gibt den Medikamentennamen zurueck
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name Setzt den Namen eines Medikaments
	 */
	public void setName(String drugName) {
		this.name = drugName;
	}


	/**
	 * @return Gibt die Nebenwirkungen zurueck
	 */
	public String getSideEffects() {
		return sideEffects;
	}


	/**
	 * @param sideEffects Setzt die Nebenwirkungen des Medikaments
	 */
	public void setSideEffects(String sideEffects) {
		this.sideEffects = sideEffects;
	}


	/**
	 * @return Gibt die Inhaltstoffe des Medikaments zurueck
	 */
	public List<Ingredient> getIngredientList() {
		return ingredientList;
	}
	
	public String toString(){
		return name;
	}
}
