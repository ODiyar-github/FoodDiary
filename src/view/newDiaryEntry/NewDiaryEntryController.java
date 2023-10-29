package view.newDiaryEntry;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import control.FDController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import model.DiaryEntry;

public class NewDiaryEntryController {

	FDController fDController;

	ArrayList<DiaryEntry> showOfEntrys = new ArrayList<DiaryEntry>();

	@FXML
	private TextField timeTextbox;

	@FXML
	private TextField foodTextbox;

	@FXML
	private TextField drugTextbox;

	@FXML
	private TextField unit2Textbox;

	@FXML
	private TextField descriptionTextbox;

	@FXML
	private Button saveEntryButton;

	@FXML
	private Button addEntryButton;

	@FXML
	private TextField unit1Textbox;

	@FXML
	private ChoiceBox<?> Unit1ComboBox;

	@FXML
	private ChoiceBox<?> unit2ComboBox;

	@FXML
	private TextField areaTextBox;

    @FXML
    private Spinner<?> unit1;

    @FXML
    private Spinner<?> unit2;

    @FXML
    private Spinner<Integer> hours;

    @FXML
    private Spinner<Integer> minute;
	
	@FXML
	void addEntryHandler(ActionEvent event) {
		
	}

	@FXML
	void saveButtonHandler(ActionEvent event) {

	}

	public void setFDController(FDController fd) {
		this.fDController = fd;
	}

	public void timeCorrector() {

	}
	
	public void unitController(){

	}

}