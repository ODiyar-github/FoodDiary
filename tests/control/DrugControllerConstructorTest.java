package control;

import static org.junit.Assert.*;

import org.junit.Test;


public class DrugControllerConstructorTest {
	
	/**
	 * testet den Konstruktor der Klasse DrugController
	 */
	
	@Test(expected = NullPointerException.class)
	public void testParameterNull() throws Exception {
		new DrugController(null);
	}
 
	@Test
	public void test() throws Exception {
		
		FDController fDController = new FDController();
		DrugController drugController = new DrugController(fDController);
		
		try{
			assertNotNull(drugController);
			assertNotNull(drugController.getfDController());
			assertNotNull(drugController.getArchiveAUIList()); //
			assertEquals(drugController.getfDController(),fDController);
		}
		catch (Exception exception) {
			System.out.println("Diese Exception sollte niemals auftreten.");
			exception.printStackTrace();
		}

	}

}
