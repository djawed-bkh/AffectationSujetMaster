package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private TextField password;

    @FXML
    private TextField Username;

    @FXML
    private Button Login;

    @FXML
    void Connexion(ActionEvent event) {
        /*
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/sample/PageDeChoix.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Employes");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();*/
    }



}

