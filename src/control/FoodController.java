package control;

import java.util.ArrayList;
import java.util.List;

import exceptions.AlreadyInArchiveException;
//import exceptions.NoCurrentFoodException;
import model.Food;
import model.Ingredient;
import view.ArchiveAUI;

/**
 * Ein Controller, der die Lebensmittel des Archivs verwaltet
 */
public class FoodController {

	/**
	 * Das aktuell ausgewahlte Lebensmittel.
	 */
//	private Food currentFood;

	
	/**
	 * Der FDController
	 */
	private FDController fDController;


	/**
	 * Liste der ArchiveAUIs, die den Foodcontroller beobachten.
	 */
	private List<ArchiveAUI> archiveAUIList;

	
	/**
	 * Erzeugt einen neuen FoodController
	 * @param bekommt den FDController als Parameter uebergeben
	 */
	public FoodController(FDController fDController) throws NullPointerException{
		if(fDController.equals(null)) throw new NullPointerException();
		
		this.fDController = fDController;
		archiveAUIList = new ArrayList<ArchiveAUI>();
	}
	
	/**
	 * @return fDController gibt den FDController zurueck.
	 */
	public FDController getfDController() {
		return fDController;
	}

	/**
	 * Fuegt eine ArchiveAUI hinzu
	 * @param aui
	 */
	public void addArchiveAUI(ArchiveAUI aui) {
		archiveAUIList.add(aui);
	}

	/**
	 * Gibt die Liste der ArchiveAUIs zurueck
	 * @return archiveAUI
	 */
	public List<ArchiveAUI> getArchiveAUIList() {
		return archiveAUIList;
	}
	
	/**
	 * ruft die refreshArchive Methode auf allen ArchiveAUIs auf
	 */
	void callRefreshArchive() {
		for (ArchiveAUI aui : archiveAUIList){
			aui.refreshArchive();
		}
	}
	
	/**
	 * Gibt alle Lebensmittel aus dem Archiv zurueck, deren Name einen bestimmten String enthaelt
	 * @param name
	 * 		String nach dem gesucht wird
	 * @return
	 * 		Liste aller Lebensmittel, deren Name diesen String enthaelt
	 */
	public List<Food> search(String name) {
		List<Food> foodList = fDController.getFD().getArchive().getFoodList();
		List<Food> searchedList = new ArrayList<Food>();
		
		for(Food food : foodList) {
			if(food.getName().contains(name)){
				searchedList.add(food);
			}
		}
		
		return searchedList;
		
	}
	
