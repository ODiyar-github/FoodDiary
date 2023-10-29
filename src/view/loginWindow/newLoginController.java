package view.loginWindow;

import java.io.*;
import control.FDController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import view.loadDiary.*;
import view.mainWindow.InnerWindowDayController;
import view.mainWindow.RootLayoutController;
import model.Archive;
import model.Diary;
import model.FoodDiary;
import view.ViewMain;
import view.newDiary.newDiaryController;


public class newLoginController {

	private FDController fDController;

	private String diaryName;

	@FXML
	private MenuItem newDiaryMenu;

	@FXML
	private MenuItem loadDiaryMenu;

	@FXML
	private MenuItem exitMenu;

	@FXML
	private Menu instruction;

	@FXML
	private Label labelMain;

	@FXML
	private Button newDiaryButton;

	@FXML
	private Button loadDiaryButton;

	@FXML
	private CheckBox checkbox;

    @FXML
    void checkboxHandler(MouseEvent event) {
    	if(checkbox.isSelected()){
    		fDController.getFD().setBoolean(true);
    		
    	}
    	else{
    		fDController.getFD().setBoolean(false);
    	}
    }

	@FXML
	void exitMenuHandler(ActionEvent event) {
		Platform.exit();
	}

	@FXML
	void instructionHandler(ActionEvent event) {
		//Spaeter hinzufuegen
	}

	@FXML
	void loadDiaryHandler(ActionEvent event) {
		if(checkbox.isSelected()){
			mainWindowStart(event);
		}else{
			loadDiary();
		}
		
	}
	

	@FXML
	void loadDiaryMenuHandler(ActionEvent event) {
		
		if(checkbox.isSelected()){
			mainWindowStart(event);
		}else{
			loadDiary();
		}
	}

	@FXML
	void newDiaryHandler(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ViewMain.class.getResource("newDiary/newDiary.fxml"));
			Pane dialogWindow;
			dialogWindow = (Pane) loader.load();

			final Scene SCENE = new Scene(dialogWindow);
			Stage dialogStage = new Stage();
			dialogStage.setScene(SCENE);
			dialogStage.setTitle("Neues Tagebuch erstellen");
			dialogStage.setResizable(false);
			dialogStage.show();

			newDiaryController controller = (newDiaryController) loader.getController();
			controller.setFDController(fDController);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void newDiaryMenuHandler(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ViewMain.class.getResource("newDiary/newDiary.fxml"));
			Pane dialogWindow;
			dialogWindow = (Pane) loader.load();

			final Scene SCENE = new Scene(dialogWindow);
			Stage dialogStage = new Stage();
			dialogStage.setScene(SCENE);
			dialogStage.setTitle("Neues Tagebuch erstellen");
			dialogStage.setResizable(false);
			dialogStage.show();

			newDiaryController controller = (newDiaryController) loader.getController();
			controller.setFDController(fDController);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@FXML
	void initialize() {
		try {
			fDController = new FDController();
			fDController.getIOController().load();
			if(fDController.getFD().getBoolean()){
				checkbox.setSelected(true);
			}
			else{
				checkbox.setSelected(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public void loadDiary(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ViewMain.class.getResource("loadDiary/loadDiary.fxml"));
			Pane dialogWindow;
			dialogWindow = (Pane) loader.load();

			final Scene SCENE = new Scene(dialogWindow);
			Stage dialogStage = new Stage();
			dialogStage.setScene(SCENE);
			dialogStage.setTitle("Neues Tagebuch erstellen");
			dialogStage.setResizable(false);
			dialogStage.show();

			loadDiaryController controller = (loadDiaryController) loader.getController();
			controller.setFDController(fDController);
			controller.fillListView();			
						
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void mainWindowStart(ActionEvent event) {

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
	
	
	
	
	
}
