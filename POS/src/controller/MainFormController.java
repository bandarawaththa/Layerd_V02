package controller;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import startUp.AppInit;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {

    @FXML
    private BorderPane pane;

    @FXML
    private ImageView imgCus;

    @FXML
    private ImageView imgItem;

    @FXML
    private Label lblWelcome;

    @FXML
    private Label lblDis;

    @FXML
    void imgCusMouseClicked(MouseEvent event) {
        try {
            URL url = new File("POS/src/view/CustomerManage.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            AppInit.stage.setScene(scene);
            AppInit.stage.setTitle("Customer Manage");
            AppInit.stage.show();
        } catch (MalformedURLException e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        } catch (IOException e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
    }

    @FXML
    void imgItemMouseClicked(MouseEvent event) {
        try {
            URL url = new File("POS/src/view/ItemManage.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            AppInit.stage.setScene(scene);
            AppInit.stage.setTitle("Item Manage");
            AppInit.stage.show();
        } catch (MalformedURLException e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        } catch (IOException e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
    }

    @FXML
    void mouseEnter(MouseEvent event) {
        if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();

            switch(icon.getId()){
                case "imgCus":
                    lblWelcome.setText("Manage Customers");
                    lblDis.setText("Click to add, edit, delete, search or view customers");
                    break;
                case "imgItem":
                    lblWelcome.setText("Manage Items");
                    lblDis.setText("Click to add, edit, delete, search or view items");
                    break;
            }

            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }
    }

    @FXML
    void mouseExit(MouseEvent event) {
        if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
            Reflection shadow = new Reflection();
            icon.setEffect(shadow);

            lblWelcome.setText("Welcome");
            lblDis.setText("Please select one of above main operations to proceed");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), pane);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }
}