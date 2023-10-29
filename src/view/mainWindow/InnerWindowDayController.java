package view.mainWindow;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;

import control.DiaryController;
import control.FDController;
import exceptions.NoCurrentDiaryException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import model.DiaryEntry;
import model.DrugEntry;
import model.FoodEntry;
import view.ViewMain;

public class InnerWindowDayController {
	
	LocalDate selectedDate;
	LocalDate currentDate;
	private int currentMonth;
	private int currentDay;
	
	private int selectedMonth;
	private int selectedDay;
	private int selectedYear;
	
	DiaryController diaryController;
	
	BorderPane root = RootLayoutController.getRootLayout();

	private static int currentTab;
	
    @FXML
    private AnchorPane dayView;

    @FXML
    private TabPane tabFenster;

    @FXML
    private Tab tabTagebuch;

    @FXML
    private ToolBar wlTagebuch;

    @FXML
    private MenuButton ansichtTagebuch;

    @FXML
    private MenuItem tagesansicht;

    @FXML
    private DatePicker datePicker;

    @FXML
    private MenuItem monatsansicht;

    @FXML
    private MenuButton monat;

    @FXML
    private MenuItem january;

    @FXML
    private MenuItem february;

    @FXML
    private MenuItem march;

    @FXML
    private MenuItem april;

    @FXML
    private MenuItem may;

    @FXML
    private MenuItem june;

    @FXML
    private MenuItem july;

    @FXML
    private MenuItem august;

    @FXML
    private MenuItem september;

    @FXML
    private MenuItem october;

    @FXML
    private MenuItem november;

    @FXML
    private MenuItem december;

    @FXML
    private MenuItem jahresansicht;

    @FXML
    private MenuButton jahr;

    @FXML
    private MenuItem j2017;

    @FXML
    private MenuItem j2018;

    @FXML
    private AnchorPane diaryDayView;

    @FXML
    private TableView<DiaryEntry> diaryTable;

    @FXML
    private TableColumn<?, ?> zeit;

    @FXML
    private TableColumn<?, ?> eingenommen;

    @FXML
    private TableColumn<FoodEntry, String> lebensmittel;

    @FXML
    private TableColumn<DrugEntry, String> medikament;

    @FXML
    private TableColumn<?, ?> menge;

    @FXML
    private TableColumn<Text, String> anmerkung;

    @FXML
    private Tab tabLebensmittel;

    @FXML
    private AnchorPane lebensmittelFenster;

    @FXML
    private ToolBar wlLebensmittel;

    @FXML
    private MenuButton ansichtLebensmittel;

    @FXML
    private MenuItem alleLebensmittel;

    @FXML
    private MenuItem favoritenLebensmittel;

    @FXML
    private TableView<?> lebensmittelTabelle;

    @FXML
    private TableColumn<?, ?> lebensmittelName;

    @FXML
    private TableColumn<?, ?> kalorien;

    @FXML
    private TableColumn<?, ?> kohlenhydrate;

    @FXML
    private TableColumn<?, ?> eiweiss;

    @FXML
    private TableColumn<?, ?> fett;

    @FXML
    private Tab tabMedikamente;

    @FXML
    private AnchorPane medikamenteFenster;

    @FXML
    private ToolBar wlMedikamente;

    @FXML
    private MenuButton ansichtMedikamente;

    @FXML
    private MenuItem alleMedikamente;

    @FXML
    private MenuItem favoritenMedikamente;

    @FXML
    private TableView<?> medikamenteTabelle;

    @FXML
    private TableColumn<?, ?> medikamentName;

    @FXML
    private TableColumn<?, ?> wirkstoff;

    @FXML
    private TableColumn<?, ?> nebenwirkung;

    @FXML
    private Tab tabInhaltsstoffe;

    @FXML
    private AnchorPane inhaltsstoffeFenster;

    @FXML
    private ToolBar wlInhaltsstoffe;

    @FXML
    private MenuButton ansichtInhaltsstoffe;

    @FXML
    private MenuItem alleInhaltsstoffe;

    @FXML
    private MenuItem favoritenInhaltsstoffe;

    @FXML
    private TableView<?> inhaltsstoffeTabelle;

    @FXML
    private TableColumn<?, ?> inhaltsstoffName;

    @FXML
    private TableColumn<?, ?> gefahrstoff;

    @FXML
    private TableColumn<?, ?> inhaltstoffMedikament;

    @FXML
    private TableColumn<?, ?> inhaltstoffLebensmittel;

    private ObservableList<?> diaryTableItems;

