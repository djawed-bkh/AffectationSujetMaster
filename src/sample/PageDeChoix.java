package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;

public class PageDeChoix {

    @FXML
    private Button Suivant;

    @FXML
    private TableColumn<?, ?> EncadreurSujet;

    @FXML
    private TableColumn<?, ?> EnonceSujet;

    @FXML
    private TableColumn<?, ?> NumeroSujet;

    @FXML
    void AffecterSujet(ActionEvent event) throws IOException {

        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/sample/ConfirmationChoix.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Employes");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
