package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerManageController implements Initializable {

    @FXML
    private BorderPane paneCusManage;

    @FXML
    private JFXButton btnNewCus;

    @FXML
    private JFXTextField txtCusID;

    @FXML
    private TextField txtSearch;

    @FXML
    private JFXTextField txtCusName;

    @FXML
    private JFXTextField txtCusContact;

    @FXML
    private JFXTextField txtCusAddress;

    @FXML
    private JFXButton btnDianamic;

    @FXML
    void btnDianamicAction(ActionEvent event) {

    }

    @FXML
    void btnNewCusAction(ActionEvent event) {

    }

    @FXML
    void txtCusAddressAction(ActionEvent event) {

    }

    @FXML
    void txtCusContactAction(ActionEvent event) {

    }

    @FXML
    void txtCusIDAction(ActionEvent event) {

    }

    @FXML
    void txtCusNameAction(ActionEvent event) {

    }

    @FXML
    void txtSearchAction(ActionEvent event) {

    }

    @FXML
    void txtSearchKeyPressed(KeyEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), paneCusManage);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }
}