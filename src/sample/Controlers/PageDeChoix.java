package sample.Controlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import sample.Classes.Sujet;

import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

public class PageDeChoix implements Initializable {

    @FXML
    private Button Suivant;

    @FXML
    private TableColumn<Sujet, String> EnonceSujet;

    @FXML
    private TableColumn<Sujet, Integer> NumeroSujet;
    @FXML
    private TableColumn<Sujet, Integer> NomEncadreur;

    @FXML
    private TableView<Sujet> Tableau;

    private ObservableList<Sujet> data=FXCollections.observableArrayList();

    @FXML
    void AffecterSujet(ActionEvent event) {}

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        FillingTableView();

        ListnerSelectedRow();



    }
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());            //format date


    public void FillingTableView(){


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/webService", "root", "djawed");


            String sqlQuery = "SELECT Sujet.SujetID,Sujet.Enoncer,Sujet.ProfesseurID,Professeur.Nom from Sujet,Professeur\n" +
                    "where Professeur.ProfesseurID=Sujet.ProfesseurID ";
            ResultSet rs = con.createStatement().executeQuery(sqlQuery);


            String param1, param2;
            int cast1, cast2;
            while (rs.next()) {
                param1 = rs.getString(1);
                cast1 = Integer.parseInt(param1);

                data.add(new Sujet(cast1,rs.getString(2),rs.getString("Nom")));

                EnonceSujet.setCellValueFactory(new PropertyValueFactory<>("EnoncerSujet"));
                NumeroSujet.setCellValueFactory(new PropertyValueFactory<>("IDSujet"));
                NomEncadreur.setCellValueFactory(new PropertyValueFactory<>("NomProffesseur"));
                Tableau.setItems(data);
            }
        } catch (Exception e) {
            System.out.println(e + "  Probleme f Page de choix ");
        }



    }

    public void ListnerSelectedRow(){
        Tableau.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                int index = Tableau.getSelectionModel().getSelectedIndex();
                Tableau.getItems().get(index).getEnoncerSujet();
            }
        });

    }













    }








