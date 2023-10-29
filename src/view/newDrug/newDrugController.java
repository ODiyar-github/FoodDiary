package view.newDrug;

import java.util.ArrayList;

import control.FDController;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Drug;
import model.Food;
import model.Ingredient;

public class newDrugController
{
	FDController fDController;
	
	 @FXML
	 private TextField textFieldName;

	 @FXML
	 private TextArea textAreaSideEffects;

	 @FXML
	 private ListView<Ingredient> listViewIngredients;

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
		 {   if(!textFieldName.toString().isEmpty()) {
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
	 
	 void initialize()
	 {
		 try
		 {
			 ObservableList<Ingredient> ingredientList = (ObservableList<Ingredient>)fDController.getFD().getArchive().getIngredientList();
			 
			 this.listViewIngredients.setItems(ingredientList);
		 }
		 catch(Exception exception)
		 {
			 
		 }
	 }
	 
	 

}
