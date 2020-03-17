package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//librairies de Mysql
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;



public class Main extends Application {

    public String Login;
    public String MotDePasse;


    @Override
    public void start(Stage primaryStage) throws Exception{
        //partie MYSQL
        try{

           Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/webService","root","djawed");    //3306

            System.out.println("ça marche");
            Statement stmt=con.createStatement();


            //test
            ResultSet rs=stmt.executeQuery("select * from Etudiant");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            //test
            con.close();


        }catch(Exception e){ System.out.println(e + "   Probleme de connexion a la base ");}
    //partie JAVAFX

       /* Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Acceuil");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();*/
    }


    public static void main(String[] args) {

        launch(args);
    }
}








   /* ResultSet rs=stmt.executeQuery("select * from emp");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));*/



