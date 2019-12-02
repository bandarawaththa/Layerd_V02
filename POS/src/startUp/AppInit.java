package startUp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AppInit extends Application {
    public static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        try {
            URL url = new File("POS/src/view/MainForm.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Thoga Kade");
            stage = primaryStage;
            primaryStage.show();
        } catch (MalformedURLException e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        } catch (IOException e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
    }
}