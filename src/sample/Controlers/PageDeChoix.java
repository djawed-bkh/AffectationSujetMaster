package sample.Controlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Classes.Sujet;


import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class PageDeChoix implements Initializable {


    public static int NSujet;
    public static int IdAutreEtudiant;// id de l'étudiant dont on va desafecter le sujet
    public static String MailAutreEtudiant;
    public static String Enoncer;
    public static String ProfEncadreur;


    @FXML
    private Button Suivant;
    @FXML
    private Label Sujet;
    @FXML
    private Label Disponibilite;

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
    void AffecterSujet(ActionEvent event) throws IOException {                  //bouton suivant

        if (Disponibilite.getText()=="Disponible"){




            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/fxml/ConfirmationChoix.fxml"));
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Choix du projet");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();




        }else {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Sujet Indisponible, veuillez en choisir un autre !");

            alert.showAndWait();
        }






    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        FillingTableView();

        ListnerSelectedRow();



    }



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
            con.close();
        } catch (Exception e) {
            System.out.println(e + "  Probleme f Page de choix ");
        }



    }





    public void ListnerSelectedRow(){
        Tableau.setOnMouseClicked((MouseEvent event) -> {                               // listner de selection d'une ligne dans le tableview
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                int index = Tableau.getSelectionModel().getSelectedIndex();
                Sujet.setText( Tableau.getItems().get(index).getEnoncerSujet());
                NSujet=Tableau.getItems().get(index).getIDSujet();
                Enoncer=Tableau.getItems().get(index).getEnoncerSujet();
                ProfEncadreur=Tableau.getItems().get(index).getNomProffesseur();



                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/webService", "root", "djawed");


                    String sqlQuery = "SELECT Etudiant.MoyenneCursus,Etudiant.EtudiantID,Etudiant.MoyenneUF,Etudiant.DateAttribution,Etudiant.email from Etudiant where SujetID=?";
                    PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
                    prepStmt.setInt(1, NSujet);
                    ResultSet rs = prepStmt.executeQuery();




                    if (rs.next()){   //sujet affecter
                        if (Controller.MoyenneCursus<rs.getFloat("MoyenneCursus")){      // Moyenne cursus :doit choisir un autre sujet dispo
                            Disponibilite.setText("Indisponible");
                            IdAutreEtudiant=-1;
                        }




                        else if (Controller.MoyenneCursus>rs.getFloat("MoyenneCursus")){    //  Moyenne cursus :permuter de destinataire
                                            IdAutreEtudiant=rs.getInt("Etudiant.EtudiantID");
                                            MailAutreEtudiant=rs.getString("Etudiant.email");
                                            Disponibilite.setText("Disponible");




                        }else {                                                                           // cas d'égalité on compare les moyenne des unités fondamentales

                            if (Controller.MoyenneUF<rs.getFloat("MoyenneUF")){      //   d'apres la moyenne UF   doit choisir un autre sujet dispo
                                Disponibilite.setText("Indisponible");
                                IdAutreEtudiant=-1;




                            }else if (Controller.MoyenneUF>rs.getFloat("MoyenneUF")){

                                IdAutreEtudiant=rs.getInt("Etudiant.EtudiantID");
                                Disponibilite.setText("Disponible");



                            }


                        }





                    }else{
                        Disponibilite.setText("Disponible");

                    }





                    con.close();
                } catch (Exception e) {
                    System.out.println(e + "  Probleme f listner  de tableview ");
                }









            }
        });









    }






















    }