	/**
	 * Testet, ob es ein Lebensmittel mit einem bestimmten Namen im Archiv gibt.
	 * @param name
	 * 		Der Name, nach dem gesucht werden soll
	 * @return
	 * 		true, wenn es ein Lebensmittel mit diesem Namen gibt. false sonst.
	 */
	public boolean exists(String name) {
		List<Food> list = fDController.getFD().getArchive().getFoodList();
		
		for(Food food : list) {
			if(food.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Sucht nach einem Lebensmittel, mit dem uebergeben Namen.
	 * @param name
	 * 		Name, nach dem gesucht werden soll.
	 * @return
	 * 		Lebensmittel, das diesen Namen hat, wenn es eins gibt; null sonst.
	 */
	public Food getFood(String name){
		List<Food> list = fDController.getFD().getArchive().getFoodList();
		
		for(Food food : list) {
			if(food.getName().equals(name)) {
				return food;
			}
		}
		return null;
	}

	/**
	 * Fuegt ein Lebensmittel mit dazugehoerigen Inhaltsstoffen in das Archiv ein
	 * 
	 * @param food
	 * 		Das Lebensmittel, das eingefuegt werden soll.
	 * @param ingredientList
	 * 		Eine Liste der Inhaltsstoffe, die in diesem Lebensmittel enthalten sind.
	 */
	public void addEntry(Food food, List<Ingredient> ingredientList) throws AlreadyInArchiveException {
		//Exception schmeissen, wenn es das Lebensmittel schon gibt.
				if (exists(food.getName())){
					throw new AlreadyInArchiveException(food.getName());
				}
				else {
					//Lebensmittel hinzufuegen
					fDController.getFD().getArchive().getFoodList().add(food);
					
					//Verbindungen zu Inhaltsstoffen setzen
					for(Ingredient ingredient : ingredientList){
						addIngredientToFood(ingredient, food);
					}
					callRefreshArchive();
				}
	}
	
	/**
	 * Fuegt ein Lebensmittel in das Archiv hinzu. Wirf eine AlreadyInArchiveException, wenn es ein Lebensmittel mit dem gleichen Namen schon im Archiv gibt.
	 * @param food
	 * 		Das Lebensmittel, das hinzugefuegt werden soll.
	 */
	public void addEntry(Food food) throws AlreadyInArchiveException {
		//Exception schmeissen, wenn es das Lebensmittel schon gibt.
		if (exists(food.getName())){
			throw new AlreadyInArchiveException(food.getName());
		}
		else {
			//Lebensmittel hinzufuegen
			fDController.getFD().getArchive().getFoodList().add(food);
			callRefreshArchive();
		}
	}


	/**
	 * Die Methode fuegt den uebergebenen Inhaltstoff zum aktuellen Lebensmittel hinzu. Wenn es kein aktuelles Lebensmittel gibt, wirft sie eine NoCurrentFoodException
	 * @param ingredient der einzufügende Ingredient
	 */
//	public void addIngredientToFood(Ingredient ingredient) throws NoCurrentFoodException {
//		if(currentFood == null){
//			throw new NoCurrentFoodException();
//		}
//		else{
//			addIngredientToFood(ingredient, currentFood);
//			callRefreshArchive();
//		}
//	}

	/**
	 * Fuegt zu einem Lebensmittel einen Inhaltsstoff hinzu
	 * @param ingredient
	 * 		Der Inhaltsstoff, der eingefuegt werden soll
	 * @param food
	 * 		Das Lebesmittel, zu dem der Inhaltsstoff hinzugefuegt werden soll
	 */
	public void addIngredientToFood(Ingredient ingredient, Food food) {
		if(!food.getIngredientList().contains(ingredient)){
			food.getIngredientList().add(ingredient);
			}
		if(!ingredient.getFoodList().contains(food)){
			ingredient.getFoodList().add(food);
		}
		callRefreshArchive();
	}

	/**
	 * Die Methode entfernt einen Inhaltsstoff vom aktuellen Lebensmittel. Wenn es kein aktuelles Lebensmittel gibt, wirft sie eine NoCurren
	 * @param ingredient der zu löschende Ingredient
	 */
//	public void removeIngredientFromFood(Ingredient ingredient) throws NoCurrentFoodException {
//		if(currentFood == null){
//			throw new NoCurrentFoodException();
//		}
//		else{
//			currentFood.getIngredientList().remove(ingredient);
//			ingredient.getFoodList().remove(currentFood);
//			callRefreshArchive();
//		}
//	}

	/**
	 * Die Methode entfernt von einem Lebensmittel einen Inhaltsstoff
	 * @param ingredient
	 * 		Der Inhaltsstoff, der entfernt werden soll.	
	 * @param food
	 * 		Das Lebensmittel, von dem der Inhaltsstoff entfernt werden soll.
	 */
	public void removeIngredientFromFood(Ingredient ingredient, Food food) {
		food.getIngredientList().remove(ingredient);
		ingredient.getFoodList().remove(food);
		callRefreshArchive();
	}

	/**
	 * Gibt das aktuell ausgewaehlte Lebensmittel zurueck.
	 * @return das aktuell ausgewaehlte Lebensmittel
	 */
//	public Food getCurrentFood() {
//		return currentFood;
//	}

	/**
	 * Aendert das aktuell ausgewaehlte Lebensmittel
	 * @param currentFood
	 * 		Das neue aktuell ausgewaehlte Lebensmittel
	 */
//	public void setCurrentFood(Food currentFood) {
//		this.currentFood = currentFood;
//	}
	
	/**
	 * Aendert die Beschreibung eines Lebensmittels
	 * @param 
	 * @param description Die neue Beschreibung fuer den Ingredient
	 */
	public void modifyEntry(Food food, int calories, int carbohydrates, int fat, int protein){
		food.setCalories(calories);
		food.setCarbohydrates(carbohydrates);
		food.setFat(fat);
		food.setProtein(protein);
		callRefreshArchive();
	}
}
