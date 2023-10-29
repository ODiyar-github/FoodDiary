package control;
import static org.junit.Assert.*;

import org.junit.Test;

public class DiaryControllerConstructorTest {
	
	/**
	 * Konstruktortest, wenn null übergeben wird, wird eine NullPointerException
	 * geworfen.
	 * 
	 * @throws Exception
	 */
	@Test(expected = NullPointerException.class)
	public void testParameterNull() throws Exception {
		new DiaryController(null);
	}
	
	@Test
	public void test() throws Exception {
		FDController fDController = new FDController();
		DiaryController diaryController = fDController.getDiaryController();
		
		assertEquals("Der Konstruktor muss den FDController korrekt setzen.", diaryController.getfDController(), fDController);
		assertNotNull("Der Konstruktor darf diaryAUIList nicht auf null setzen", diaryController.getDiaryAUIList());
		assertTrue("Der Konstruktor muss diaryAUIList als leere Liste setzen", diaryController.getDiaryAUIList().isEmpty());
	}
}

