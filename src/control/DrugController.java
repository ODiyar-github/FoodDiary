package control;

import java.util.ArrayList;
import java.util.List;

import exceptions.AlreadyInArchiveException;
//import exceptions.NoCurrentDrugException;
import model.Drug;
import model.Ingredient;
import view.ArchiveAUI;

/**
 *Ein Controller, der die Medikamente des Archivs verwaltet
 */
/**
 * @author sopr099
 *
 */
public class DrugController {

	/**
	 * Das aktuell ausgewaehlte Medikament
	 */
	private Drug currentDrug;

	/**
	 * Der FDController
	 */
	private FDController fDController;

	/**
	 * Liste der ArchiveAUIs, die den DrugController beobachten.
	 */
	private List<ArchiveAUI> archiveAUIList;

	/**
	 * Erzeugt einen neuen DrugController
	 * @param bekommt den FDController als Parameter uebergeben
	 */
	public DrugController(FDController fDController) throws NullPointerException {
		if(fDController.equals(null)) throw new NullPointerException();
		
		this.fDController = fDController;
	}
	
	/**
	 * Gibt den FDController zuruecck
	 * @return
	 * 		Der FDController
	 */
	public FDController getfDController() {
		return fDController;
	}
	
	/**Fuegt eine neues ArchiveAUI hinzu
	 * @param aui
	 */
	public void addArchiveAUI(ArchiveAUI aui) {
		archiveAUIList.add(aui);
	}
	/**
	 * Gibt die Liste der ArchiveAUIs zurueck
	 * @return
	 * 		Die ArchiveAUIs
	 */
	public List<ArchiveAUI> getArchiveAUIList() {
		return archiveAUIList;
	}
	
	/**
	 * Ruft refresh auf allen ArchiveAUIs auf, die den DrugController beobachten
	 */
	public void callRefreshArchive(){
		for(ArchiveAUI aui : archiveAUIList){
			aui.refreshArchive();
		}
	}
	
	/**
	 * Gibt das aktuell ausgewaehlte Medikament zurueck.
	 * @return the currentDrug
	 * 		Das aktuell ausgewaehlte Medikament.
	 */
	public Drug getCurrentDrug() {
		return currentDrug;
	}

	/**
	 * Wechselt das aktuell ausgewaehlte Medikament.
	 * @param 
	 * 		Das neue aktuell ausgewaehlte Medikament.
	 */
	public void setCurrentDrug(Drug currentDrug) {
		this.currentDrug = currentDrug;
	}
	
	/**
	 * Sucht nach Medikamenten, deren Name einen bestimmten String enthaelt.
	 * @param name
	 * 		String, nach dem gesucht wird.
	 * @return
	 * 		Alle Medikamente, deren Name diesen String enthaelt
	 */
	public List<Drug> search(String name) {
		List<Drug> drugList = fDController.getFD().getArchive().getDrugList();
		List<Drug> searchedList = new ArrayList<Drug>();
		
		for(Drug drug : drugList) {
			if(drug.getName().contains(name)){
				searchedList.add(drug);
			}
		}
		
		return searchedList;
		
	}
	
