package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import exceptions.NotInListException;

public class DiaryEntryTest {
	private DiaryEntry diaryEntry;
	
	@Before
    public void setUp() throws Exception {
		@SuppressWarnings("deprecation")
		Date date = new Date(117, 8, 22);
		diaryEntry = new DiaryEntry(date, true, "Beschwerdenbeschreibung");
    }
	
	@SuppressWarnings("deprecation")
	@Test
	public void testKonstruktor() {
	    assertEquals("Datum muss gleich sein", new Date(117,8,22), diaryEntry.getDate());
	     assertEquals("Complaint muss true sein", true, diaryEntry.isComplaint());
	     assertEquals("Beschwerde muss gleich sein", "Beschwerdenbeschreibung", diaryEntry.getDescription());
	     assertEquals("FoodList muss leer sein", new ArrayList<FoodEntry>(), diaryEntry.getFoodEntryList());
	     assertEquals("DrugList muss leer sein", new ArrayList<DrugEntry>(), diaryEntry.getDrugEntryList());
	}
	
	@Test
	public void testAddFoodEntry(){
		ArrayList<FoodEntry> foodList= new ArrayList<FoodEntry>();
		Food food = new Food("Ei", 1, 20, 2, 5);
		FoodEntry foodEntry = new FoodEntry(food, 10, Unit.PIECE);
		foodList.add(foodEntry);
		diaryEntry.addFoodEntry(foodEntry);
		assertEquals("FoodList muss neu eingefügtes Objekt enthalten.", foodList, diaryEntry.getFoodEntryList());
	}
	 
	@Test
	public void testAddFoodEntries(){
		ArrayList<FoodEntry> foodList= new ArrayList<FoodEntry>();
		Food food1 = new Food("Ei", 1, 20, 2, 5);
		FoodEntry foodEntry1 = new FoodEntry(food1, 10, Unit.PIECE);
		Food food2 = new Food("Spinat", 15, 10, 8, 6);
		FoodEntry foodEntry2 = new FoodEntry(food2, 10, Unit.GRAM);
		Food food3 = new Food("Milch", 7, 3, 9, 8);
		FoodEntry foodEntry3 = new FoodEntry(food3, 10, Unit.LITER);
		foodList.add(foodEntry1);
		foodList.add(foodEntry2);
		foodList.add(foodEntry3);
		diaryEntry.addFoodEntries(foodList);
		assertEquals("FoodList muss neu eingefügte Objekte enthalten.", foodList, diaryEntry.getFoodEntryList());
	}
	
	@Test
	public void testRemoveFoodEntry() throws NotInListException{
		ArrayList<FoodEntry> foodList= new ArrayList<FoodEntry>();
		Food food1 = new Food("Ei", 1, 20, 2, 5);
		FoodEntry foodEntry1 = new FoodEntry(food1, 10, Unit.PIECE);
		Food food2 = new Food("Spinat", 15, 10, 8, 6);
		FoodEntry foodEntry2 = new FoodEntry(food2, 10, Unit.GRAM);
		foodList.add(foodEntry1);
		foodList.add(foodEntry2);
		
		Food food3 = new Food("Milch", 7, 3, 9, 8);
		FoodEntry foodEntry3 = new FoodEntry(food3, 10, Unit.LITER);
		
		diaryEntry.addFoodEntries(foodList);
		diaryEntry.addFoodEntry(foodEntry3);
		diaryEntry.removeFoodEntry(foodEntry3);
		assertEquals("FoodList darf gelöschtes Objekt nicht mehr enthalten", foodList, diaryEntry.getFoodEntryList());
	}
	 
	@Test
	public void testAddDrugEntry(){
		ArrayList<DrugEntry> drugList= new ArrayList<DrugEntry>();
		Drug drug = new Drug("Ibu", "Durchfall");
		DrugEntry drugEntry = new DrugEntry(drug, 1, Unit.PIECE);
		drugList.add(drugEntry);
		diaryEntry.addDrugEntry(drugEntry);
		assertEquals("DrugList muss neu eingefügtes Objekt enthalten.", drugList, diaryEntry.getDrugEntryList());
	}
	
