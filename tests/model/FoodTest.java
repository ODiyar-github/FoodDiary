package model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class FoodTest {
	private Food food;
	
	@Before
    public void setUp() throws Exception {
		food = new Food("Nudeln", 300, 150, 100, 50);
	}
	
	@Test
	public void testKonstruktor(){
		assertEquals("Name muss gleich sein", "Nudeln", food.getName());
		assertEquals("Kalorien müssen gleich sein", 300, food.getCalories());
		assertEquals("Proteine müssen gleich sein", 150, food.getProtein());
		assertEquals("Fette müssen gleich sein", 100, food.getFat());
		assertEquals("Kohlenhydrate müssen gleich sein", 50, food.getCarbohydrates());
		assertEquals("IngredientList muss leer sein", new ArrayList<Ingredient>(), food.getIngredientList());
	}
	
	@Test
	public void testGetAndSetName(){
		food.setName("Pasta");
		assertEquals("Name muss gleich sein", "Pasta", food.getName());
	}
	
	@Test
	public void testGetAndSetCalories(){
		food.setCalories(1000);
		assertEquals("Kalorien müssen gleich sein", 1000, food.getCalories());
	}
	
	@Test
	public void testGetAndSetProtein(){
		food.setProtein(1000);
		assertEquals("Proteine müssen gleich sein", 1000, food.getProtein());
	}
	
	@Test
	public void testGetAndSetFat(){
		food.setFat(1000);
		assertEquals("Fett muss gleich sein", 1000, food.getFat());
	}
	
	@Test
	public void testGetAndSetCarbohydrates(){
		food.setCarbohydrates(1000);
		assertEquals("Kohlenhydrate müssen gleich sein", 1000, food.getCarbohydrates());
	}
}
