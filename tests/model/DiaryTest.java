package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class DiaryTest {
	private Diary diary;
	
	@Before
    public void setUp() throws Exception {
		diary= new Diary("Thomas");
	}
	
	@Test
	public void testKonstruktor(){
		assertEquals("Name muss Thomas sein.", "Thomas", diary.getName());
		assertEquals("IntoleranceList muss leer sein", new ArrayList<Ingredient>(), diary.getIntolerance());
		assertEquals("DiaryEntrySet muss leer sein", new TreeSet<DiaryEntry>(), diary.getDiaryEntrySet());
	}
	
	@Test
	public void testAddIntolerance(){
		Ingredient ingredient = new Ingredient("Fructose", "Fruchtzucker");
		ArrayList<Ingredient> intolerance = new ArrayList<Ingredient>();
		intolerance.add(ingredient);
		diary.addIntolerance(ingredient);
		assertEquals("Intolerance nicht hinzugefügt", intolerance, diary.getIntolerance());
	}
	
	@Test
	public void testRemoveIntolerance(){
		ArrayList<Ingredient> intolerance = new ArrayList<Ingredient>();
		Ingredient ingredient1 = new Ingredient("Fructose", "Fruchtzucker");
		Ingredient ingredient2 = new Ingredient("Tomaten", "Rot");
		Ingredient ingredient3 = new Ingredient("Paprika", "Gruen");
		intolerance.add(ingredient1);
		intolerance.add(ingredient2);
		intolerance.add(ingredient3);
		intolerance.remove(ingredient2);
		diary.addIntolerance(ingredient1);
		diary.addIntolerance(ingredient2);
		diary.addIntolerance(ingredient3);
		diary.removeIntolerance(ingredient2);
		assertEquals("Intolerance nicht gelöscht", intolerance, diary.getIntolerance());
	}
	
	@Test
	public void testGetAndSetName(){
		diary.setName("Max");
		assertEquals("Name muss Max sein", "Max", diary.getName());
	}
	
	@Test
	public void testGetIntolerance(){
		ArrayList<Ingredient> intolerance = new ArrayList<Ingredient>();
		Ingredient ingredient1 = new Ingredient("Fructose", "Fruchtzucker");
		Ingredient ingredient2 = new Ingredient("Tomaten", "Rot");
		Ingredient ingredient3 = new Ingredient("Paprika", "Gruen");
		intolerance.add(ingredient1);
		intolerance.add(ingredient2);
		intolerance.add(ingredient3);
		diary.addIntolerance(ingredient1);
		diary.addIntolerance(ingredient2);
		diary.addIntolerance(ingredient3);
		assertEquals("Intolerance muss Liste Intolerance aus Methode sein", intolerance, diary.getIntolerance());
	}
}
