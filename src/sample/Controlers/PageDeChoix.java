package sample.Controlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private TableView<?> Tableau;

    @FXML
    void AffecterSujet(ActionEvent event) {

    }


}
