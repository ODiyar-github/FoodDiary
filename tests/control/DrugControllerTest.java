package control;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.Drug;
import model.Ingredient;
import org.junit.Test;
import org.junit.Before;

import control.DrugController;
import exceptions.AlreadyInArchiveException;

public class DrugControllerTest {
	
	
	FDController fDController = new FDController();
	DrugController drugController = new DrugController(fDController);
	Drug drug1;
	Ingredient ingredient1;
	List<Drug> searchedList;
	
	
	
	/**
	 * @throws AlreadyInArchiveException
	 * Erzeugt Medikament und fügt es hinzu
	 */
	@Before
	public void doBeforeTests() throws AlreadyInArchiveException{
		drug1 = new Drug("drug1","");
		try{
			drugController.addEntry(drug1);
		}
		catch(AlreadyInArchiveException a){	
		}
	}

	/**
	 * testet search(Drug drug)
	 */
	@Test
	public void testSearch() {
		List<Drug> searchedList = new ArrayList<Drug>();
		searchedList.add(drug1);
		assertEquals(searchedList,drugController.search("drug1"));
	}

	/**
	 * testet exists(Drug drug)
	 */
	@Test
	public void testExists(){
		assertTrue(drugController.exists("drug1"));
		assertFalse(drugController.exists("falseDrug"));
	}

	/**
	 * testet getDrug(Drug drug)
	 */
	@Test
	public void testGetDrug() {
		assertEquals(drug1,drugController.getDrug("drug1"));
		assertEquals(null,drugController.getDrug("falseDrug"));
		
	}

	
	/**
	 * testet addEntry(Drug drug,List<Ingredient> ingredientList)
	 */
	@Test
	public void testAddEntryDrugListOfIngredient() {
		drug1 = new Drug("drug1","");
		List<Ingredient> ingredientList = new ArrayList<Ingredient>();
		try{
			drugController.addEntry(drug1,ingredientList);
		}
		catch(AlreadyInArchiveException a){	
		}
		try{
			drugController.addEntry(drug1,ingredientList);
			fail("AlreadyInArchiveException wurde nicht geworfen");
		}
		catch(AlreadyInArchiveException a){	
			assertTrue(a.getMessage().equals("Der Eintrag drug1 befindet sich bereits im Archiv."));
		}	
		
	}
	
	/**
	 * testet addEntry(Drug drug)
	 */

	@Test (expected = AlreadyInArchiveException.class)
	public void testAddEntryDrug() throws AlreadyInArchiveException {
		try{
			drugController.addEntry(drug1);
			fail("AlreadyInArchiveException wurde nicht geworfen");
		}
		catch(AlreadyInArchiveException a){	
			assertTrue(a.getMessage().equals("Der Eintrag drug1 befindet sich bereits im Archiv."));
		}	
		
	}

	/**
	 * testet addIngredientToDrug(Drug drug,Ingredient ingredient)
	 */
	@Test
	public void testAddIngredientToDrugIngredientDrug() {
		Ingredient ingredient1 = new Ingredient("ingredient1","");
		drugController.addIngredientToDrug(ingredient1,drug1);
		assertTrue(drug1.getIngredientList().contains(ingredient1));
		drugController.addIngredientToDrug(ingredient1,drug1); //hinzufügen von bereits vorhandenem Inhaltsstoff
		assertTrue(drug1.getIngredientList().contains(ingredient1));
		drugController.removeIngredientFromDrug(ingredient1, drug1);
		assertFalse(drug1.getIngredientList().contains(ingredient1));//wenn ingredient1 noch in der Liste wäre, wäre es zweimal hinzugefügt worden
	}

	/**
	 * testet removeIngredientFromDrug(Drug drug Ingredient ingredient)
	 */
	@Test
	public void testRemoveIngredientFromDrugIngredientDrug() {
		Ingredient ingredient1 = new Ingredient("ingredient1","");
		drugController.addIngredientToDrug(ingredient1,drug1);
		drugController.removeIngredientFromDrug(ingredient1, drug1);
		assertFalse(drug1.getIngredientList().contains(ingredient1));
	}

}

