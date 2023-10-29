package control;

import model.Archive;
import model.Drug;
import model.Food;
import model.Ingredient;
import view.ArchiveAUI;
import java.util.ArrayList;
import java.util.List;

import exceptions.AlreadyInArchiveException;


/**
 * Der ArchiveController verwaltet das Archiv
 * @author sopr096
 *
 */
public class ArchiveController {

	private final FDController fDController;
	
	private final FoodController foodController;
	
	private final IngredientController ingredientController;
	
	private final DrugController drugController;

	/**
	 * AUIs, die vom ArchiveController benachrichtigt werden
	 */
	private List<ArchiveAUI> archiveAUIList;

	
	/**
	 * Konstruktor des AchiveController
	 * 
	 * @param fDController Der zugehörige FDController
	 */
	public ArchiveController(FDController fDController) {
		this.fDController=fDController;
		foodController = fDController.getFoodController();
		drugController = fDController.getDrugController();
		ingredientController = fDController.getIngredientController();
	}
	
	/**
	 * Ruft die refreshArchive() Methode der ArchiveAUI auf
	 */
	private void callRefreshArchive() {
		for (final ArchiveAUI aui : archiveAUIList){
			aui.refreshArchive();
		}
	}
	
	/**
	 * Fügt dem ArchiveController eine ArchiveAUI hinzu
	 * 
	 * @param archiveAUI Die hinzu zu fügende ArchiveAUI
	 */
	public void addArchiveAUI(ArchiveAUI archiveAUI) {
		if(archiveAUI != null){
			archiveAUIList.add(archiveAUI);
		}
	}

	/**
	 * Fuegt alle eine Eintreage eines anderen Archivs in das aktuelle Archiv hinzu.
	 * Dabei koennen alte Eintraege ersetzt werden.
	 * 
	 * @param archive
	 * 		Archive, welches in das aktuelle Archiv importiert werden soll
	 * @param replace
	 * 		Sollen alte Eintraege, durch neue ersetzt werden.
	 */
	public void merge(Archive archive, boolean replace) {
		final List<Drug> newDrugList = archive.getDrugList();
		final List<Food> newFoodList = archive.getFoodList();
		final List<Ingredient> newIngredientList = archive.getIngredientList();

		for(final Ingredient newIngr : newIngredientList){
			try{
				//neuen Inhaltsstoff in das Archiv einfuegen
				ingredientController.addEntry(newIngr);
			}
			catch(AlreadyInArchiveException e){//Einfuegen hat nicht geklappt, da es diesen Inhaltsstoff schon gibt
				final Ingredient oldIngr = ingredientController.getIngredient(newIngr.getName());//Alter Inhaltsstoff, der das Einfuegen verhindert
				
				if(replace){//Der Alte Inhaltsstoff soll ersetzt werden.
					
					//alte Beschreibung ersetzen
					oldIngr.setDescription(newIngr.getDescription());
				}
				
				//neue Verbindungen setzen
				for(final Food food : newIngr.getFoodList()){
					foodController.addIngredientToFood(oldIngr, food);
				}
				for(final Drug drug : newIngr.getDrugList()){
					drugController.addIngredientToDrug(oldIngr, drug);
				}
				
				//Alle Verbindung vom neuen Inhaltsstoff trennen, um ihn zu loeschen
				for(final Food food : newIngr.getFoodList()){
					foodController.removeIngredientFromFood(newIngr, food);
				}
				for(final Drug drug : newIngr.getDrugList()){
					drugController.removeIngredientFromDrug(newIngr, drug);
				}
			}
		}
		
		for(Food newFood : newFoodList){
			try{
				//neues Lebensmittel ins Archiv einfuegen
				foodController.addEntry(newFood);
			}
			catch(AlreadyInArchiveException e){//Einfugen hat nicht geklappt, da es dieses Lebensmittel schon gibt
				Food oldFood = foodController.getFood(newFood.getName());//Altes Lebensmittel, der das Einfuegen verhindert hat
				
				if(replace){//Das alte Lebensmittel soll ersetzt werden
					
					//alte Einstellungen ersetzen
					oldFood.setCalories(newFood.getCalories());
					oldFood.setCarbohydrates(newFood.getCarbohydrates());
					oldFood.setFat(newFood.getFat());
					oldFood.setProtein(newFood.getProtein());
					
					//alte Verbindungen entfernen
					for(Ingredient ingredient : oldFood.getIngredientList()){
						foodController.removeIngredientFromFood(ingredient, oldFood);
					}
					
					//neue Verbindungen setzen
					for(Ingredient ingredient : newFood.getIngredientList()){
						foodController.addIngredientToFood(ingredient, oldFood);
					}
				}
				
				//Alle Verbindung vom neuen Lebensmittel trennen, um es zu loeschen
				for(Ingredient ingredient : newFood.getIngredientList()){
					foodController.removeIngredientFromFood(ingredient, newFood);
				}
			}
			
			for(final Drug newDrug : newDrugList){
				try{
					//neues Medikament ins Archiv einfuegen
					drugController.addEntry(newDrug);
				}
				catch(AlreadyInArchiveException e){//Einfugen hat nicht geklappt, da es dieses Medikament schon gibt
					Drug oldDrug = drugController.getDrug(newDrug.getName());//Altes Medikament, der das Einfuegen verhindert hat
					
					if(replace){//Das alte Medikament soll ersetzt werden
						
						//alte Nebenwirkungen ersetzen
						oldDrug.setSideEffects(newDrug.getSideEffects());
						
						//alte Verbindungen entfernen
						for(final Ingredient ingredient : oldDrug.getIngredientList()){
							drugController.removeIngredientFromDrug(ingredient, oldDrug);
						}
						
						//neue Verbindungen setzen
						for(final Ingredient ingredient : newDrug.getIngredientList()){
							drugController.addIngredientToDrug(ingredient, oldDrug);
						}
					}
					
					//Alle Verbindung vom neuen Medikament trennen, um es zu loeschen
					for(final Ingredient ingredient : newDrug.getIngredientList()){
						drugController.removeIngredientFromDrug(ingredient, newDrug);
					}
				}
			}
		}
		callRefreshArchive();
	}

	/**
	 * @return Gibt den FDController zurück
	 */
	public FDController getfDController() {
		return fDController;
	}

	/**
	 * @return Gibt die ArchiveAUI zurück
	 */
	public List<ArchiveAUI> getArchiveAUIList() {
		return archiveAUIList;
	}
	
}
