package control;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Ingredient;

public class IngredientControllerExistsTest {

	IngredientController ingredientController;
	FDController fDController;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		fDController = new FDController();
		ingredientController = fDController.getIngredientController();		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = NullPointerException.class)
	public void testExistsNameNull() throws Exception {
		ingredientController.exists(null);
	}
	
	@Test
	public void testExists() throws Exception {
		
		Ingredient testIngredient1 = new Ingredient("NAME1", "BESCHREIBUNG1");
		Ingredient testIngredient2 = new Ingredient("NAME2", "BESCHREIBUNG2");
		Ingredient testIngredient3 = new Ingredient("NAME3", "BESCHREIBUNG3");
		
		fDController.getFD().getArchive().getIngredientList().add(testIngredient1);
		fDController.getFD().getArchive().getIngredientList().add(testIngredient2);
		fDController.getFD().getArchive().getIngredientList().add(testIngredient3);
		
		Assert.assertTrue(ingredientController.exists("NAME1"));	
		Assert.assertTrue(ingredientController.exists("NAME2"));	
		Assert.assertTrue(ingredientController.exists("NAME3"));	
	}
	
	@Test
	public void testNotExists() throws Exception {
	
		Ingredient testIngredient1 = new Ingredient("NAME1", "BESCHREIBUNG1");
		Ingredient testIngredient2 = new Ingredient("NAME2", "BESCHREIBUNG2");
		Ingredient testIngredient3 = new Ingredient("NAME3", "BESCHREIBUNG3");
		
		fDController.getFD().getArchive().getIngredientList().add(testIngredient1);
		fDController.getFD().getArchive().getIngredientList().add(testIngredient2);
		fDController.getFD().getArchive().getIngredientList().add(testIngredient3);
		
		Assert.assertFalse(ingredientController.exists("NAME4"));	
	}

}
