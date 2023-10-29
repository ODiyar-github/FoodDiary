package control;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class IngredientControllerConstructorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = NullPointerException.class)
	public void testParameterNull() throws Exception {
		new IngredientController(null);
	}
	
	@Test
	public void test() {
		
		FDController fDController = new FDController();		
		IngredientController ingredientController = new IngredientController(fDController);
				
		try 
		{
			Field fieldFDController = IngredientController.class.getDeclaredField("FDController");
			fieldFDController.setAccessible(true);
			FDController fDControllerField = (FDController) fieldFDController.get(ingredientController);
			assertNotNull(fDControllerField);
			assertEquals(fDController, fDControllerField);
		} catch (Exception exception) {
			System.out.println("Diese Exception sollte niemals auftreten.");
			exception.printStackTrace();
		}		
		
	}

}
