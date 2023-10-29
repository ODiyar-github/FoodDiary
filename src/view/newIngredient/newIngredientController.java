package view.newIngredient;

import java.util.ArrayList;
import java.util.List;

import control.FDController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Drug;
import model.Food;
import model.Ingredient;

public class newIngredientController
{
	FDController fDController;
	
	@FXML
    private TextField textFieldName;

    @FXML
    private CheckBox checkBoxIntolerance;

    @FXML
    private Button buttonGenerate;

    @FXML
    private ListView<Drug> listViewDrugs;

    @FXML
    private ListView<Food> listViewFoods;

    @FXML
    private TextArea textAreaDescription;    
    
    @SuppressWarnings("unchecked")
	@FXML
    void buttonGenerateOnAction(ActionEvent event) 
    {
    	try
    	{
    		String ingredientName = this.textFieldName.toString();
    		Boolean isIntolerance = this.checkBoxIntolerance.isSelected();   	
			List<Drug> seletecedDrugs = (List<Drug>)this.listViewDrugs.getSelectionModel().getSelectedItems();
    		List<Food> seletecedFoods = (List<Food>)this.listViewFoods.getSelectionModel().getSelectedItems();    		
    		
    		String description = this.textAreaDescription.toString();    		
    		Ingredient ingredient = new Ingredient(ingredientName, description);    		
    		
    		fDController.getIngredientController().addEntry(ingredient, seletecedFoods, seletecedDrugs);  	  		   		    		 		   		
    		fDController.getIOController().save();
    		
    		final Node source = (Node) event.getSource();
        	final Stage stage = (Stage) source.getScene().getWindow();
        	stage.close();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public void setFDController(FDController fDController)
    {
    	this.fDController = fDController;
    }
    
    public void fillListViews()
    {
    	try
    	{    		
    		ObservableList<Drug> drugList = javafx.collections.FXCollections.observableArrayList(fDController.getFD().getArchive().getDrugList());
    		ObservableList<Food> foodList = javafx.collections.FXCollections.observableArrayList(fDController.getFD().getArchive().getFoodList());
    		
    		this.listViewDrugs.setItems(drugList);    		
    		this.listViewFoods.setItems(foodList);   	
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    void initialize()
    {
    	try
    	{    			
    		
    	}
    	catch(Exception e)
    	{
    		
    	}
    }
	
}
