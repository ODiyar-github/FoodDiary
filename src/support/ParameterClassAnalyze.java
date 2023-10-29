package support;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import model.Drug;
import model.Food;
import model.Ingredient;

/**
 * Parameterklasse fuer die Methoden analyze und compare im DiaryController
 * @author sopr096
 */
public class ParameterClassAnalyze {
	
	/**
	 * Datum, ab dem analysiert werden soll
	 */
	private Date from;
	
	/**
	 * Datum, bis zu dem analysiert werden soll
	 */
	private Date to;
	
	/**
	 * Sollen nur Tage mit Beschwerden analysiert werden?
	 */
	private boolean complaint;
	
	/**
	 * Die Lebensmittel, nach denen gefiltert werden soll.
	 */
	private List<Food> foodList;
	
	/**
	 * Die Medikamente, nach denen gefiltert werden soll. 
	 */
	private List<Drug> drugList;
	
	/**
	 * Die Inhaltssstoffe, nach denen gefiltert werden soll.
	 */
	private List<Ingredient> ingredientList;
	
	/**
	 * Erzeug ein neue Parameterobjekt.
	 * Die Parameter müssen danach noch mit den set-Methoden gesetzt werden.
	 */
	public ParameterClassAnalyze(){
		from = new Date();
		to = new Date();
		complaint = false;
		foodList = new ArrayList<Food>();
		drugList = new ArrayList<Drug>();
		ingredientList = new ArrayList<Ingredient>();
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public boolean isComplaint() {
		return complaint;
	}

	public void setComplaint(boolean complaint) {
		this.complaint = complaint;
	}

	public List<Food> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<Food> foodList) {
		this.foodList = foodList;
	}

	public List<Drug> getDrugList() {
		return drugList;
	}

	public void setDrugList(List<Drug> drugList) {
		this.drugList = drugList;
	}

	public List<Ingredient> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(List<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}
}
