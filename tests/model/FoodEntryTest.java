package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FoodEntryTest {
	private FoodEntry foodEntry;
	private Food food;
	
	@Before
    public void setUp() throws Exception {
		food = new Food("Nudeln", 1000, 500, 250, 125);
		foodEntry = new FoodEntry(food, 500, Unit.PIECE);
	}
	
	@Test
	public void testKonstruktor(){
		foodEntry = new FoodEntry(food, 500, Unit.PIECE);
		assertEquals("Food muss gleich sein", food, foodEntry.getFood());
		assertTrue("Amount muss gleich sein", 500== foodEntry.getAmount());
		assertEquals("Unit muss gleich sein", Unit.PIECE, foodEntry.getUnit());
	}
	
	@Test
	public void testGetAndSetAmount(){
		foodEntry.setAmount(1000);
		assertTrue("Amount muss gleich sein", 1000==foodEntry.getAmount());
	}
	
	@Test
	public void testgetAndSetFood(){
		Food food = new Food("Pasta", 500, 250, 125, 100);
		foodEntry.setFood(food);
		assertEquals("Food muss gleich sein", food, foodEntry.getFood());
	}
	
	@Test
	public void testGetAndSetUnit(){
		foodEntry.setUnit(Unit.DROP);
		assertEquals("Unit muss gleich sein", Unit.DROP, foodEntry.getUnit());
	}
}
