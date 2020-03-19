package sample.Classes;

public class Sujet {

    private int  IDSujet;
    private String EnoncerSujet;
    private int IDProffesseur;


    public Sujet(int IDSujet, String enoncerSujet, int IDProffesseur) {
        this.IDSujet = IDSujet;
        EnoncerSujet = enoncerSujet;
        this.IDProffesseur = IDProffesseur;
    }

    public Sujet() {
    }


    public int getIDSujet() {
        return IDSujet;
    }

    public void setIDSujet(int IDSujet) {
        this.IDSujet = IDSujet;
    }

    public String getEnoncerSujet() {
        return EnoncerSujet;
    }

    public void setEnoncerSujet(String enoncerSujet) {
        EnoncerSujet = enoncerSujet;
    }

    public int getIDProffesseur() {
        return IDProffesseur;
    }

    public void setIDProffesseur(int IDProffesseur) {
        this.IDProffesseur = IDProffesseur;
    }
}
