package control;
import java.util.Date;

import view.ViewAUI;
import java.util.List;

/**
 * 
 * @author sopr099
 * 
 */
public class ViewController {

	private FDController fDController;

	private int currentView;

	private Date currentDate;

	private List<ViewAUI> viewAUIList;

	/**
	 *  
	 */
	public ViewController(FDController fDController) {
		this.fDController = fDController;
	}

	/**
	 * Regt einen Resfreh der View an 
	 */
	void callRefreshView() {

	}


	/**
	 *  Startet einen Wechsel zur Tagesansicht des Tages, der ueber date uebergeben wurde
	 * 
	 * @param date uebergebenes Datum, hier relevant ist der Tag
	 */
	public void toDayView(Date date) {

	}

	/**
	 *  Startet einen Wechsel zur Monatsansicht des Monats, der ueber date uebergeben wurde
	 *  
	 * @param date uebergebenes Datum, hier relevant ist der Monat
	 *
	 */
	public void toMonthView(Date date) {

	}

	/**
	 *  Startet einen Wechsel zur Jahresansicht des Jahres, das ueber date uebergeben wurde
	 *  
	 * @param date uebergebenes Datum, hier relevant ist das Jahr
	 */
	public void toYearView(Date date) {

	}

	/**
	 *  
	 */
	public void addViewAUI(ViewAUI viewAUI) {

	}

	/**
	 * @return the currentDate
	 */
	public Date getCurrentDate() {
		return currentDate;
	}

	/**
	 * @param currentDate the currentDate to set
	 */
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	/**
	 * @return the currentView
	 */
	public int getCurrentView() {
		return currentView;
	}

	/**
	 * @param currentView the currentView to set
	 */
	public void setCurrentView(int currentView) {
		this.currentView = currentView;
	}

	/**
	 * @return the fDController
	 */
	public FDController getfDController() {
		return fDController;
	}

	/**
	 * @param fDController the fDController to set
	 */
	public void setfDController(FDController fDController) {
		this.fDController = fDController;
	}

	/**
	 * @return the viewAUI
	 */
	public List<ViewAUI> getViewAUIList() {
		return viewAUIList;
	}


}
