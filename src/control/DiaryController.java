package control;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;
import java.util.SortedSet;

import support.ParameterClassAnalyze;
import support.SetTupel;
import model.Diary;
import view.DiaryAUI;
import model.DiaryEntry;
import model.Drug;
import model.DrugEntry;
import model.Food;
import model.FoodEntry;
import model.Ingredient;
import model.Unit;
import exceptions.NoCurrentDiaryException;
import exceptions.DiaryAlreadyExistsException;

/** Controller für Das Tagebuch 
 * 
 * Über diese Klasse können Tagebucheinträge hinzugefügt bzw. gelöscht werden,
 * Tagebücher analysiert und verglichen werden, Tagebücher bearbeitetwerden und nach Tagebucheinträgen gesucht werden.
 * 
 * @author sopr098, sopra091, sopr094
 *
 */
public class DiaryController {

	private FDController fDController;

	private List<DiaryAUI> diaryAUIList;
	
	/**
	 * Erstellt einen DiaryController
	 * @param fDController Der zentrale fDController wird sich im DiaryController gemerkt
	 */
	public DiaryController(FDController fDController) throws NullPointerException {
		if(fDController.equals(null)) throw new NullPointerException();
		
		this.fDController = fDController;
		diaryAUIList = new ArrayList<DiaryAUI>();
	}

	/**
	 *  Ruft die Methode refreshDiary() aus der DiaryAUI auf
	 */
	void callRefreshDiary() {
		for(DiaryAUI diaryAUI : diaryAUIList){
			diaryAUI.refreshDiary();
		}
	}

	/**
	 * Die Methode fügt den als Parameter übergebenen Eintrag entry in das Tagebuch ein und ruft callRefreshDiary() auf
	 * @param entry Der in das Tagebuch einzufügende Beitrag
	 */
	public void addEntry(DiaryEntry entry) throws NoCurrentDiaryException{
		if(getCurrentDiary() == null){
			throw new NoCurrentDiaryException();
		}
		getCurrentDiary().getDiaryEntrySet().add(entry);
		callRefreshDiary();
	}

	/**
	 * Die Methode entfernt den als Parameter übergebenen Eintrag entry aus dem Tagebuch  und ruft callRefreshDiary() auf
	 * @param entry Der aus dem Tagebuch zu entfernende Eintrag
	 */
	public void removeEntry(DiaryEntry entry) throws NoCurrentDiaryException{
		if(getCurrentDiary() == null){
			throw new NoCurrentDiaryException();
		}
		getCurrentDiary().getDiaryEntrySet().remove(entry);
		callRefreshDiary();
	}
	
	/**
	 * Diese Methode erstellt ein Tupel aus den vorgegebenen SortedSets.
	 * Sie ist eine hilfsmethode, für die Methode "compare".
	 * @param diary1 = erstes Tagebuch
	 * @param diary2 = zweites Tagebuch
	 * @return SetTupel
	 * @throws IllegalArgumentException wirft eine Exception, bei falschen Eingaben.
	 */
	private SetTupel setIntoTupel(SortedSet<DiaryEntry> diary1, SortedSet<DiaryEntry> diary2) {
		SetTupel tupel = new SetTupel(diary1, diary2);
		return tupel;
	}

	/**
	 * Die Methode "compare" vergleicht von Zwei Tagebuechern, alle Eintraege die zwischen den Zeitraumen "from" bis "to" sind, 
	 * ob eine beschwerde vorliegt in diesen Eintraegen oder nicht.
	 * Wenn eine Beschwerde vorliegt in beiden Eintraegen, so werden diese raus gefiltert mit analyze() und in einen Tupel zusammengefuegt.
	 *  
	 * @param from = von (Zeitangabe)
	 * @param to = bis (Zeitangabe)
	 * @param diary = Das Tagebuch was vergleicht werden soll.
	 * @param complaint = ist eine beschwerde vorhanden oder nicht.
	 * @param foodList = currentDiary
	 * @param drugList = currentDiary
	 * @param ingredientList = currentDiary
	 * @return ListTupel
	 * @throws IllegalArgumentException wirft eine Exception, bei falschen Eingaben.
	 */
	public SetTupel compare(Diary diary, ParameterClassAnalyze params) throws NoCurrentDiaryException {
		SortedSet<DiaryEntry> set1 = analyze(params); //Das aktuelle Tagebuch analysieren.
		
		Diary tmpDiary = getCurrentDiary(); //Aktuelles Tagebuch zwischenspechern, um später zurückzuwechseln
		fDController.getFD().setCurrentDiary(diary); //Aktuelles Tagebuch zu diary wechseln, um es zu analysieren.
		
		SortedSet<DiaryEntry> set2 = analyze(params); //Das andere Tagebuch analysieren.
		
		fDController.getFD().setCurrentDiary(tmpDiary); //Tagebuch zurückwechseln
		
		return setIntoTupel(set1, set2);
	}

