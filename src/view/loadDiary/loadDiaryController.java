package view.loadDiary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import control.FDController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Diary;
import view.ViewMain;
import view.mainWindow.InnerWindowDayController;
import view.mainWindow.RootLayoutController;
import view.newDiary.newDiaryController;

public class loadDiaryController {
	
	FDController fDController;	
	
    @FXML
    private ListView<String> listView;

    @FXML
    private Button loadButton;

    @FXML
    private Button exitButton;

    @FXML
    void exitHandler(ActionEvent event) {
    	
    	try
    	{
    		final Node source = (Node) event.getSource();
        	final Stage stage = (Stage) source.getScene().getWindow();
        	stage.close();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    @FXML
    void loadHandler(ActionEvent event) {

    	String selectedDiaryName= listView.getSelectionModel().getSelectedItem();    	   
    	ArrayList<Diary> diaryList = (ArrayList<Diary>)fDController.getFD().getDiaries();
    	    	
    	for(Diary diary : diaryList){
    		if(selectedDiaryName.equals(diary.getName())){
    			this.fDController.getFD().setCurrentDiary(diary);
    			break;
    		}
    	}   	   	    	

    	final Node source = (Node) event.getSource();
    	final Stage stage = (Stage) source.getScene().getWindow();
    	stage.close();	   	
    	
    	try 
    	{
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(ViewMain.class.getResource("mainWindow/RootLayout.fxml"));
    		Pane dialogWindow;
    		dialogWindow = (Pane) loader.load();
    		Scene scene = new Scene(dialogWindow);
    		Stage dialogStage = new Stage();
    		dialogStage.setScene(scene);
    		dialogStage.setTitle("Ernährungstagebuch");
    		dialogStage.show();
    		
    		//Hier noch FDController vom MAINVIEW irgedwie setten
    		RootLayoutController controller = (RootLayoutController) loader.getController();   
    		controller.setFdController(fDController);
    		
    	}
    	catch (IOException e) 
    	{    		
    		e.printStackTrace();
    	}    		


    }   
    
    
    public void setFDController(FDController fd){    	

    	this.fDController=fd;    
    	
    }
    
    public void fillListView()
    {
    	ObservableList<Diary> diaryList= FXCollections.observableArrayList(fDController.getFD().getDiaries());  
    	ArrayList<String> nameList=new ArrayList<String>();    
    	

    	diaryList= FXCollections.observableArrayList(fDController.getFD().getDiaries());    	    	
    	nameList=new ArrayList<String>();    	

    	for(Diary diary : diaryList){
    		nameList.add(diary.getName());    
    	}
    	
    	ObservableList<String> diaryNameList= FXCollections.observableArrayList(nameList);
    	this.listView.setItems(diaryNameList);

		listView.refresh();
    }
    
  
	@FXML
    void initialize() {
    	try{    	  	

    		
    	}
    	catch(Exception e){
    		
    	}
    }
}
