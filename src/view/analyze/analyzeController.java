/**
 * 
 */
package view.analyze;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import model.Drug;
import model.Food;
import model.Ingredient;
import support.ParameterClassAnalyze;

/**
 * @author sopr099
 *
 */
public class analyzeController {
	
	FDController fdController;
	
	@FXML
	 private CheckBox onlyComplaint;
	 
	 @FXML
	 private ComboBox<Food> foodComboBox;
	 
	 @FXML
	 private ComboBox<Ingredient> ingredientComboBox;
	 
	 @FXML
	 private ComboBox<Drug> drugComboBox;

	 @FXML
	 private DatePicker datepickerFrom;

	 @FXML
	 private DatePicker datepickerTo;
	 
	 @FXML
	 private Button startAnalyse;
	 
	 @FXML
	 void buttonStartAnalyseOnAction(ActionEvent event) 
	 {
		 try
		 {   if(!textFieldName.toString().isEmpty()) {
			 
			 	LocalDate temp = this.datepickerFrom.getValue();
			 	Date from = java.sql.Date.valueOf(temp);
			 	
			 	temp = this.datepickerTo.getValue();
			 	Date to = java.sql.Date.valueOf(temp);
			 	
			 	Boolean complaint = onlyComplaint.isSelected();
			 	
			 	ArrayList<Food> foodList = foodComboBox.
			 	
			 	
		 
				 String drugName = this.textFieldName.toString();
				 ArrayList<Ingredient> seletecedIngredients = (ArrayList<Ingredient>)this.listViewIngredients.getSelectionModel().getSelectedItems();
				 String sideEffects = this.textAreaSideEffects.toString();
				 
				 Drug drug = new Drug(drugName, sideEffects);
				 fDController.getDrugController().addEntry(drug, seletecedIngredients);
				 

	 		 }
	
			 
		 }
		 catch(Exception exception)
		 {
			 
		 }
		 
	
}
