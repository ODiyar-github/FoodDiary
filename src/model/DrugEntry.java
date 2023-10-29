package model;

import java.io.Serializable;

/**Erstellt neue Medikamenteneintraege für das Tagebuch 
 * 
 * @author sopr097
 *
 */
public class DrugEntry implements Serializable{

	
	/**Menge eines Medikaments
	 */
	private double amount;

	/** Inhaltsstoffe eines Medikaments
	 */
	private Ingredient ingredient;

	/** Medikament
	 */
	private Drug drug;

	/** Einheit der Eingetragenen Menge
	 */
	private Unit unit;

	/**Konstruktor des DrugEntry
	 * 
	 * @param drug Einzufuegendes Medikament
	 * @param amount Menge des Medikaments
	 * @param unit Einheit der Menge (z. B. mg)
	 */
	public DrugEntry(Drug drug, double amount, Unit unit) {
		this.drug=drug;
		this.amount=amount;
		this.unit=unit;
	}

	/**
	 * @return Gibt Menge zurueck
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount Setzt die Menge
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return Gibt die Inhaltstoffe des Medikaments zurueck
	 */
	public Ingredient getIngredient() {
		return ingredient;
	}

	/**
	 * @param ingredient Setzt die Inhaltsstoffe des Medikaments
	 */
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	/**
	 * @return Gibt das Medikament zurueck
	 */
	public Drug getDrug() {
		return drug;
	}

	/**
	 * @param drug Setzt ein Medikament
	 */
	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	/**
	 * @return Gibt die Einheit zurueck
	 */
	public Unit getUnit() {
		return unit;
	}

	/**
	 * @param unit Setzt die Einheit eines Eintrags
	 */
	public void setUnit(Unit unit) {
		this.unit = unit;
	}

}
