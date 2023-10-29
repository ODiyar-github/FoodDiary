package view.mainWindow;

import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import control.DiaryController;
import exceptions.NoCurrentDiaryException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import view.ViewMain;

public class InnerWindowMonthController {

    @FXML
    private AnchorPane hauptfenster;

    @FXML
    private TabPane tabFenster;

    @FXML
    private Tab tabTagebuch;

    @FXML
    private AnchorPane tagebuchFenster;

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
    private MenuItem januar;

    @FXML
    private MenuItem februar;

    @FXML
    private MenuItem märz;

    @FXML
    private MenuItem april;

    @FXML
    private MenuItem mai;

    @FXML
    private MenuItem juni;

    @FXML
    private MenuItem juli;

    @FXML
    private MenuItem august;

    @FXML
    private MenuItem september;

    @FXML
    private MenuItem november;

    @FXML
    private MenuItem dezember;

    @FXML
    private MenuItem jahresansicht;

    @FXML
    private MenuButton jahr;

    @FXML
    private MenuItem j2017;

    @FXML
    private MenuItem j2018;

    @FXML
    private ScrollPane scrollTagebuch;

    @FXML
    private TitledPane tag1;

    @FXML
    private TableView<?> tagebuchTabelle;

    @FXML
    private TableColumn<?, ?> zeit;

    @FXML
    private TableColumn<?, ?> eingenommen;

    @FXML
    private TableColumn<?, ?> lebensmittel;

    @FXML
    private TableColumn<?, ?> medikament;

    @FXML
    private TableColumn<?, ?> menge;

    @FXML
    private TableColumn<?, ?> anmerkung;

    @FXML
    private TitledPane tag2;

    @FXML
    private TitledPane tag3;

    @FXML
    private TitledPane tag4;

    @FXML
    private TitledPane tag5;

    @FXML
    private TitledPane tag6;

    @FXML
    private TitledPane tag7;

    @FXML
    private TitledPane tag8;

    @FXML
    private TitledPane tag9;

    @FXML
    private TitledPane tag10;

    @FXML
    private TitledPane tag11;

    @FXML
    private TitledPane tag12;

    @FXML
    private TitledPane tag13;

    @FXML
    private TitledPane tag14;

    @FXML
    private TitledPane tag15;

    @FXML
    private TitledPane tag16;

    @FXML
    private TitledPane tag17;

    @FXML
    private TitledPane tag18;

    @FXML
    private TitledPane tag19;

    @FXML
    private TitledPane tag20;

    @FXML
    private TitledPane tag21;

    @FXML
    private TitledPane tag22;

    @FXML
    private TitledPane tag23;

    @FXML
    private TitledPane tag24;

    @FXML
    private TitledPane tag25;

    @FXML
    private TitledPane tag26;

    @FXML
    private TitledPane tag27;

    @FXML
    private TitledPane tag28;

    @FXML
    private TitledPane tag29;

    @FXML
    private TitledPane tag30;

    @FXML
    private TitledPane tag31;

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
    
    private int selectedMonth;
    LocalDate selectedDate;
	LocalDate currentDate;
	private int currentMonth;
	private int currentDay;
	
	private int selectedDay;
	private int selectedYear;
	
	DiaryController diaryController;
	
	BorderPane root = RootLayoutController.getRootLayout();

	private static int currentTab;
    
    @FXML
    void openApril(ActionEvent event) {
    	selectedMonth = 4;
    	
//    	BorderPane root = ViewMain.getRootLayout();
    	
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
    	
//    	BorderPane root = ViewMain.getRootLayout();
    	
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
    	
//    	BorderPane root = ViewMain.getRootLayout();
    	
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
    	
//    	BorderPane root = ViewMain.getRootLayout();
    	
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
    	
//    	GregorianCalendar now = new GregorianCalendar(); 
//    	now.set(2017, selectedMonth-1, 1);
//    	
//    	InnerWindowMonthController.setDate(now);
//    	
//    	BorderPane root = ViewMain.getRootLayout();
    	
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
    	
//    	BorderPane root = ViewMain.getRootLayout();
    	
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
    	
//    	BorderPane root = ViewMain.getRootLayout();
    	
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
    	
//    	BorderPane root = ViewMain.getRootLayout();
    	
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
    void openNovember(ActionEvent event) {
    	selectedMonth = 11;
    }
    @FXML
    void openMarch(ActionEvent event) {
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
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ViewMain.class.getResource("mainWindow/InnerWindowDay.fxml"));
            AnchorPane tableMonth = (AnchorPane) loader.load();
            
            root.setCenter(tableMonth);
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
//    	try {
//			diaryController.getDiaryEntriesAtDay(date);
//		} catch (NoCurrentDiaryException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
    @FXML
    void abc(MouseEvent event) {
    	currentTab = tabFenster.getSelectionModel().getSelectedIndex();
    }
    
    public static int getCurrentTab(){
		return currentTab;
    	
    }
}