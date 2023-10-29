package control;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import model.Ingredient;

public class IngredientControllerModifyEntryTest {

	IngredientController ingredientController;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		FDController fDController = new FDController();
		ingredientController = new IngredientController(fDController);		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = NullPointerException.class)
	public void testIngredientNull() throws Exception {
		ingredientController.modifyEntry(null, "BESCHREIBUNG");
	}	
	
	@Test(expected = NullPointerException.class)
	public void testDescriptionNull() throws Exception {
		
		Ingredient testIngredient = new Ingredient("NAME", "BESCHREIBUNG");
		ingredientController.modifyEntry(testIngredient, null);
	}
	
	@Test
	public void testModifyEntry() throws Exception{
		
		Ingredient testIngredient = new Ingredient("NAME", "BESCHREIBUNG");
		ingredientController.modifyEntry(testIngredient, "BeschreibungNEU");
		
		assertEquals("BeschreibungNEU", ingredientController.getIngredient("NAME").getDescription());
		assertNotEquals("BESCHREIBUNG", ingredientController.getIngredient("NAME").getDescription());		
	}
}
