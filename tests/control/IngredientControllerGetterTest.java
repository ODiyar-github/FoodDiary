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

public class IngredientControllerGetterTest {

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
		ingredientController = new IngredientController(fDController);		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = NullPointerException.class)
	public void testGetIngredientNameNull() throws Exception {
		ingredientController.getIngredient(null);
	}	
	
	@Test
	public void testGetfDController() throws Exception {
		Assert.assertNotNull(ingredientController.getfDController());
		Assert.assertEquals(fDController, ingredientController.getfDController());	
	}

	@Test
	public void testGetIngredient() {
		Ingredient testIngredient1 = new Ingredient("NAME1", "BESCHREIBUNG1");
		Ingredient testIngredient2 = new Ingredient("NAME2", "BESCHREIBUNG2");
		Ingredient testIngredient3 = new Ingredient("NAME3", "BESCHREIBUNG3");
		
		fDController.getFD().getArchive().getIngredientList().add(testIngredient1);
		fDController.getFD().getArchive().getIngredientList().add(testIngredient2);
		fDController.getFD().getArchive().getIngredientList().add(testIngredient3);
		
		Assert.assertEquals(testIngredient1, ingredientController.getIngredient("NAME1"));
		Assert.assertEquals(testIngredient2, ingredientController.getIngredient("NAME2"));
		Assert.assertEquals(testIngredient3, ingredientController.getIngredient("NAME3"));	
	}

}
