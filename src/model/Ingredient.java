package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ingredient implements Serializable {

	/**
	 *  Bezeichner des Inhaltsstoffs
	 */
	private String name;
	
	
	/**
	 *  Kurze Beschreibung wichtiger Eigenschaften des Inhaltsstoffes
	 */
	private String description;

	/**
	 *  foodList ist eine Liste der Lebensmittel, in denen der Inhaltsstoff enthalten ist 
	 */
	private List<Food> foodList;

	/**
	 *  drugList ist eine Liste der Medikamente, in denen der Inhaltsstoff enthalten ist 
	 */
	private List<Drug> drugList;

	/**
	 *  Ein Ingredient Objekt stellt einen Inhaltsstoff da
	 *  
	 *  
	 */
	/**
	 * @param name
	 * @param description
	 */
	public Ingredient(String name, String description) {
		this.setName(name);
		this.setDescription(description);
		foodList = new ArrayList<Food>();
		drugList = new ArrayList<Drug>();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Drug> getDrugList()
	{
		return drugList;
	}
	
	public List<Food> getFoodList()
	{
		return foodList;
	}
	
	public String toString(){
		return name;
	}
}
