package view.mainWindow;

import java.io.IOException;

import control.FDController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import view.ViewMain;

public class RootLayoutController {

    @FXML
    private static BorderPane rootLayout;

    @FXML
    private MenuBar menuBarTop;

    @FXML
    private Menu dateiButton;

    @FXML
    private MenuItem newDiaryButton;

    @FXML
    private MenuItem saveButton;

    @FXML
    private MenuItem loadButton;

    @FXML
    private MenuItem importButton;

    @FXML
    private MenuItem exportButton;

    @FXML
    private MenuItem printButton;

    @FXML
    private MenuItem closeButton;

    @FXML
    private Menu operationButton;

    @FXML
    private MenuItem analyzeButton;

    @FXML
    private MenuItem compareButton;

    @FXML
    private Menu helpButton;

    @FXML
    private MenuItem manualButton;

    @FXML
    private ToolBar toolbarBottom;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    private Button newEntryButton;

    FDController fdController;
    
    public void setFdController(FDController controller){
    	fdController = controller;
    }

    @FXML
    void analyzeArchives(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(ViewMain.class.getResource("analyze/analyze.fxml"));
    		AnchorPane analyzeWindow;
    		analyzeWindow = (AnchorPane) loader.load();

    		Scene scene = new Scene(analyzeWindow);
    		Stage analyzeStage = new Stage();
    		analyzeStage.setScene(scene);
    		analyzeStage.setTitle("Tagebuch analysieren");
    		analyzeStage.show();
    	} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void closeWindow(ActionEvent event) {
    	Platform.exit();
    }
    
    @FXML
    void createNewDiary(ActionEvent event){
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(ViewMain.class.getResource("newDiary/newDiary.fxml"));
    		Pane dialogWindow;
    		dialogWindow = (Pane) loader.load();

    		Scene scene = new Scene(dialogWindow);
    		Stage dialogStage = new Stage();
    		dialogStage.setScene(scene);
    		dialogStage.setTitle("Neues Tagebuch erstellen");
    		dialogStage.show();
    	} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void saveDiary(ActionEvent event){
    	Stage saveDialog = new Stage();
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Datei speichern");
    	fileChooser.showOpenDialog(saveDialog);
    }
    
    @FXML
    void loadDiary(ActionEvent event){
    	Stage loadDialog = new Stage();
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Datei laden");
    	fileChooser.showOpenDialog(loadDialog);
    }

    @FXML
    void compareDiarys(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(ViewMain.class.getResource("compareWindow/compareDiaries.fxml"));
    		AnchorPane compareWindow;
    		compareWindow = (AnchorPane) loader.load();

    		Scene scene = new Scene(compareWindow);
    		Stage compareStage = new Stage();
    		compareStage.setScene(scene);
    		compareStage.setTitle("Tagebücher vergleichen");
    		compareStage.show();
    	} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void createNewEntry(ActionEvent event) {
    	if(InnerWindowDayController.getCurrentTab() ==0){
    		try {
        		FXMLLoader loader = new FXMLLoader();
        		loader.setLocation(ViewMain.class.getResource("newDiaryEntry/NewDiaryEntry.fxml"));
        		AnchorPane createWindow;
        		createWindow = (AnchorPane) loader.load();

        		Scene scene = new Scene(createWindow);
        		Stage createStage = new Stage();
        		createStage.setScene(scene);
        		createStage.setTitle("Tagebücher vergleichen");
        		createStage.show();
        	} 
    		catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    	if(InnerWindowDayController.getCurrentTab() ==1){
    		try {
        		FXMLLoader loader = new FXMLLoader();
        		loader.setLocation(ViewMain.class.getResource("newFood/newFood.fxml"));
        		AnchorPane createWindow;
        		createWindow = (AnchorPane) loader.load();

        		Scene scene = new Scene(createWindow);
        		Stage createStage = new Stage();
        		createStage.setScene(scene);
        		createStage.setTitle("Tagebücher vergleichen");
        		createStage.show();
        	} 
    		catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    	if(InnerWindowDayController.getCurrentTab() ==2){
    		try {
        		FXMLLoader loader = new FXMLLoader();
        		loader.setLocation(ViewMain.class.getResource("newDrug/newDrug.fxml"));
        		AnchorPane createWindow;
        		createWindow = (AnchorPane) loader.load();

        		Scene scene = new Scene(createWindow);
        		Stage createStage = new Stage();
        		createStage.setScene(scene);
        		createStage.setTitle("Tagebücher vergleichen");
        		createStage.show();
        	} 
    		catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    	if(InnerWindowDayController.getCurrentTab() ==3){
    		try {
        		FXMLLoader loader = new FXMLLoader();
        		loader.setLocation(ViewMain.class.getResource("newIngredient/newIngredient.fxml"));
        		AnchorPane createWindow;
        		createWindow = (AnchorPane) loader.load();

        		Scene scene = new Scene(createWindow);
        		Stage createStage = new Stage();
        		createStage.setScene(scene);
        		createStage.setTitle("Tagebücher vergleichen");
        		createStage.show();
        	} 
    		catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    }

    @FXML
    void deleteEntry(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Löschen?");
    	alert.setHeaderText(null);
    	alert.setContentText("Wollen Sie den Eintrag wirklich löschen");

    	alert.showAndWait();
    }

    @FXML
    void editEntry(ActionEvent event) {
    	// TODO
    }

    @FXML
    void exportArchive(ActionEvent event) {
    	Stage exportDialog = new Stage();
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Archiv exportieren");
    	fileChooser.showOpenDialog(exportDialog);
    }

    @FXML
    void importArchive(ActionEvent event) {
    	Stage importDialog = new Stage();
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Archiv importieren");
    	fileChooser.showOpenDialog(importDialog);
    }

    @FXML
    void openManual(ActionEvent event) {
    	WebView webView = new WebView();
    	WebEngine engine = webView.getEngine();
    	engine.load("https://sopra.cs.tu-dortmund.de/wiki/_media/sopra/17b/gruppe09/projekt1/produktbeschreibung.pdf");
    	
    	Scene manual = new Scene(webView);
    	Stage manualStage = new Stage();
    	manualStage.setScene(manual);
    	manualStage.setTitle("Anleitung");
    	manualStage.show();
    }

    @FXML
    void printDiary(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(ViewMain.class.getResource("printDialog/PrintDialog.fxml"));
    		AnchorPane compareWindow;
    		compareWindow = (AnchorPane) loader.load();

    		Scene scene = new Scene(compareWindow);
    		Stage compareStage = new Stage();
    		compareStage.setScene(scene);
    		compareStage.setTitle("Tagebuch drucken");
    		compareStage.show();
    	} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


	public static  BorderPane getRootLayout() {
		return rootLayout;
	}
}


