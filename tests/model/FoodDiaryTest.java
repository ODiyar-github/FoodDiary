package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class FoodDiaryTest {
	private FoodDiary foodDiary;
	private Archive archive;
	
	@Before
    public void setUp() throws Exception {
		archive = new Archive();
		foodDiary= new FoodDiary(archive);
	}
	
	@Test
	public void testKonstruktor(){
		assertEquals("DiaryList muss leer sein", new ArrayList<Diary>(), foodDiary.getDiaries());
		assertEquals("Archive muss gleich sein", archive, foodDiary.getArchive());
	}
	
	@Test
	public void testAddDiary(){
		ArrayList<Diary> diaryList=new ArrayList<Diary>();
		Diary diary1 = new Diary("Thomas");
		Diary diary2 = new Diary("Jonas");
		Diary diary3 = new Diary("Tim");
		diaryList.add(diary1);
		diaryList.add(diary2);
		diaryList.add(diary3);
		foodDiary.addDiary(diary1);
		foodDiary.addDiary(diary2);
		foodDiary.addDiary(diary3);
		assertEquals("DiaryList muss eingefügte tagebücher enthalten", diaryList, foodDiary.getDiaries());
	}
	
	@Test
	public void testRemoveDiary(){
		ArrayList<Diary> diaryList=new ArrayList<Diary>();
		Diary diary1 = new Diary("Thomas");
		Diary diary2 = new Diary("Jonas");
		Diary diary3 = new Diary("Tim");
		diaryList.add(diary1);
		diaryList.add(diary3);
		foodDiary.addDiary(diary1);
		foodDiary.addDiary(diary2);
		foodDiary.addDiary(diary3);
		foodDiary.removeDiary(diary2);
		assertEquals("DiaryList darf entferntes Tagebuch nicht mehr enthalten", diaryList, foodDiary.getDiaries());
	}
	
	@Test
	public void testGetAndSetBoolean(){
		foodDiary.setBoolean(true);
		assertEquals("Boolean muss true sein", true, foodDiary.getBoolean());
	}
	
	@Test
	public void testGetAndSetCurrentDiaries(){
		Diary diary1 = new Diary("Thomas");
		foodDiary.setCurrentDiary(diary1);
		assertEquals("Diaries m�ssen gleich sein", diary1, foodDiary.getCurrentDiary());
	}
}