	/**
	 *  Die Methode gibt ein SortedSet zurück, in dem alle Einträge des aktuellen Tagebuchs sind, deren Tag den Suchkriterien entspricht
     * @param from = von (Zeitangabe inklusive)
	 * @param to = bis (Zeitangabe inklusive)
	 * @param complaint = Angabe,ob nur Einträge mit Beschwerden betrachtet werden sollen
	 * @param foodList = Liste der zu betrachtenden Lebensmittel
	 * @param drugList = Liste der zu betrachtenden Medikamente
	 * @param ingredientList = Liste der zu betrachtenden Inhaltsstoffe
	 */
	public SortedSet<DiaryEntry> analyze(ParameterClassAnalyze params) throws NoCurrentDiaryException {
		if(getCurrentDiary() == null){
			throw new NoCurrentDiaryException();
		}
		
		SortedSet<DiaryEntry> entriesInTime = getDiaryEntriesByDate(params.getFrom(), new Date(params.getTo().getTime() + 86400000));
		SortedSet<DiaryEntry> returnSet = new TreeSet<DiaryEntry>();
		
		for(DiaryEntry entry : entriesInTime){
			if(entry.isComplaint() || !params.isComplaint()){
				boolean foundMatch = false;
				
				for(Food food : params.getFoodList()){
					if(containsFood(entry, food)){
						returnSet.addAll(getDiaryEntriesAtDay(entry.getDate()));
						foundMatch = true;
						break;
					}
				}
				
				if(!foundMatch){
					for(Drug drug : params.getDrugList()){
						if(containsDrug(entry, drug)){
							returnSet.addAll(getDiaryEntriesAtDay(entry.getDate()));
							foundMatch = true;
							break;
						}
					}
				}
				
				if(!foundMatch){
					for(Ingredient ingredient : params.getIngredientList()){
						if(containsIngredient(entry, ingredient)){
							returnSet.addAll(getDiaryEntriesAtDay(entry.getDate()));
							foundMatch = true;
							break;
						}
					}
				}
			}
		}
		
		return returnSet;
	}

	/**
	 * Die Methode ändert die Menge eines FoodEntrys und ruft callRefreshDiary() auf
	 * @param entry Der zu ändernde Eintrag
	 * @param amount Neue Menge für den Eintrag
	 * @param unit Einheit der übergebenen Menge amount
	 */
	public void changeAmount(FoodEntry entry, double amount, Unit unit) {
		entry.setAmount(amount);
		entry.setUnit(unit);
		callRefreshDiary();
	}

	/**
	 * Die Methode ändert die Menge eines DrugEntrys und ruft callRefreshDiary() auf
	 * @param entry Der zu ändernde Eintrag
	 * @param amount Neue Menge für den Eintrag
	 * @param unit Einheit der übergebenen Menge amount
	 */
	public void changeAmount(DrugEntry entry, double amount, Unit unit) {
		entry.setAmount(amount);
		entry.setUnit(unit);
		callRefreshDiary();
	}

	/**
	 * Die Methode fügt zu der Collection<DiaryAUI> den übergebenen Parameter diaryAUI hinzu
	 * @param diaryAUI Die einzufügende DiaryAUI
	 */
	public void addDiaryAUI(DiaryAUI diaryAUI) {
		this.diaryAUIList.add(diaryAUI);
	}

	/**
	 * Die Methode setzt das ausgwählte Tagebuch als das Aktuelle und ruft callRefreshDiary() auf
	 * @param diary Das ausgewählte Tagebuch
	 * @postconditions Das aktuelle Tagebuch wurde geändert und steht zur Bearbeitung bereit
	 * @throws IllegalArgumentException wirft eine Exception wenn der Parameter nicht korrekt ist
	 */
	public void loadDiary(Diary diary) {
		fDController.getFD().setCurrentDiary(diary);
		callRefreshDiary();
	}
	
	/**
	 * Die Methode fügt ein neues Tagebuch hinzu. Wenn es ein Tagebuch mit diesem Namen schon gibt, wird eine Exception geworfen.
	 * @param diary
	 * 		das neue Tagebuch
	 */
	public void addDiary(Diary diary) throws DiaryAlreadyExistsException {
		if(exists(diary.getName())) throw new DiaryAlreadyExistsException();
		fDController.getFD().addDiary(diary);
	}
	
