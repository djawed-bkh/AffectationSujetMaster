package sample.Controlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
public class ConfirmationChoix {

    @FXML
    public  Label SujetChoisis;

    @FXML
    public  Label DateLieuNaissance;

    @FXML
    public  Button ValidationChoix;

    @FXML
    public  Label ProffesseurEncadreur;

    @FXML
    public  Label ParcoursEtudiant;

    @FXML
    public  Button Annuler;

    @FXML
    public  Label PrenomEtudiant;

    @FXML
    public  Label NomEtudiant;

    @FXML
    public void initialize() {

        NomEtudiant.setText(Controller.Nom);
        PrenomEtudiant.setText(Controller.prenom);
        DateLieuNaissance.setText(Controller.dateLieuNaissance);
        ParcoursEtudiant.setText(Controller.parcours);
        SujetChoisis.setText(PageDeChoix.Enoncer);
        ProffesseurEncadreur.setText(PageDeChoix.ProfEncadreur);


    }





    @FXML
    void Valider(ActionEvent event) {




        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/webService", "root", "djawed");


            if (PageDeChoix.IdAutreEtudiant>0){// Affectation et désafectation




                String sqlQuery = " UPDATE Etudiant   SET SujetID=?, DateAttribution = NOW()  WHERE EtudiantID=?;";
                PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
                prepStmt.setInt(1, PageDeChoix.NSujet);
                prepStmt.setInt(2,Controller.ID );
                int rs = prepStmt.executeUpdate();



                String sqlQueryDES = " UPDATE Etudiant   SET SujetID=NULL , DateAttribution = NULL  WHERE EtudiantID=?;";
                PreparedStatement prepStmtDES = con.prepareStatement(sqlQueryDES);
                prepStmtDES.setInt(1,PageDeChoix.IdAutreEtudiant );
                int rsDES = prepStmtDES.executeUpdate();
                envoyerMailSMTP(PageDeChoix.MailAutreEtudiant);



            }else{                      // Affectation tout court




                String sqlQuery = " UPDATE Etudiant   SET SujetID=?, DateAttribution = NOW()  WHERE EtudiantID=?;";
                PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
                prepStmt.setInt(1, PageDeChoix.NSujet);
                prepStmt.setInt(2,Controller.ID );
                int rs = prepStmt.executeUpdate();

            }











        } catch (Exception e) {
            System.out.println(e + "  Probleme f Confirmation de choix ");
        }




        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Sujet affecté avec succés");

        alert.showAndWait();
        System.exit(0);







    }

     public void envoyerMailSMTP(String destinataire) {
       final String senderEmail = "bekhouchadjawed@gmail.com";
        final String password = "*****";                            // ici viens le mot de passe du mail
        try {
            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");
            Session session = Session.getInstance(prop,new javax.mail.Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(senderEmail,password);
                }
            });
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("bekhouchadjawed@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(destinataire));
            message.setSubject("Sujet désafécté");
            message.setText("Votre sujet viens détre désafécté veuillez en choisir un autre ");
            Transport.send(message);
        }
        catch ( Exception  e) {
            System.out.println(e);//MessagingException throw new RuntimeException(e);
        }

    }








    @FXML
    void Annuler(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/fxml/PageDeChoix.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Choix du projet");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}