    @FXML
    void initialize(){
    	currentDate = LocalDate.now();
    	selectedDate = currentDate;
    	
    	initTableDayView();
    	
    	FDController fdController = new FDController();
    	diaryController = fdController.getDiaryController();
    }
    
    private void initTableDayView() {
//		diaryTableItems = FXCollections.observableArrayList(); // Überwachungsinstanz der Tabelleneinträge
//		diaryTable.setItems(diaryTableItems);
//		diaryTable.setPlaceholder(new Text("Keine Einträge vorhanden."));
//		diaryTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
    
    @FXML
    void open2017(ActionEvent event) {
    	selectedYear = 2017;
    	
    	try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ViewMain.class.getResource("mainWindow/InnerWindowYear.fxml"));
            AnchorPane tableYear = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            root.setCenter(tableYear);
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    }

    @FXML
    void openApril(ActionEvent event) {
    	selectedMonth = 4;
    	
    	try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ViewMain.class.getResource("mainWindow/InnerWindowMonth.fxml"));
            AnchorPane tableMonth = (AnchorPane) loader.load();
            
            root.setCenter(tableMonth);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openAugust(ActionEvent event) {
    	selectedMonth = 8;
    	
    	
    	try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ViewMain.class.getResource("mainWindow/InnerWindowMonth.fxml"));
            AnchorPane tableMonth = (AnchorPane) loader.load();
            
            root.setCenter(tableMonth);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openDecember(ActionEvent event) {
    	selectedMonth = 12;
    	
    	
    	try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ViewMain.class.getResource("mainWindow/InnerWindowMonth.fxml"));
            AnchorPane tableMonth = (AnchorPane) loader.load();
            
            root.setCenter(tableMonth);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openFebruary(ActionEvent event) {
    	selectedMonth = 2;
//    	Calendar date = Calendar.getInstance();
//    	System.out.println(date.toString());
    	
    	GregorianCalendar now = new GregorianCalendar(); 
    	now.set(2017, selectedMonth-1, 1);
    	
    	
//    	DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
//    	System.out.println(df.format(now.getTime()));
    
    	
    	try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ViewMain.class.getResource("mainWindow/InnerWindowMonth.fxml"));
            AnchorPane tableMonth = (AnchorPane) loader.load();
            
            root.setCenter(tableMonth);
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    }

    @FXML
    void openJanuary(ActionEvent event) {
    	selectedMonth = 1;
    	
    	try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ViewMain.class.getResource("mainWindow/InnerWindowMonth.fxml"));
            AnchorPane tableMonth = (AnchorPane) loader.load();
            
            root.setCenter(tableMonth);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openJuly(ActionEvent event) {
    	selectedMonth = 7;
    	
    	try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ViewMain.class.getResource("mainWindow/InnerWindowMonth.fxml"));
            AnchorPane tableMonth = (AnchorPane) loader.load();
            
            root.setCenter(tableMonth);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openJune(ActionEvent event) {
    	selectedMonth = 6;
    	
    	try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ViewMain.class.getResource("mainWindow/InnerWindowMonth.fxml"));
            AnchorPane tableMonth = (AnchorPane) loader.load();
            
            root.setCenter(tableMonth);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openMay(ActionEvent event) {
    	selectedMonth = 5;
    	
    	try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ViewMain.class.getResource("mainWindow/InnerWindowMonth.fxml"));
            AnchorPane tableMonth = (AnchorPane) loader.load();
            
            root.setCenter(tableMonth);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void openOctober(ActionEvent event) {
    	selectedMonth = 10;
    	
    	try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ViewMain.class.getResource("mainWindow/InnerWindowMonth.fxml"));
            AnchorPane tableMonth = (AnchorPane) loader.load();
            
            root.setCenter(tableMonth);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void openMarch(ActionEvent event) {
    	selectedMonth = 3;
    	
    	try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ViewMain.class.getResource("mainWindow/InnerWindowMonth.fxml"));
            AnchorPane tableMonth = (AnchorPane) loader.load();
            
            root.setCenter(tableMonth);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openNovember(ActionEvent event) {
    	selectedMonth = 11;
    }

    @FXML
    void openSeptember(ActionEvent event) {
    	selectedMonth = 9;
    	
    }
    

    @FXML
    void openDay(ActionEvent event) {
    	selectedDate = (LocalDate) datePicker.getValue();
    	Date date = Date.from(selectedDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    	
    	try {
			diaryController.getDiaryEntriesAtDay(date);
		} catch (NoCurrentDiaryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


    @FXML
    void abc(MouseEvent event) {
    	currentTab = tabFenster.getSelectionModel().getSelectedIndex();
    }
    
    public static int getCurrentTab(){
		return currentTab;
    	
    }
}
