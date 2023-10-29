package view.printDialog;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class PrintDialogController {

    @FXML
    private Pane printDialog;

    @FXML
    private CheckBox allSites;

    @FXML
    private CheckBox selectedSites;

    @FXML
    private Button printButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Text copysButton;

    @FXML
    private CheckBox blackWhiteButton;

    @FXML
    private CheckBox colorButton;

    @FXML
    private ComboBox<?> selectPrinterChelection;

    @FXML
    private CheckBox DuplexButton;

    @FXML
    void Print(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void setAllSites(ActionEvent event) {

    }

    @FXML
    void setBlackWhite(ActionEvent event) {

    }

    @FXML
    void setColor(ActionEvent event) {

    }

    @FXML
    void setCopys(MouseEvent event) {

    }

    @FXML
    void setDuplex(ActionEvent event) {

    }

    @FXML
    void setSelectedPrinter(ActionEvent event) {

    }

    @FXML
    void setSelectedSites(ActionEvent event) {

    }

}
