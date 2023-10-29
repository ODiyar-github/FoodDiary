package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



/**
 * Klasse zum Speichern der Lebensmittel
 * @author sopr092 * 
 */
public class Food implements Serializable {
	
	/**
	 * Name des Lebensmittel
	 */
	private String name;

	/**
	 * Menge an Kalorien im Lebensmittel
	 */
	private int calories;

	/**
	 * Menge an Proteine im Lebensmittel 
	 */
	private int protein;

	/**
	 * Menge an Fetten im Lebensmittel
	 */
	private int fat;

	/**
	 * Menge der Kohlenhydrate im Lebensmittel
	 */
	private int carbohydrates;
	
	/**
	 * Liste der Inhaltsstoffe des Lebensmittel
	 */
	private List<Ingredient> ingredientList;

	/**
	 * Konstruktor um ein neues Lebensmittel-Objekt anzulegen
	 * @param name ist der Name des Lebensmittel
	 * @param calories ist die Menge an Kalorien im Lebensmittel
	 * @param protein ist die Menge an Proteine im Lebensmittel 
	 * @param fat ist die Menge an Fetten im Lebensmittel
	 * @param carbohydrates ist die Menge der Kohlenhydrate im Lebensmittel
	 * @throws IlleagelArgumentException wird geworfen wenn einer der Parameter nicht korrekt ist
	 */
	public Food(String name, int calories, int protein, int fat, int carbohydrates) {

		this.name=name;
		this.calories=calories;
		this.protein=protein;
		this.fat=fat;
		this.carbohydrates=carbohydrates;
		ingredientList = new ArrayList<Ingredient>();
		
	}
	
	/**
	 * @return Gibt den Namen zurueck
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * @param name Setzt den Namen
	 */
	public void setName(String name){
		this.name=name;
	}
	
	/**
	 * @return Gibt die Kalorien zurueck
	 */
	public int getCalories(){
		return this.calories;
	}
	
	/**
	 * @param calories Setzt die Kalorien
	 */
	public void setCalories(int calories){
		this.calories=calories;
	}
	
	/**
	 * @return Gibt den Proteingehalt zurueck
	 */
	public int getProtein(){
		return this.protein;
	}
	
	/**
	 * @param protein Setzt den Proteingehalt
	 */
	public void setProtein(int protein){
		this.protein=protein;
	}
	
	/**
	 * @return Gibt den Fettgehalt zurueck
	 */
	public int getFat(){
		return this.fat;
	}
	
	/**
	 * @param fat Setzt den Fettgehalt
	 */
	public void setFat(int fat){
		this.fat=fat;
	}
	
	/**
	 * @return Gibt die Kohlenhydrate zurueck
	 */
	public int getCarbohydrates(){
		return this.carbohydrates;
	}
	
	/**
	 * @param carbohydrates Setzt die Kohlenhydrate
	 */
	public void setCarbohydrates(int carbohydrates){
		this.carbohydrates=carbohydrates;
	}

	/**
	 * @return the ingredientList
	 */
	public List<Ingredient> getIngredientList() {
		return ingredientList;
	}
	
	public String toString(){
		return name;
	}
}