	/**
	 * Testet, ob es schon ein Tagebuch mit diesem Namen gibt.
	 * @param name
	 * 		Name, nach dem gesucht werden soll.
	 * @return
	 * 		true, wenn es das Tagebuch schon gibt. false sonst
	 */
	public boolean exists(String name){
		for(Diary diary : getDiaries()){
			if(diary.getName().equals(name)){
				return true;
			}
		}
		return false;
	}
	
	/**Gibt das aktuelle Tagebuch zurück.
	 * @return
	 * 		Das aktuelle Tagebuch.
	 */
	public Diary getCurrentDiary(){
		return fDController.getFD().getCurrentDiary();
	}
	
	/**
	 * Gibt eine Liste aller Tagebücher zurück
	 * @return
	 * 		Liste aller Tagebücher
	 */
	public List<Diary> getDiaries(){
		return fDController.getFD().getDiaries();
	}
	
	/**
	 * Überprüft, ob in einem Tagebucheintrag ein Lebensmittel enthalten ist.
	 * @param entry
	 * 		Tagebucheintrag, der überpfüft werden soll.
	 * @param food
	 * 		Lebensmittel, nach dem geprüft werden soll
	 * @return
	 * 		Ist das Lebensmittel enthalten?
	 */
	public boolean containsFood(DiaryEntry entry, Food food){
		for(FoodEntry foodEntry : entry.getFoodEntryList()){
			if(foodEntry.getFood().equals(food)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Überprüft, ob in einem Tagebucheintrag ein Medikament enthalten ist.
	 * @param entry
	 * 		Tagebucheintrag, der überpfüft werden soll.
	 * @param food
	 * 		Medikament, nach dem geprüft werden soll
	 * @return
	 * 		Ist das Medikament enthalten?
	 */
	public boolean containsDrug(DiaryEntry entry, Drug drug){
		for(DrugEntry drugEntry : entry.getDrugEntryList()){
			if(drugEntry.getDrug().equals(drug)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Überprüft, ob in einem Tagebucheintrag ein Inhaltsstoff enthalten ist.
	 * @param entry
	 * 		Tagebucheintrag, der überpfüft werden soll.
	 * @param food
	 * 		Inhaltsstoff, nach dem geprüft werden soll
	 * @return
	 * 		Ist der Inhaltsstoff enthalten?
	 */
	public boolean containsIngredient(DiaryEntry entry, Ingredient ingredient){
		List<FoodEntry> foodEntryList = entry.getFoodEntryList();
		List<DrugEntry> drugEntryList = entry.getDrugEntryList();
		
		for(FoodEntry foodEntry : foodEntryList){
			if(foodEntry.getFood().getIngredientList().contains(ingredient)){
				return true;
			}
		}
		
		for(DrugEntry drugEntry : drugEntryList){
			if(drugEntry.getDrug().getIngredientList().contains(ingredient)){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Gibt die Menge aller Tagebucheinträge zurück, die zwischen den Daten to (inklusive) und from (exklusive) liegen
	 * @param from
	 * 		Startzeitpunkt inklusive
	 * @param to
	 * 		Endzeitpunkt exklusive
	 * @return
	 */
	public SortedSet<DiaryEntry> getDiaryEntriesByDate(Date from, Date to) throws NoCurrentDiaryException {
		if(getCurrentDiary() == null){
			throw new NoCurrentDiaryException();
		}
		
		SortedSet<DiaryEntry> diaryEntrySet = getCurrentDiary().getDiaryEntrySet();
		DiaryEntry fromEntry = new DiaryEntry(from, false, "");
		DiaryEntry toEntry = new DiaryEntry(to, false, "");
		return diaryEntrySet.subSet(fromEntry, toEntry);
	}
	
	/**
	 * Gibt alle Tagebucheinträge zurück, die an dem selben Tag sind wie der übergebene Zeitpunkt.
	 * @param date
	 * 		Zeitpunkt am gesuchten Tag
	 * @return
	 * 		Alle Tagebucheinträge, die an diesem Tag sind
	 * @throws NoCurrentDiaryException
	 */
	public SortedSet<DiaryEntry> getDiaryEntriesAtDay(Date date) throws NoCurrentDiaryException {
		Date day = new Date(date.getYear(), date.getMonth(), date.getDay());
		return getDiaryEntriesByDate(day, new Date(day.getTime() + 86400000));
	}
	
	/**
	 * @return Gibt die DiaryAUI zurück
	 */
	public List<DiaryAUI> getDiaryAUIList() {
		return diaryAUIList;
	}


	/**
	 * @return Gibt den FDController zurück
	 */
	public FDController getfDController() {
		return fDController;
	}

	/**
	 * @param fDController Setzt den FDController
	 */
	public void setfDController(FDController fDController) {
		this.fDController = fDController;
	}
}
