package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import startUp.AppInit;
import tm.CustomerTM;
import tm.ItemTM;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ItemManageController implements Initializable {

    @FXML
    private BorderPane pane;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnNew;

    @FXML
    private JFXTextField txtID;

    @FXML
    private TextField txtSearch;

    @FXML
    private JFXTextField txtDes;

    @FXML
    private JFXTextField txQTY;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    private JFXButton btnSave;

    @FXML
    private TableView<ItemTM> tbl;

    @FXML
    void btnBackAction(ActionEvent event) {
        try {
            URL url = new File("POS/src/view/MainForm.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            AppInit.stage.setScene(scene);
            AppInit.stage.setTitle("Thoga Kade");
            AppInit.stage.show();
        } catch (MalformedURLException e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        } catch (IOException e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
    }

    @FXML
    void btnNewAction(ActionEvent event) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ThogaKade", "root", "");
            PreparedStatement ptm = con.prepareStatement("INSERT INTO Item VALUES(?,?,?,?)");
            ptm.setObject(1, txtID.getText());
            ptm.setObject(2, txtDes.getText());
            ptm.setObject(3, Integer.parseInt(txtPrice.getText()));
            ptm.setObject(4, Double.parseDouble(txQTY.getText()));
            boolean isSaved = ptm.executeUpdate() > 0;
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "Save SUCCESS", ButtonType.CLOSE).show();
            }
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
    }

    @FXML
    void btnSaveAction(ActionEvent event) {

    }

    @FXML
    void tblMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtDesAction(ActionEvent event) {

    }

    @FXML
    void txtIDAction(ActionEvent event) {

    }

    @FXML
    void txtPriceAction(ActionEvent event) {

    }

    @FXML
    void txtQTYAction(ActionEvent event) {

    }

    @FXML
    void txtSearchAction(ActionEvent event) {

    }

    @FXML
    void txtSearchKeyPressed(KeyEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), pane);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();

        tbl.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("code"));
        tbl.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tbl.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tbl.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("price"));
        tbl.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("btn"));

        loadAllItem();

        tbl.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            ItemTM tm = newValue;
        });
    }

    private void loadAllItem(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ThogaKade", "root", "");
            PreparedStatement ptm = con.prepareStatement("SELECT * FROM Item");
            ResultSet rst = ptm.executeQuery();
            ObservableList<ItemTM> list = FXCollections.observableArrayList();
            while (rst.next()){
                list.add(new ItemTM(rst.getString("code"), rst.getString("description"), rst.getInt("qtyOnHand"), rst.getDouble("unitPrice"), new Button("Delete")));
            }
            tbl.setItems(list);
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
    }
}