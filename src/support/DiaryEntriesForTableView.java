package support;

import java.util.ArrayList;
import java.util.SortedSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import support.NiceStrings;
import model.DiaryEntry;
import model.DrugEntry;
import model.FoodEntry;

public class DiaryEntriesForTableView 
{
	private String time;
	private String foods;
	private String drugs;
	private boolean complaint;
	private String description;
	
	public DiaryEntriesForTableView(DiaryEntry diaryEntry)
	{
		this.setTime(NiceStrings.dateToString(diaryEntry.getDate()));
		setFoodList(diaryEntry);
		setDrugList(diaryEntry);
		this.setComplaint(diaryEntry.isComplaint());
		this.setDescription(diaryEntry.getDescription());
	}

	private void setFoodList(DiaryEntry diaryEntry)
	{
		String bla = "";
		
		for(FoodEntry foodEntry : diaryEntry.getFoodEntryList())		
			bla = bla + foodEntry.getFood().getName() + " (" + foodEntry.getAmount() + NiceStrings.unitToString(foodEntry.getUnit()) + ")" + "\n";		
					
		foods = bla;
	}
	
	private void setDrugList(DiaryEntry diaryEntry)
	{
		String bla = "";
		
		for(DrugEntry drugEntry : diaryEntry.getDrugEntryList())		
			bla = bla + drugEntry.getDrug().getName() + " (" + drugEntry.getAmount() + NiceStrings.unitToString(drugEntry.getUnit()) + ")" + "\n";;
		
		drugs = bla;		
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getFoods() {
		return foods;
	}

	public void setFoods(String foods) {
		this.foods = foods;
	}

	public String getDrugs() {
		return drugs;
	}

	public void setDrugs(String drugs) {
		this.drugs = drugs;
	}

	public boolean isComplaint() {
		return complaint;
	}

	public void setComplaint(boolean complaint) {
		this.complaint = complaint;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static ObservableList<DiaryEntriesForTableView> getEntriesForTableView(SortedSet<DiaryEntry> diaryEntries)
	{
		SortedSet<DiaryEntry> diaryEntryList = diaryEntries;
    	ArrayList<DiaryEntry> entriesForTableView = new ArrayList<DiaryEntry>(diaryEntryList);

    	ArrayList<DiaryEntriesForTableView> liste = new ArrayList<DiaryEntriesForTableView>();

    	for(DiaryEntry entry : entriesForTableView)
    	{
    		DiaryEntriesForTableView entryForTableView = new DiaryEntriesForTableView(entry);
    		liste.add(entryForTableView);
    	}        	

    	ObservableList<DiaryEntriesForTableView> observableDiaryEntries = FXCollections.observableArrayList(liste);   
	
		return observableDiaryEntries;
	}
}