	@Test
	public void testAddDrugEntries(){
		ArrayList<DrugEntry> drugList= new ArrayList<DrugEntry>();
		Drug drug1 = new Drug("Ibu", "Durchfall");
		DrugEntry drugEntry1 = new DrugEntry(drug1, 1, Unit.PIECE);
		Drug drug2 = new Drug("Paracetamol", "Schwindel");
		DrugEntry drugEntry2 = new DrugEntry(drug2, 1, Unit.PIECE);
		Drug drug3 = new Drug("Ritalin", "Gedächtnisverlust");
		DrugEntry drugEntry3 = new DrugEntry(drug3, 1, Unit.PIECE);
		drugList.add(drugEntry1);
		drugList.add(drugEntry2);
		drugList.add(drugEntry3);
		diaryEntry.addDrugEntries(drugList);
		assertEquals("DrugList muss neu eingefügte Objekte enthalten.", drugList, diaryEntry.getDrugEntryList());
	}
	
	@Test
	public void testRemoveDrugEntry() throws NotInListException{
		ArrayList<DrugEntry> drugList= new ArrayList<DrugEntry>();
		Drug drug1 = new Drug("Ibu", "Durchfall");
		DrugEntry drugEntry1 = new DrugEntry(drug1, 1, Unit.PIECE);
		Drug drug2 = new Drug("Paracetamol", "Schwindel");
		DrugEntry drugEntry2 = new DrugEntry(drug2, 1, Unit.PIECE);
		drugList.add(drugEntry1);
		drugList.add(drugEntry2);
		
		Drug drug3 = new Drug("Ritalin", "Gedächtnisverlust");
		DrugEntry drugEntry3 = new DrugEntry(drug3, 1, Unit.PIECE);
		
		diaryEntry.addDrugEntries(drugList);
		diaryEntry.addDrugEntry(drugEntry3);
		diaryEntry.removeDrugEntry(drugEntry3);
		assertEquals("FoodList darf gelöschtes Objekt nicht mehr enthalten", drugList, diaryEntry.getDrugEntryList());
	}
	
	@Test
	public void testGetAndSetDate(){
		@SuppressWarnings("deprecation")
		Date date = new Date(10,2,11);
		diaryEntry.setDate(date);
		assertEquals("Date muss 11.3.1910 sein.", date, diaryEntry.getDate());
	}
	
	@Test
	public void testIsAndSetComplaint(){
		diaryEntry.setComplaint(false);
		assertEquals("Complaint muss false sein", false, diaryEntry.isComplaint());
	}
	
	@Test
	public void testGetAndSetDescription(){
		diaryEntry.setDescription("Neue Beschwerdenbeschreibung");
		assertEquals("Descrition muss 'Neue Beschwerdenbeschreibung' heißen", "Neue Beschwerdenbeschreibung", diaryEntry.getDescription() );
	}
	
	@Test
	public void testGetFoodList(){
		ArrayList<FoodEntry> foodList= new ArrayList<FoodEntry>();
		Food food1 = new Food("Ei", 1, 20, 2, 5);
		FoodEntry foodEntry1 = new FoodEntry(food1, 10, Unit.PIECE);
		Food food2 = new Food("Spinat", 15, 10, 8, 6);
		FoodEntry foodEntry2 = new FoodEntry(food2, 10, Unit.GRAM);
		Food food3 = new Food("Milch", 7, 3, 9, 8);
		FoodEntry foodEntry3 = new FoodEntry(food3, 10, Unit.LITER);
		foodList.add(foodEntry1);
		foodList.add(foodEntry2);
		foodList.add(foodEntry3);
		diaryEntry.addFoodEntries(foodList);
		assertEquals("FoodList aus diaryEntry muss foodList aus dieser Methode entsprechen", foodList, diaryEntry.getFoodEntryList());
	}
	
	@Test
	public void testGetDrugList(){
		ArrayList<DrugEntry> drugList= new ArrayList<DrugEntry>();
		Drug drug1 = new Drug("Ibu", "Durchfall");
		DrugEntry drugEntry1 = new DrugEntry(drug1, 1, Unit.PIECE);
		Drug drug2 = new Drug("Paracetamol", "Schwindel");
		DrugEntry drugEntry2 = new DrugEntry(drug2, 1, Unit.PIECE);
		Drug drug3 = new Drug("Ritalin", "Gedächtnisverlust");
		DrugEntry drugEntry3 = new DrugEntry(drug3, 1, Unit.PIECE);
		drugList.add(drugEntry1);
		drugList.add(drugEntry2);
		drugList.add(drugEntry3);
		diaryEntry.addDrugEntries(drugList);
		assertEquals("DrugList aus diaryEntry muss drugList aus dieser Methode entsprechen", drugList, diaryEntry.getDrugEntryList());
	}
}
