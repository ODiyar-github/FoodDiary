package view.newDiary;

import java.io.IOException;

import control.FDController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Diary;
import view.ViewMain;
import view.mainWindow.RootLayoutController;


public class newDiaryController 
{
	FDController fDController;
	
	@FXML
    private TextField textFieldName;

    @FXML
    private Button buttonGenerate;
    
    
    public void setFDController(FDController fDController)
    {
    	this.fDController = fDController;
    }
    
    @FXML
    void buttonGenerateOnAction(ActionEvent event)
    {
    	try
    	{        		
    		String diaryName = this.textFieldName.getText().toString();
    		Diary diary = new Diary(diaryName);
    		this.fDController.getFD().addDiary(diary);
    		this.fDController.getFD().setCurrentDiary(diary);

    		this.fDController.getIOController().save();
    		
    		final Node source = (Node) event.getSource();
    		final Stage stage = (Stage) source.getScene().getWindow();
    		stage.close();
    		try {
    			FXMLLoader loader = new FXMLLoader();
    			loader.setLocation(ViewMain.class.getResource("mainWindow/RootLayout.fxml"));
    			Pane dialogWindow;
    			dialogWindow = (Pane) loader.load();
    			Scene scene = new Scene(dialogWindow);
    			Stage dialogStage = new Stage();
    			dialogStage.setScene(scene);
    			dialogStage.setTitle("Ernährungstagebuch");
    			dialogStage.show();
    			
    			RootLayoutController controller = (RootLayoutController) loader.getController();
    			controller.setFdController(fDController);

    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}		

    	}
    	catch(Exception e)
    	{
    		
    	}
    }
    
}
