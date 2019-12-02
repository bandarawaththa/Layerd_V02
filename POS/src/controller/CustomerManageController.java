package controller;

import bo.BOFactory;
import bo.BOTypes;
import bo.custom.CustomerBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDTO;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class CustomerManageController implements Initializable {
    private CustomerBO customerBO = BOFactory.getInstance().getBO(BOTypes.CUSTOMER);

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
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtSalary;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXButton btnSave;

    @FXML
    private TableView<CustomerTM> tbl;

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
        btnSave.setText("Save");
        clear();
    }

    @FXML
    void btnSaveAction(ActionEvent event) {
        if (btnSave.getText().equalsIgnoreCase("Save")){
            try {
                CustomerDTO customer = new CustomerDTO();
                customer.setId(txtID.getText());
                customer.setName(txtName.getText());
                customer.setAddress(txtAddress.getText());
                customer.setSalary(Double.parseDouble(txtSalary.getText()));
                boolean isSaved = customerBO.save(customer);
                if (isSaved){
                    new Alert(Alert.AlertType.CONFIRMATION, "Save SUCCESS", ButtonType.CLOSE).show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
            }
        } else {
            try {
                CustomerDTO customer = new CustomerDTO();
                customer.setId(txtID.getText());
                customer.setName(txtName.getText());
                customer.setAddress(txtAddress.getText());
                customer.setSalary(Double.parseDouble(txtSalary.getText()));
                boolean isUpdated = customerBO.update(customer);
                if (isUpdated){
                    new Alert(Alert.AlertType.CONFIRMATION, "Update SUCCESS", ButtonType.CLOSE).show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
            }
        }
        loadAllCustomers();
    }

    @FXML
    void tblMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtAddressAction(ActionEvent event) {

    }

    @FXML
    void txtIDAction(ActionEvent event) {
        txtName.requestFocus();
    }

    @FXML
    void txtNameAction(ActionEvent event) {
        txtSalary.requestFocus();
    }

    @FXML
    void txtSalaryAction(ActionEvent event) {
        txtAddress.requestFocus();
    }

    @FXML
    void txtSearchAction(ActionEvent event) {
        txtID.requestFocus();
    }

    @FXML
    void txtSearchKeyPressed(KeyEvent event) {
        try {
            ArrayList<CustomerDTO> allCustomers = customerBO.searchAll("%" + txtSearch.getText() + "%");
            if (null != allCustomers){
                ObservableList<CustomerTM> list = FXCollections.observableArrayList();
                for (CustomerDTO cus :
                        allCustomers) {
                    Button button = new Button("Delete");
                    list.add(new CustomerTM(
                            cus.getId(),
                            cus.getName(),
                            cus.getAddress(),
                            cus.getSalary(),
                            button
                    ));
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            for (CustomerDTO dto:
                                    allCustomers) {
                                if (dto.getId().equals(cus.getId())){
                                    deleteCus(cus.getId());
                                }
                            }
                        }
                    });
                }
                tbl.setItems(list);
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), pane);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();

        tbl.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tbl.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tbl.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tbl.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("salary"));
        tbl.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("btn"));

        loadAllCustomers();

        tbl.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (null != newValue){
                loadSpecificData(newValue);
            }
        });
    }

    private void loadSpecificData (CustomerTM tm){
        btnSave.setText("Update");
        txtID.setText(tm.getId());
        txtName.setText(tm.getName());
        txtAddress.setText(tm.getAddress());
        txtSalary.setText(Double.toString(tm.getSalary()));
    }

    private void loadAllCustomers(){
        tbl.getItems().clear();
        try{
            ArrayList<CustomerDTO> allCustomers = customerBO.getAll();
            ObservableList<CustomerTM> list = FXCollections.observableArrayList();
            for (CustomerDTO cus :
                    allCustomers) {
                Button button = new Button("Delete");
                list.add(new CustomerTM(
                        cus.getId(),
                        cus.getName(),
                        cus.getAddress(),
                        cus.getSalary(),
                        button
                ));
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        for (CustomerDTO dto:
                             allCustomers) {
                            if (dto.getId().equals(cus.getId())){
                                deleteCus(cus.getId());
                            }
                        }
                    }
                });
            }
            tbl.setItems(list);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
    }

    private void clear(){
        txtID.clear();
        txtName.clear();
        txtSalary.clear();
        txtAddress.clear();
    }

    private void deleteCus(String id) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Are u shure ?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get() == ButtonType.YES){
            boolean isDeleted = false;
            try {
                isDeleted = customerBO.delete(id);
            } catch (SQLException e) {
                new Alert(Alert.AlertType.INFORMATION, e.getMessage(), ButtonType.CLOSE).show();
            }
            if (isDeleted) {
                loadAllCustomers();
                new Alert(Alert.AlertType.CONFIRMATION, "delete SUCCESS", ButtonType.CLOSE).show();
            }
        }
    }
}