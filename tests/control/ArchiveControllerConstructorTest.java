package control;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author sopr099
 * Test für den Konstruktor des ArchiveControllers
 */
public class ArchiveControllerConstructorTest {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Konstruktortest, wenn null übergeben wird, wird eine NullPointerException
	 * geworfen.
	 * 
	 * @throws Exception
	 */
	@Test(expected = NullPointerException.class)
	public void testParameterNull() throws Exception {
		new ArchiveController(null);
	}
	
	/**
	 * Konstruktortest der überprüft ob der FDController den ArchiveController korrekt setzt
	 */
	@Test
	public void test(){
		FDController fDController = new FDController();
		ArchiveController archiveController = fDController.getArchiveController();
		
		assertEquals("Der FDController wurde vom Konstruktor korrekt gesetzt.", archiveController.getfDController(), fDController);
		assertNotNull(archiveController.getfDController());
		assertNotNull(archiveController.getArchiveAUIList());
	}
}
