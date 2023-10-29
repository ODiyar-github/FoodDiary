package model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ArchiveTest {
	private Archive archive;
	
	@Before
    public void setUp() throws Exception {
		archive= new Archive();
	}
	
	@Test
	public void testKonstruktor(){
		assertEquals("IngredientList muss leer sein", new ArrayList<Ingredient>() , archive.getIngredientList());
		assertEquals("FoodList muss leer sein", new ArrayList<Food>() , archive.getFoodList());
		assertEquals("DrugList muss leer sein", new ArrayList<Drug>() , archive.getDrugList());
	}
	
	@Test
	public void testGetDrugList(){
		assertEquals("DrugList muss gleich sein", new ArrayList<Drug>(), archive.getDrugList());
	}
	
	@Test
	public void testGetFoodList(){
		assertEquals("FoodList muss gleich sein", new ArrayList<Food>(), archive.getFoodList());
	}
	
	@Test
	public void testGetIngredientList(){
		assertEquals("IngredientList muss gleich sein", new ArrayList<Ingredient>(), archive.getIngredientList());
	}
}
