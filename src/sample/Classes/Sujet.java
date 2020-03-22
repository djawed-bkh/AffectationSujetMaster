package sample.Classes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sujet {

    private final IntegerProperty IDSujet;
    private final StringProperty EnoncerSujet;
    private final StringProperty NomProffesseur;

    public Sujet(int IDSujet, String enoncerSujet,String NomProffesseur) {
        this.IDSujet = new SimpleIntegerProperty(IDSujet);
        EnoncerSujet = new SimpleStringProperty(enoncerSujet);
        this.NomProffesseur = new SimpleStringProperty(NomProffesseur);
    }


    public int getIDSujet() {
        return IDSujet.get();
    }

    public IntegerProperty IDSujetProperty() {
        return IDSujet;
    }

    public void setIDSujet(int IDSujet) {
        this.IDSujet.set(IDSujet);
    }

    public String getEnoncerSujet() {
        return EnoncerSujet.get();
    }

    public StringProperty enoncerSujetProperty() {
        return EnoncerSujet;
    }

    public void setEnoncerSujet(String enoncerSujet) {
        this.EnoncerSujet.set(enoncerSujet);
    }

    public String getNomProffesseur() {
        return NomProffesseur.get();
    }

    public StringProperty nomProffesseurProperty() {
        return NomProffesseur;
    }

    public void setNomProffesseur(String nomProffesseur) {
        this.NomProffesseur.set(nomProffesseur);
    }
}
