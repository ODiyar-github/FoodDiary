package control;


import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.Test;
import model.Diary;
import model.DiaryEntry;
import model.Food;
import model.FoodEntry;
import model.Unit;

/**
 * @author sopr099
 * Testet die Funktionen von Printl
 */
public class PrintlTest {
	
	static FDController fDController = new FDController();
	static DiaryController diaryController =fDController.getDiaryController();
	static IOController iOController =fDController.getIOController();
	static ArrayList<FoodEntry> foodEntryList1;
	static ArrayList<FoodEntry> foodEntryList2;

	
	/**
	 * Testet das drucken von Testdaten
	 */
	@Test
	public void main(){
		Diary diary = new Diary("testDiary");
		DiaryEntry entry1 = new DiaryEntry(LocalDateTime.of(2017, 5, 3, 11, 24, 34), false, "beschreibung1");
		foodEntryList1 = new ArrayList<FoodEntry>();
		Food food1 = new Food("name1", 1, 1, 1, 1);
		Unit gram = Unit.GRAM;
		foodEntryList1.add(new FoodEntry(food1,1,gram));
		//System.out.println("34");
		entry1.addFoodEntries(foodEntryList1);
		DiaryEntry entry2 = new DiaryEntry(LocalDateTime.of(2017, 5, 3, 11, 42, 43), false, "beschreibung2");
		foodEntryList2 = new ArrayList<FoodEntry>();
		Food food2 = new Food("name2", 1, 1, 1, 1);
		foodEntryList2.add(new FoodEntry(food2,1,gram));
		Food food3 = new Food("name3", 1, 1, 1, 1);
		foodEntryList2.add(new FoodEntry(food3,1,gram));
		entry2.addFoodEntries(foodEntryList2);
		//System.out.println("43");
		try{
		diaryController.loadDiary(diary);
		diaryController.addEntry(entry1);
		diaryController.addEntry(entry2);
		//System.out.println("try");
		}
		catch(Exception e){}
		//System.out.println("afterCatch");
		iOController.printl(diary.getDiaryEntrySet());
		//System.out.println("afterPrintl");
		//iOController.print("test");
	}
	

}
