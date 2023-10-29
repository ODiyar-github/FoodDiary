package control;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

import control.FDController;
import control.DiaryController;
import exceptions.NoCurrentDiaryException;
import exceptions.DiaryAlreadyExistsException;
import model.*;

public class DiaryControllerTest {
	
	private Diary diary;
	private DiaryController diaryController;
	
	private Food milch;
	private Food keks;
	private Food kartoffel;
	private Drug aspirin;
	private Drug ibuprofen;
	private Ingredient laktose;
	private Ingredient zucker;
	private Ingredient acetylsalicylsaeure;
	private Ingredient gift;

	@Before
	public void setUp() throws Exception {
		FDController fDController = new FDController();
		diaryController = fDController.getDiaryController();
		diary = new Diary("Tagebuch-1");
		diaryController.addDiary(diary);
		diaryController.loadDiary(diary);
		
		milch = new Food("Milch", 0, 0, 0, 0);
		keks = new Food("Keks", 0, 0, 0, 0);
		kartoffel = new Food("Kartoffel", 0, 0, 0, 0);
		
		aspirin = new Drug("Aspirin", "");
		ibuprofen = new Drug("Ibuprofen", "");
		
		laktose = new Ingredient("Laktose", "");
		zucker = new Ingredient("Zucker", "");
		acetylsalicylsaeure = new Ingredient("Acetylsalicylsäure", "");
		gift = new Ingredient("Gift", "");
		
		milch.getIngredientList().add(laktose);
		keks.getIngredientList().add(zucker);
		aspirin.getIngredientList().add(acetylsalicylsaeure);
	}

	@Test
	public void testAddEntry() {
		DiaryEntry entry = new DiaryEntry(new Date(), false, "");
		
		try{
		diaryController.addEntry(entry);
		}
		catch(NoCurrentDiaryException exception){
			System.out.println("Diese Exception sollte niemals auftreten.");
			exception.printStackTrace();
		}
		
		assertFalse("Nachdem ein Eintrag hinzugefügt wurde, darf das Tagebuch nicht mehr leer sein.", diaryController.getCurrentDiary().getDiaryEntrySet().isEmpty());
		assertTrue("Nachdem ein Eintrag hinzugefügt wurde, befindet sich genau ein Eintrag im Tagebuch.", diaryController.getCurrentDiary().getDiaryEntrySet().size() == 1);
	}

	@Test
	public void testRemoveEntry() {
		DiaryEntry entry = new DiaryEntry(new Date(), false, "");
		
		try{
			diaryController.addEntry(entry);
		}
		catch(NoCurrentDiaryException exception){
			System.out.println("Diese Exception sollte niemals auftreten.");
			exception.printStackTrace();
		}
		
		try{
			diaryController.removeEntry(entry);
		}
		catch(NoCurrentDiaryException exception){
			System.out.println("Diese Exception sollte niemals auftreten.");
			exception.printStackTrace();
		}
		
		assertTrue("Nachdem der Eintrag wieder entfernt wurde, muss das Tagebuch leer sein.", diaryController.getCurrentDiary().getDiaryEntrySet().isEmpty());
	}

	@Test
	public void testChangeAmountFoodEntryDoubleUnit() {
		FoodEntry foodEntry = new FoodEntry(new Food("Milch", 0, 0, 0, 0), 15, Unit.LITER);
		
		diaryController.changeAmount(foodEntry, 1000, Unit.GRAM);
		
		assertTrue("Die Menge soll von changeAmount korrekt gesetzt sein.", foodEntry.getAmount() == 1000);
		assertTrue("Die Einheit soll von changeAmount korrekt gesetzt sein", foodEntry.getUnit() == Unit.GRAM);
	}

	@Test
	public void testChangeAmountDrugEntryDoubleUnit() {
		DrugEntry drugEntry = new DrugEntry(new Drug("Aspirin", ""), 0.005, Unit.GRAM);
		
		diaryController.changeAmount(drugEntry, 2, Unit.PIECE);
		
		assertTrue("Die Menge soll von changeAmount korrekt gesetzt sein.", drugEntry.getAmount() == 2);
		assertTrue("Die Einheit soll von changeAmount korrekt gesetzt sein", drugEntry.getUnit() == Unit.PIECE);
	}

	@Test
	public void testAddDiary() {
		Diary newDiary = new Diary("Tagebuch-2");
		
		try{
			diaryController.addDiary(newDiary);
			}
		catch(DiaryAlreadyExistsException exception){
			System.out.println("Diese Exception sollte niemals auftreten.");
		}
		
		assertTrue("Nachdem ein weiteres Tagebuch hinzugefügt wurde, gibt es genau zwei Tagebücher", diaryController.getDiaries().size() == 2);
		assertFalse("Das aktuelle Tagebuch hat sich durch das hinzufügen nicht geändert.", diaryController.getCurrentDiary() == newDiary);
		assertTrue("Das aktuelle Tagebuch hat sich druch das hinzufügen nicht geändert.", diaryController.getCurrentDiary() == diary);
	}
	
	@Test(expected = DiaryAlreadyExistsException.class)
	public void testAddAlreadyExistingDiary() throws Exception {
		Diary newDiary = new Diary("Tagebuch-1");
		diaryController.addDiary(newDiary);
	}

