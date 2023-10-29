package control;
import model.Archive;
import model.FoodDiary;

/** Zentraler Controller des FoodDiary mit Zugriff auf das FoodDiary und alle ihn umgebenden Controller
 * 
 * @author sopr098, sopr091
 *
 */

public class FDController {

	private IOController iOController;

	private DiaryController diaryController;

	private ArchiveController archiveController;

	private ViewController viewController;

	private FoodDiary foodDiary;
	
	private FoodController foodController;
	
	private DrugController drugController;
	
	private IngredientController ingredientController;

	/**
	 * Der FDController ist fuer die komplette initialiesierung gedacht.
	 * Das ist die erste Methode die aufgerufen wird.
	 */
	public FDController() {
		iOController=new IOController(this);
		diaryController=new DiaryController(this);
		archiveController=new ArchiveController(this);
		viewController=new ViewController(this);
		foodDiary=new FoodDiary(new Archive());
		foodController = new FoodController(this);
		drugController = new DrugController(this);
		ingredientController = new IngredientController(this);
		
	}

	/**
	 * Die Methode gibt den initialisierten IOController zurück
	 * @return IOController falls vorhanden, sonst null
	 */
	public IOController getIOController() {
		if(iOController !=null){
			return iOController;
		}
		return null;
	}

	/**
	 * Die Methode gibt den initialisierten ArchiveController zurück
	 * @return ArchiveController falls vorhanden, sonst null
	 */
	public ArchiveController getArchiveController() {
		if(archiveController !=null){
			return archiveController;
		}
		return null;
	}


	/**
	 * Die Methode gibt den initialisierten DiaryController zurück
	 * @return DiaryController falls vorhanden, sonst null
	 */
	public DiaryController getDiaryController() {
		if(diaryController !=null){
			return diaryController;
		}
		return null;
	}

	/**
	 * Die Methode gibt den initialisierten ViewController zurück
	 * @return ViewController falls vorhanden, sonst null
	 */
	public ViewController getViewController() {
		if(viewController !=null){
			return viewController;
		}
		return null;
	}


	/**
	 * @return the foodController
	 */
	public FoodController getFoodController() {
		return foodController;
	}

	/**
	 * @return the drugController
	 */
	public DrugController getDrugController() {
		return drugController;
	}

	/**
	 * @return the ingredientController
	 */
	public IngredientController getIngredientController() {
		return ingredientController;
	}

	/**
	 * Die Methode setzt das foodDiary auf das übergebene FoodDiary
	 * @param fD Das neu einzusetzende FoodDiary
	 */
	public void setFD(FoodDiary foodDiary) {
		if(foodDiary!=null){
			this.foodDiary=foodDiary;
		}
	}

	/**
	 * Die Methode gibt das FoodDiary zurück
	 * @return FoodDiary falls vorhanden, sonst null
	 */
	public FoodDiary getFD() {
		if(foodDiary !=null){
			return foodDiary;
		}
		return null;
	}

}
