package control;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.AlreadyInArchiveException;
import junit.framework.Assert;
import model.Drug;
import model.Food;
import model.Ingredient;
import view.ArchiveAUI;

public class IngredientControllerAddEntryTest {

	IngredientController ingredientController;
	List<ArchiveAUI> archiveAUIList;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		FDController fDController = new FDController();
		ingredientController = fDController.getIngredientController();		
		
		archiveAUIList = new ArrayList<ArchiveAUI>();
		archiveAUIList.add(null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = NullPointerException.class)
	public void testAddEntryIngredientNull() throws Exception {
		ingredientController.addEntry(null);
	}	
	
	@Test(expected = NullPointerException.class)
	public void testNull() throws Exception {
		ingredientController.addEntry(null);
	}
	
	@Test(expected = AlreadyInArchiveException.class)
	public void testAddEntryAlreadyInArchiveException() throws Exception{
		
		Ingredient testIngredient = new Ingredient("NAME", "BESCHREIBUNG");
		ingredientController.addEntry(testIngredient);
		ingredientController.addEntry(testIngredient);		
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddEntryWithListIngridientNull() throws Exception {
			
		Food testFood = new Food("FOOD", 10, 10, 10, 10);
		Drug testDrug = new Drug("NAME", "NEBENWIRKUNG");
		
		List<Food> foodList = new ArrayList<Food>();
		List<Drug> drugList = new ArrayList<Drug>();
		
		foodList.add(testFood);
		drugList.add(testDrug);		
		
		ingredientController.addEntry(null, foodList, drugList);
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddEntryWithListFoodListNull() throws Exception {			
		
		Drug testDrug = new Drug("NAME", "NEBENWIRKUNG");
		List<Drug> drugList = new ArrayList<Drug>();
		drugList.add(testDrug);	
		
		Ingredient testIngredient = new Ingredient("NAME", "BESCHREIBUNG");			
		
		ingredientController.addEntry(testIngredient, null, drugList);
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddEntryWithListDrugListNull() throws Exception {
		
		Food testFood = new Food("FOOD", 10, 10, 10, 10);
		List<Food> foodList = new ArrayList<Food>();
		foodList.add(testFood);
		
		Ingredient testIngredient = new Ingredient("NAME", "BESCHREIBUNG");
		
		ingredientController.addEntry(testIngredient, foodList, null);		
	}
	
	@Test
	public void testAddEntryIngredientWithFoodListAndDrugList() throws Exception{
		
		Ingredient testIngredient = new Ingredient("NAME", "BESCHREIBUNG");	
		
		Food testFood = new Food("FOOD", 10, 10, 10, 10);
		Drug testDrug = new Drug("NAME", "NEBENWIRKUNG");
		
		List<Food> foodList = new ArrayList<Food>();
		List<Drug> drugList = new ArrayList<Drug>();
		
		foodList.add(testFood);
		drugList.add(testDrug);	
		
		ingredientController.addEntry(testIngredient, foodList, drugList);
		
		assertEquals(testIngredient, ingredientController.getIngredient("NAME"));
		assertEquals(foodList, ingredientController.getIngredient("NAME").getFoodList());
		assertEquals(drugList, ingredientController.getIngredient("NAME").getDrugList());
	}

	@Test
	public void testAddEntryIngredient() throws Exception {
		
		Ingredient testIngredient = new Ingredient("NAME", "BESCHREIBUNG");	
		
		ingredientController.addEntry(testIngredient);
		
		assertEquals(testIngredient, ingredientController.getIngredient("NAME"));			
	}

}
