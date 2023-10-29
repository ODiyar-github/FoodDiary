package model;

import java.io.Serializable;

/**
 * FoodEntry fasst eine Menge, ein Food und eine Einheit zusammen
 */
public class FoodEntry implements Serializable {

	/**
	 * Menge des Foods
	 */
	private double amount;

	/**
	 * Food
	 */
	private Food food;

	/**
	 * Einheit der Menge bzw. des Essens
	 */
	private Unit unit;

	/**
	 * Konstruktor zum Erstellen eines FoodEntrys
	 * @param food
	 * @param amount
	 * @param unit
	 */
	public FoodEntry(Food food, double amount, Unit unit) {

		this.food=food;
		this.amount=amount;
		this.unit=unit;
		
	}

	/**
	 * @return Gibt das Lebensmittel zurueck
	 */
	public Food getFood() {
		return food;
	}

	/**
	 * @param food Setzt ein Lebensmittel
	 */
	public void setFood(Food food) {
		this.food = food;
	}
	
	/**
	 * @return Gibt die Menge zurueck
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
	 * @return Gibt die Einheit zurueck
	 */
	
	public Unit getUnit() {
		return this.unit;
	}

	/**
	 * @param amount Setzt die Einheit
	 */
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
}
