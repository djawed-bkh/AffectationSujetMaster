package sample.Classes;

import com.mysql.cj.xdevapi.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Etudiant {
    private int IDetudiant;
    private String NomEtudiant;
    private String PrenomEtudiant;
    private String DateLieuNaissance;
    private String ParcoursEtudiant;
    private float MoyenneCursus;
    private float MoyenneUF;
    private String Username;
    private String Password;
    private int SujetID;


    public Etudiant(int IDetudiant, String nomEtudiant, String prenomEtudiant, String dateLieuNaissance, String parcoursEtudiant, float moyenneCursus, float moyenneUF, String username, String password, int sujetID) {
        this.IDetudiant = IDetudiant;
        NomEtudiant = nomEtudiant;
        PrenomEtudiant = prenomEtudiant;
        DateLieuNaissance = dateLieuNaissance;
        ParcoursEtudiant = parcoursEtudiant;
        MoyenneCursus = moyenneCursus;
        MoyenneUF = moyenneUF;
        Username = username;
        Password = password;
        SujetID = sujetID;
    }

    public Etudiant() {
    }

    public int getIDetudiant() {
        return IDetudiant;
    }

    public void setIDetudiant(int IDetudiant) {
        this.IDetudiant = IDetudiant;
    }

    public String getNomEtudiant() {
        return NomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        NomEtudiant = nomEtudiant;
    }

    public String getPrenomEtudiant() {
        return PrenomEtudiant;
    }

    public void setPrenomEtudiant(String prenomEtudiant) {
        PrenomEtudiant = prenomEtudiant;
    }

    public String getDateLieuNaissance() {
        return DateLieuNaissance;
    }

    public void setDateLieuNaissance(String dateLieuNaissance) {
        DateLieuNaissance = dateLieuNaissance;
    }

    public String getParcoursEtudiant() {
        return ParcoursEtudiant;
    }

    public void setParcoursEtudiant(String parcoursEtudiant) {
        ParcoursEtudiant = parcoursEtudiant;
    }

    public float getMoyenneCursus() {
        return MoyenneCursus;
    }

    public void setMoyenneCursus(float moyenneCursus) {
        MoyenneCursus = moyenneCursus;
    }

    public float getMoyenneUF() {
        return MoyenneUF;
    }

    public void setMoyenneUF(float moyenneUF) {
        MoyenneUF = moyenneUF;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getSujetID() {
        return SujetID;
    }

    public void setSujetID(int sujetID) {
        SujetID = sujetID;
    }




    public void createObjEtudiant() throws SQLException, ClassNotFoundException {




    }

}
