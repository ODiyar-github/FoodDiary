package model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class IngredientTest {
	private Ingredient ingredient;
	
	@Before
    public void setUp() throws Exception {
		ingredient= new Ingredient("Fructose", "Fruchtzucker");
	}
	
	@Test
	public void testKonstruktor(){
		assertEquals("Name muss gleich sein", "Fructose", ingredient.getName());
		assertEquals("Beschreibung muss gleich sein", "Fruchtzucker", ingredient.getDescription());
		assertEquals("FoodList muss leer sein", new ArrayList<Food>() , ingredient.getFoodList());
		assertEquals("DrugList muss leer sein", new ArrayList<Drug>() , ingredient.getDrugList());
	}
	
	@Test
	public void testGetAndSetName(){
		ingredient.setName("Tomate");
		assertEquals("Name muss gleich sein", "Tomate", ingredient.getName());
	}
	
	@Test
	public void testGetAndSetDescription(){
		ingredient.setDescription("Neue Beschreibung");
		assertEquals("Beschreibung muss gleich sein", "Neue Beschreibung", ingredient.getDescription());
	}
}
