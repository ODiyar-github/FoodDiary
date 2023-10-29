/**
 * 
 */
package view.analyze;

import java.time.LocalDateTime;
import java.util.SortedSet;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import model.DiaryEntry;
import support.DiaryEntriesForTableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author sopr099
 *
 */
public class AnalyzeWindowController {

	 	@FXML
	    private TableView<DiaryEntriesForTableView> diaryTable;

	    @FXML
	    private TableColumn<DiaryEntriesForTableView ,LocalDateTime> entryDate;
	    
	    @FXML
	    private TableColumn<DiaryEntriesForTableView, String> foodCol;

	    @FXML
	    private TableColumn<DiaryEntriesForTableView, String> drugCol;

	    @FXML
	    private TableColumn<DiaryEntriesForTableView, String> descriptionCol;
	    
	    
	    public void setGUIElements(SortedSet<DiaryEntry> matchingEntries)
	    {	    		    	
	    	
	    	entryDate.setCellValueFactory(new PropertyValueFactory<>("time"));
	    	foodCol.setCellValueFactory(new PropertyValueFactory<>("foods"));    	
	    	drugCol.setCellValueFactory(new PropertyValueFactory<>("drugs"));    	 	
	    	descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));   
	    	
	    	SortedSet<DiaryEntry> diaryEntries = matchingEntries;
	    	ObservableList<DiaryEntriesForTableView> observableDiaryEntries = DiaryEntriesForTableView.getEntriesForTableView(diaryEntries); 
	    	    	 	
	    	this.diaryTable.setItems(observableDiaryEntries);  	    	
	    	
	    }
}
