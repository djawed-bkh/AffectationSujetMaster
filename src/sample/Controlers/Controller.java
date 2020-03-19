package sample.Controlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;


public class Controller {


    @FXML
    private PasswordField password;

    @FXML
    private Label MessageErreur;

    @FXML
    private TextField Username;

    @FXML
    private Button Login;

    @FXML
    void Connexion(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/webService", "root", "djawed");


            String sqlQuery = " select password from Etudiant where username =?";
            PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
            prepStmt.setString(1, Username.getText());
            ResultSet rs = prepStmt.executeQuery();
            if (!rs.next()) {                                                                                     // in case of a false username the query answer is empty
                MessageErreur.setText("Utilisateur introuvable");
                Username.setText("");
                password.setText("");
            } else {

                if (rs.getString("password").equals(password.getText())) {

                    ((Node) (event.getSource())).getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/fxml/PageDeChoix.fxml"));
                    Stage primaryStage = new Stage();
                    primaryStage.setTitle("Choix du projet");
                    primaryStage.setScene(new Scene(root));
                    primaryStage.setResizable(false);
                    primaryStage.show();

                } else {

                    MessageErreur.setText("Username ou mot de passe incorrect réessayez ");
                    Username.setText("");
                    password.setText("");

                }


            }
            prepStmt.close();


        } catch (Exception e) {
            System.out.println(e + "  Probleme f Controller ");
        }

    }


}

