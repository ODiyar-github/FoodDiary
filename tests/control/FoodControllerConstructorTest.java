package control;

import static org.junit.Assert.*;
import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Test;

public class FoodControllerConstructorTest {
	
	/**
	 * Konstruktortest, wenn null übergeben wird, wird eine NullPointerException
	 * geworfen.
	 * 
	 * @throws Exception
	 *             {@link ContextlistController#ContextlistController(GtdController)}
	 */
	@Test(expected = NullPointerException.class)
	public void testParameterNull() throws Exception {
		new FoodController(null);
	}

	/**
	 * 
	 */
	@Test
	public void test() {
		FDController fdController = new FDController();
		
		FoodController foodController = new FoodController(fdController);

		try {
			Assert.assertNotNull(foodController);
			Assert.assertNotNull(foodController.getArchiveAUIList());
			Assert.assertNotNull(foodController.getfDController());
			
			Assert.assertEquals(fdController, foodController.getfDController());
			
		} catch (Exception exception) {
			System.out.println("Diese Exception sollte niemals auftreten.");
			exception.printStackTrace();
		}
	}

}
