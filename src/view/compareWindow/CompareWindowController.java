package view.compareWindow;

import java.util.SortedSet;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DiaryEntry;
import support.DiaryEntriesForTableView;
import support.SetTupel;

public class CompareWindowController {	


    @FXML
    private Label nameDiary1;
    @FXML
    private Label nameDiary2;   	
	@FXML
    private TableView<DiaryEntriesForTableView> tableViewDiary1;
    @FXML
    private TableColumn<DiaryEntriesForTableView, String> colTime1;
    @FXML
    private TableColumn<DiaryEntriesForTableView, String> colFood1;
    @FXML
    private TableColumn<DiaryEntriesForTableView, String> colDrug1;
    @FXML
    private TableColumn<DiaryEntriesForTableView, String> colDescription1;
    @FXML
    private TableView<DiaryEntriesForTableView> tableViewDiary2;
    @FXML
    private TableColumn<DiaryEntriesForTableView, String> colTime2;
    @FXML
    private TableColumn<DiaryEntriesForTableView, String> colFood2;
    @FXML
    private TableColumn<DiaryEntriesForTableView, String> colDrug2;
    @FXML
    private TableColumn<DiaryEntriesForTableView, String> colDescription2; 
      
    public void setGUIElements(String name1, String name2, SetTupel settupel)
    {
    	//this.nameDiary1.setText(name1);
    	//this.nameDiary2.setText(name2);
    	
    	colTime1.setCellValueFactory(new PropertyValueFactory<>("time"));
    	colFood1.setCellValueFactory(new PropertyValueFactory<>("foods"));    	
    	colDrug1.setCellValueFactory(new PropertyValueFactory<>("drugs"));    	 	
    	colDescription1.setCellValueFactory(new PropertyValueFactory<>("description"));   
    	
    	SortedSet<DiaryEntry> diaryEntries1 = settupel.getFirstTupel();   		
    	ObservableList<DiaryEntriesForTableView> observableDiaryEntries1 = DiaryEntriesForTableView.getEntriesForTableView(diaryEntries1); 
    	    	 	
    	this.tableViewDiary1.setItems(observableDiaryEntries1);
    	
    	colTime2.setCellValueFactory(new PropertyValueFactory<>("time"));
    	colFood2.setCellValueFactory(new PropertyValueFactory<>("foods"));    	
    	colDrug2.setCellValueFactory(new PropertyValueFactory<>("drugs"));    	 	
    	colDescription2.setCellValueFactory(new PropertyValueFactory<>("description"));   
    	
    	SortedSet<DiaryEntry> diaryEntries2 = settupel.getSecondTupel();   		
    	ObservableList<DiaryEntriesForTableView> observableDiaryEntries2 = DiaryEntriesForTableView.getEntriesForTableView(diaryEntries2); 
 	
    	this.tableViewDiary2.setItems(observableDiaryEntries2); 	
    }

}
