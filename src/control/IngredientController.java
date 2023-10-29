package control;

import java.util.ArrayList;
import java.util.List;

import exceptions.AlreadyInArchiveException;
import model.Drug;
import model.Food;
import model.Ingredient;
import view.ArchiveAUI;


/**
 * Ein Controller, der die Inhaltsstoffe des Archivs verwaltet
 */
/**
 * @author sopr099
 *
 */
public class IngredientController {

	/**
	 * der FDController
	 */
	private FDController fDController;

	/**
	 * Die Liste der ArhiveAUIs, die den IngredientController beobachten
	 */	
	private List<ArchiveAUI> archiveAUIList;

	
	/**
	 * Erzeugt einen neuen IngredeintController
	 * @param bekommt den fDController als Parameter uebergeben
	 */
	public IngredientController(FDController fDController) throws NullPointerException {
		if(fDController.equals(null)) throw new NullPointerException();
		
		this.fDController = fDController;
		archiveAUIList = new ArrayList<ArchiveAUI>();
	}
	
	/**
	 * Gibt den FDController zurueck
	 * @return
	 * 		Der FDController
	 */
	public FDController getfDController() {
		return fDController;
	}

	/**
	 * Fuegt eine neue ArchiveAUI hinzu
	 * @param aui
	 */
	public void addArchiveAUI(ArchiveAUI aui) {
		archiveAUIList.add(aui);
	}

	/**
	 * Gibt die Liste der ArchiveAUIs zurueck
	 * @return the archiveAUI
	 */
	public List<ArchiveAUI> getArchiveAUIList() {
		return archiveAUIList;
	}
	
	/**
	 * Ruft die Refresh-Methode auf den ArchiveAUIs auf
	 */
	void callRefreshArchive() {
		for (ArchiveAUI aui : archiveAUIList){
			aui.refreshArchive();
		}
	}
	
	/**
	 * Gibt alle Inhaltsstoffe aus dem Archiv zuruck, deren Name einen bestimmten String enthaelt
	 * @param name
	 * 		Der String, nach dem gesucht wird
	 * @return
	 * 		Alle Inhaltsstoffe, deren Name diesen String enthaelt
	 */
	public List<Ingredient> search(String name) {
		List<Ingredient> ingredientList = fDController.getFD().getArchive().getIngredientList();
		List<Ingredient> searchedList = new ArrayList<Ingredient>();
		
		for(Ingredient ingredient : ingredientList) {
			if(ingredient.getName().contains(name)){
				searchedList.add(ingredient);
			}
		}
		
		return searchedList;
		
	}
	
	/**
	 * Testet, ob es einen Inhaltstoff mit einem bestimmten Namen im Archiv gibt
	 * @param name
	 * 		Der Name, nach dem gesucht wird
	 * @return
	 * 		true, fals so eien Inhaltsstoff gibt. false, sonst
	 */
	public boolean exists(String name) {
		List<Ingredient> list = fDController.getFD().getArchive().getIngredientList();
		
		for(Ingredient ingredient : list) {
			if(ingredient.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Sucht nach einem Inhaltsstoff, mit dem uebergeben Namen.
	 * @param name
	 * 		Name, nach dem gesucht werden soll.
	 * @return
	 * 		Inhaltsstoff, das diesen Namen hat, wenn es eins gibt; null sonst.
	 */
	public Ingredient getIngredient(String name){
		List<Ingredient> list = fDController.getFD().getArchive().getIngredientList();
		
		for(Ingredient ingredient : list) {
			if(ingredient.getName().equals(name)) {
				return ingredient;
			}
		}
		return null;
	}

	/**
	 * Fuegt einen Inhaltsstoff mit dazugehoerigen Lebensmitteln und Medikamenten in das Archiv ein.
	 * 
	 * @param ingredient
	 * 		Der Inhaltsstoff, der eingefuegt werden soll.
	 * @param foodList
	 * 		Eine Liste der Lebensmittel, in denen dieser Inhaltsstoff enthalten ist.
	 * @param drugList
	 * 		Eine Liste der Medikamente, in denen dieser Inhaltsstoff einthalten ist.
	 */
	public void addEntry(Ingredient ingredient, List<Food> foodList, List<Drug> drugList) throws AlreadyInArchiveException {
		//Exception schmeissen, wenn es den Inhaltsstoff schon gibt.
		if (exists(ingredient.getName())){
			throw new AlreadyInArchiveException(ingredient.getName());
		}
		else {
			//Inhaltsstoff hinzufuegen
			fDController.getFD().getArchive().getIngredientList().add(ingredient);
			
			//Verbindungen zu Lebensmitteln setzen
			for(Food food : foodList){
				fDController.getFoodController().addIngredientToFood(ingredient, food);
			}
			
			//Verbindungen zu Medikamenten setzen
			for(Drug drug : drugList){
				fDController.getDrugController().addIngredientToDrug(ingredient, drug);
			}
			callRefreshArchive();
		}
	}
	
	public void addEntry(Ingredient ingredient) throws AlreadyInArchiveException{
		//Exception schmeissen, wenn es den Inhaltsstoff schon gibt.
				if (exists(ingredient.getName())){
					throw new AlreadyInArchiveException(ingredient.getName());
				}
				else {
					//Inhaltsstoff hinzufuegen
					fDController.getFD().getArchive().getIngredientList().add(ingredient);
					callRefreshArchive();
				}
	}
	
	/**
	 * Aendert die Beschreibung eines Ingredient
	 * @param Ingredient der zu aendernde Ingredient
	 * @param description Die neue Beschreibung fuer den Ingredient
	 */
	public void modifyEntry(Ingredient ingredient, String description){
		ingredient.setDescription(description);
		callRefreshArchive();
	}
}