	@Test
	public void testContains() {
		DiaryEntry entry = new DiaryEntry(new Date(), true, "");
		
		entry.addFoodEntry(new FoodEntry(milch, 1, Unit.LITER));
		entry.addFoodEntry(new FoodEntry(keks, 5, Unit.PIECE));
		entry.addDrugEntry(new DrugEntry(aspirin, 2, Unit.PIECE));
		
		assertTrue("Der Eintrag enthält Milch", diaryController.containsFood(entry, milch));
		assertTrue("Der Eintrag enthält Kekse", diaryController.containsFood(entry, keks));
		assertTrue("Der Eintrag enthält Aspirin", diaryController.containsDrug(entry, aspirin));
		assertTrue("Der Eintrag enthält Acetylsalicylsäure", diaryController.containsIngredient(entry, acetylsalicylsaeure));
		
		assertFalse("Der Eintrag enthält keine Kartoffeln", diaryController.containsFood(entry, kartoffel));
		assertFalse("Der Eintrag enthält kein Gift", diaryController.containsIngredient(entry, gift));
		assertFalse("Der Eintrag enthält kein Ibuprofen", diaryController.containsDrug(entry, ibuprofen));
	}

	@Test
	public void testGetDiaryEntriesByDate() {
		Date from = new Date(500);
		Date to = new Date(10000);
		
		DiaryEntry entry1 = new DiaryEntry(new Date(100), false, "");
		DiaryEntry entry2 = new DiaryEntry(new Date(499), false, "");
		DiaryEntry entry3 = new DiaryEntry(new Date(500), false, "");
		DiaryEntry entry4 = new DiaryEntry(new Date(5000), false, "");
		DiaryEntry entry5 = new DiaryEntry(new Date(9999), false, "");
		DiaryEntry entry6 = new DiaryEntry(new Date(10000), false, "");
		DiaryEntry entry7 = new DiaryEntry(new Date(500000), false, "");
		
		SortedSet<DiaryEntry> returnSet = new TreeSet<DiaryEntry>();
		
		try{
			diaryController.addEntry(entry1);
			diaryController.addEntry(entry2);
			diaryController.addEntry(entry3);
			diaryController.addEntry(entry4);
			diaryController.addEntry(entry5);
			diaryController.addEntry(entry6);
			diaryController.addEntry(entry7);
			returnSet = diaryController.getDiaryEntriesByDate(from, to);
		}
		catch(NoCurrentDiaryException exception){
			System.out.println("Diese Exception sollte niemals auftreten.");
		}
		
		assertFalse("Der erste Eintrag liegt nicht im Zeitraum", returnSet.contains(entry1));
		assertFalse("Der zweite Eintrag liegt nicht im Zeitraum", returnSet.contains(entry2));
		assertTrue("Der dritte Eintrag liegt im Zeitraum", returnSet.contains(entry3));
		assertTrue("Der vierte Eintrag liegt im Zeitraum", returnSet.contains(entry4));
		assertTrue("Der fünfte Eintrag liegt im Zeitraum", returnSet.contains(entry5));
		assertFalse("Der sechste Eintrag liegt nicht im Zeitraum", returnSet.contains(entry6));
		assertFalse("Der siebte Eintrag liegt nicht im Zeitraum", returnSet.contains(entry7));
	}

	@Test
	public void testGetDiaryEntriesAtDay() {
		Date date1 = new Date(2017, 5, 2, 20, 7, 33);
		Date date2 = new Date(2017, 5, 2, 23, 59, 59);
		Date date3 = new Date(2017, 5, 3);
		Date date4 = new Date(2017, 5, 3, 15, 38, 17);
		Date date5 = new Date(2017, 5, 3, 23, 59, 59);
		Date date6 = new Date(2017, 5, 4);
		Date date7 = new Date(2017, 5, 4, 14, 18, 3);
		
		DiaryEntry entry1 = new DiaryEntry(date1, false, "");
		DiaryEntry entry2 = new DiaryEntry(date2, false, "");
		DiaryEntry entry3 = new DiaryEntry(date3, false, "");
		DiaryEntry entry4 = new DiaryEntry(date4, false, "");
		DiaryEntry entry5 = new DiaryEntry(date5, false, "");
		DiaryEntry entry6 = new DiaryEntry(date6, false, "");
		DiaryEntry entry7 = new DiaryEntry(date7, false, "");
		
		SortedSet<DiaryEntry> returnSet = new TreeSet<DiaryEntry>();
		
		try{
			diaryController.addEntry(entry1);
			diaryController.addEntry(entry2);
			diaryController.addEntry(entry3);
			diaryController.addEntry(entry4);
			diaryController.addEntry(entry5);
			diaryController.addEntry(entry6);
			diaryController.addEntry(entry7);
			returnSet = diaryController.getDiaryEntriesAtDay(new Date(2017, 5, 3, 11, 24, 34));
		}
		catch(NoCurrentDiaryException exception){
			System.out.println("Diese Exception sollte niemals auftreten.");
		}
	}
	
	@Test
	public void testAnalyze() {
		
	}
}
