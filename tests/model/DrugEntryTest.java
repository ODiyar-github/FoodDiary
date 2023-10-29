package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DrugEntryTest {
	private DrugEntry drugEntry;
	private Drug drug;
	@Before
    public void setUp() throws Exception {
		drug = new Drug("Ibu", "Bauchschmerzen");
		drugEntry = new DrugEntry(drug, 500, Unit.PIECE);
	}
	
	@Test
	public void testKonstruktor(){
		drug = new Drug("Ibu", "Bauchschmerzen");
		drugEntry = new DrugEntry(drug, 500, Unit.PIECE);
		assertEquals("Drug muss gleich sein", drug, drugEntry.getDrug());
		assertTrue("Amount muss gleich sein", 500== drugEntry.getAmount());
		assertEquals("Unit muss gleich sein", Unit.PIECE, drugEntry.getUnit());
	}
	
	@Test
	public void testGetAndSetAmount(){
		drugEntry.setAmount(1000);
		assertTrue("Amount muss gleich sein", 1000==drugEntry.getAmount());
	}
	
	@Test
	public void testGetAndSetIngredient(){
		Ingredient ingredient = new Ingredient("Fructose", "Fruchtzucker");
		drugEntry.setIngredient(ingredient);
		assertEquals("Ingredient muss gleich sein", ingredient, drugEntry.getIngredient());
	}
	
	@Test
	public void testGetAndSetDrug(){
		Drug drug = new Drug("Paracetamol", "Schwindel");
		drugEntry.setDrug(drug);
		assertEquals("Drug muss gleich sein", drug, drugEntry.getDrug());
	}
	
	@Test
	public void testGetAndSetUnit(){
		drugEntry.setUnit(Unit.DROP);
		assertEquals("Unit muss gleich sein", Unit.DROP, drugEntry.getUnit());
	}
}