	/**
	 * Testet, ob es ein Medikament mit einem bestimmten Namen im Archiv gibt.
	 * @param name
	 * 		Name, nach dem gesucht werden soll.
	 * @return
	 * 		true, falls es so ein Medikament gibt. false, sonst
	 */
	public boolean exists(String name) {
		List<Drug> list = fDController.getFD().getArchive().getDrugList();
		
		for(Drug drug : list) {
			if(drug.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Sucht nach einem Medikament, mit dem uebergeben Namen.
	 * @param name
	 * 		Name, nach dem gesucht werden soll.
	 * @return
	 * 		Medikament, das diesen Namen hat, wenn es eins gibt; null sonst.
	 */
	public Drug getDrug(String name){
		List<Drug> list = fDController.getFD().getArchive().getDrugList();
		
		for(Drug drug : list) {
			if(drug.getName().equals(name)) {
				return drug;
			}
		}
		return null;
	}

	/**
	 * Fuegt ein Medikament mit dazugehoerigen Inhaltsstoffen in das Archiv ein
	 * 
	 * @param Drug
	 * 		Das Medikament, das eingefuegt werden soll.
	 * @param ingredientList
	 * 		Eine Liste der Inhaltsstoffe, die in diesem Medikament enthalten sind.
	 */
	public void addEntry(Drug drug, List<Ingredient> ingredientList) throws AlreadyInArchiveException {
		//Exception schmeissen, wenn es das Medikament schon gibt.
				if (exists(drug.getName())){
					throw new AlreadyInArchiveException(drug.getName());
				}
				else {
					//Medikament hinzufuegen
					fDController.getFD().getArchive().getDrugList().add(drug);
					
					//Verbindungen zu Inhaltsstoffen setzen
					for(Ingredient ingredient : ingredientList){
						addIngredientToDrug(ingredient, drug);
					}
					callRefreshArchive();
				}
	}
	
	/**
	 * Fuegt ein Medikament in das Archiv hinzu. Wirf eine AlreadyInArchiveException, wenn es ein Medikament mit dem gleichen Namen schon im Archiv gibt.
	 * @param Drug
	 * 		Das Medikament, das hinzugefuegt werden soll.
	 */
	public void addEntry(Drug drug) throws AlreadyInArchiveException {
		//Exception schmeissen, wenn es das Medikament schon gibt.
		if (exists(drug.getName())){
			throw new AlreadyInArchiveException(drug.getName());
		}
		else {
			//Medikament hinzufuegen
			fDController.getFD().getArchive().getDrugList().add(drug);
			callRefreshArchive();
		}
	}

	/**
	 * Die Methode fuegt den uebergebenen Inhaltstoff zum aktuellen Medikament hinzu. Wenn es kein aktuelles Medikament gibt, wirft sie eine NoCurrentDrugException
	 * @param ingredient der einzufügende Ingredient
	 */
//	public void addIngredientToDrug(Ingredient ingredient) throws NoCurrentDrugException {
//		if(currentDrug == null){
//			throw new NoCurrentDrugException();
//		}
//		else{
//			addIngredientToDrug(ingredient, currentDrug);
//			callRefreshArchive();
//		}
//	}

	/**
	 * Fuegt zu einem Medikament einen Inhaltsstoff hinzu
	 * @param ingredient
	 * 		Der Inhaltsstoff, der eingefuegt werden soll
	 * @param Drug
	 * 		Das Lebesmittel, zu dem der Inhaltsstoff hinzugefuegt werden soll
	 */
	public void addIngredientToDrug(Ingredient ingredient, Drug drug) {
		if(!drug.getIngredientList().contains(ingredient)){
			drug.getIngredientList().add(ingredient);
		}
		if(!ingredient.getDrugList().contains(drug)){
			ingredient.getDrugList().add(drug);
		}
		callRefreshArchive();
	}

	/**
	 * Die Methode entfernt ein Medikament vom aktuellen Medikament. Wenn es kein aktuelles Medikament gibt, wirft sie eine NoCurren
	 * @param ingredient der zu löschende Ingredient
	 */
//	public void removeIngredientFromDrug(Ingredient ingredient) throws NoCurrentDrugException {
//		if(currentDrug == null){
//			throw new NoCurrentDrugException();
//		}
//		else{
//			currentDrug.getIngredientList().remove(ingredient);
//			ingredient.getDrugList().remove(currentDrug);
//			callRefreshArchive();
//		}
//	}

	/**
	 * Die Methode entfernt von einem Medikament einen Inhaltsstoff
	 * @param ingredient
	 * 		Der Inhaltsstoff, der entfernt werden soll.	
	 * @param Drug
	 * 		Das Medikament, von dem der Inhaltsstoff entfernt werden soll.
	 */
	public void removeIngredientFromDrug(Ingredient ingredient, Drug drug) {
		drug.getIngredientList().remove(ingredient);
		ingredient.getDrugList().remove(drug);
		callRefreshArchive();
	}


}
