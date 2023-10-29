package control;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Drug;
import model.Ingredient;

public class IngredientControllerSearchTest {

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
	public void testNameNull() throws Exception {	
		
		ingredientController.search(null);	
	}
	
	@Test
	public void testSearch() {
		
		Ingredient testIngredient1 = new Ingredient("NAME1", "BESCHREIBUNG1");
		Ingredient testIngredient2 = new Ingredient("NAME2", "BESCHREIBUNG2");
		Ingredient testIngredient3 = new Ingredient("33333", "BESCHREIBUNG3");
		
		fDController.getFD().getArchive().getIngredientList().add(testIngredient1);
		fDController.getFD().getArchive().getIngredientList().add(testIngredient2);
		fDController.getFD().getArchive().getIngredientList().add(testIngredient3);
		
		List<Ingredient> resultListToCheckCorrect = new ArrayList<Ingredient>();
		resultListToCheckCorrect.add(testIngredient1);
		resultListToCheckCorrect.add(testIngredient2);
		
		List<Ingredient> resultListToCheckNotCorrect = new ArrayList<Ingredient>();
		resultListToCheckNotCorrect.add(testIngredient1);
		resultListToCheckNotCorrect.add(testIngredient2);
		resultListToCheckNotCorrect.add(testIngredient3);
		
		List<Ingredient> resultList = ingredientController.search("NAME");
		
		Assert.assertEquals(resultListToCheckCorrect, resultList);
		Assert.assertNotEquals(resultListToCheckNotCorrect, resultList);
	}

}
