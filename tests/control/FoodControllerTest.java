package control;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import exceptions.AlreadyInArchiveException;
import model.Archive;
import model.Food;
import model.FoodDiary;
import model.Ingredient;
import view.ArchiveAUI;

/**
 * @author sopr099
 * 
 */
public class FoodControllerTest {
	
	FoodController foodController;
	FDController fdController;
	FoodDiary foodDiary;
	Archive archive;
	
	ArrayList<Food> foodList;
	Food firstFood,secondFood,thirdFood;

	ArrayList<Ingredient> ingredientList;
	Ingredient ingredient;
	
	ArchiveAUI aui;

	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		firstFood = new Food("Hafermilch", 0, 1, 2, 3);
		secondFood = new Food("Haferflocken", 0, 1, 2, 3);
		ingredient = new Ingredient("Ibuprofen", "Kopfschmerzen");
	
		archive = new Archive();
		archive.getFoodList().add(firstFood);
		archive.getFoodList().add(secondFood);
		
		fdController = new FDController();
		foodController = new FoodController(fdController);
		foodDiary = new FoodDiary(archive);
		fdController.setFD(foodDiary);
		
		foodList = new ArrayList<Food>();
		ingredientList = new ArrayList<Ingredient>();
		

		

	}

	/**
	 *  Testet alle interessanten Methoden aus FoodContoller
	 */
	@Test
	public void test() {
		testGetFood();
		testModifyEntry();
		testSearch();
		testAddEntry();
		testAddOrRemoveIngredient();
	}
	
	/**
	 * Test getFood
	 */
	@Test
	public void testGetFood() {
		Assert.assertEquals(firstFood,foodController.getFood("Hafermilch"));
	}
	
	/**
	 * Test modifyEntry
	 */
	@Test
	public void testModifyEntry() {
		Assert.assertEquals(0,foodController.getFood("Hafermilch").getCalories());
		foodController.modifyEntry(firstFood, 1, 0, 0, 0);
		Assert.assertEquals(1,foodController.getFood("Hafermilch").getCalories());
	}
	
	/**
	 * Test search
	 */
	@Test
	public void testSearch() {
		//suche nach Honig gibt leere Liste zurück
		Assert.assertEquals(foodList,foodController.search("Honig"));
		//suche nach "Hafer" gibt Liste mit allen Einträgen zurück
		Assert.assertEquals(foodDiary.getArchive().getFoodList(),foodController.search("Hafer"));
	}
	
	/**
	 * Test addEntry mit und ohne IngredientList als Argument und exists
	 */
	@Test
	public void testAddEntry() {
		try {
			Assert.assertEquals(false,foodController.exists("Milch"));
			Assert.assertEquals(true,foodController.exists("Haferflocken"));
			foodController.addEntry(new Food("Milch", 0, 0, 0, 0));
			Assert.assertEquals(true,foodController.exists("Milch"));
			
			thirdFood = new Food("Schokolade", 0, 0, 0, 0);
			ingredientList.add(ingredient);
			Assert.assertEquals(false,foodController.exists("Schokolade"));
			foodController.addEntry(thirdFood, ingredientList);
			Assert.assertEquals(true,foodController.exists("Schokolade"));
		} 
		catch(AlreadyInArchiveException exception) {
			System.out.println("Diese Exception sollte niemals auftreten.");
			exception.printStackTrace();
		}
		
	}
	
	/**
	 * Test addIngredientToFood und removeIngredientFromFood
	 */
	@Test
	public void testAddOrRemoveIngredient() {
		
		
		Assert.assertEquals(false, firstFood.getIngredientList().contains(ingredient));
		foodController.addIngredientToFood(ingredient,firstFood);
		Assert.assertEquals(true, firstFood.getIngredientList().contains(ingredient));
		foodController.removeIngredientFromFood(ingredient, firstFood);
		Assert.assertEquals(false, firstFood.getIngredientList().contains(ingredient));
	}
	
	
}