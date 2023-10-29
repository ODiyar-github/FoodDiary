package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class DrugTest {
	private Drug drug;
	
	@Before
    public void setUp() throws Exception {
		drug = new Drug("Ibu", "Bauchschmerzen");
	}
	
	@Test
	public void testKonstruktor(){
		assertEquals("Name muss gleich sein", "Ibu", drug.getName());
		assertEquals("SideEffects muss gleich sein", "Bauchschmerzen", drug.getSideEffects());
		assertEquals("IngredientList muss leer sein", new ArrayList<Ingredient>() , drug.getIngredientList());
	}
	
	@Test
	public void testGetAndSetName(){
		drug.setName("Paracetamol");
		assertEquals("Name muss gleich sein", "Paracetamol", drug.getName());
	}
	
	@Test
	public void testGetAndSetSideEffects(){
		drug.setSideEffects("Schwindel");
		assertEquals("Nebenwirkung muss gleich sein", "Schwindel", drug.getSideEffects());
	}
}
