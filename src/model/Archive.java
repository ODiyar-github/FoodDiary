package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sopr097
 * Ein Archiv mit drei Listen zum verwalten der im Achiv abgespeicherten
 * Lebensmittel, Medikamente und Inhaltsstoffe
 */
public class Archive implements Serializable {

	/**
	 * Liste aller Medikamente, die im Archiv gespeichert sind
	 */
	private List<Drug> drugList;

	/**
	 * Liste aller Inhaltsstoffe, die im Archiv gespeichert sind
	 */
	private List<Ingredient> ingredientList;

	/**
	 * Liste aller Lebensmittel, die im Archiv gespeichert sind
	 */
	private List<Food> foodList;

	/**
	 *  Konstruktor für die Erstellung eines Archivs 
	 */
	public Archive() {
		drugList = new ArrayList<Drug>();
		foodList = new ArrayList<Food>();
		ingredientList = new ArrayList<Ingredient>();
	}


	/**
	 * @return Gibt eine Liste der Medikamente zurück
	 */
	public List<Drug> getDrugList() {
		return drugList;
	}


	/**
	 * @return Gibt eine Liste von Inhaltsstoffen zurück
	 */
	public List<Ingredient> getIngredientList() {
		return ingredientList;
	}


	/**
	 * @return Gibt eine Lebensmittelliste zurück
	 */
	public List<Food> getFoodList() {
		return foodList;
	}


}
