package sample.Classes;

public class Proffesseur {
    private int IDProffesseur;
    private String NomProffesseur;
    private String PrenomProffesseur;
    private String DateLieuNaissance;
    private String Grade;


    public Proffesseur(int IDProffesseur, String nomProffesseur, String prenomProffesseur, String dateLieuNaissance, String grade) {
        this.IDProffesseur = IDProffesseur;
        NomProffesseur = nomProffesseur;
        PrenomProffesseur = prenomProffesseur;
        DateLieuNaissance = dateLieuNaissance;
        Grade = grade;
    }

    public Proffesseur() {
    }

    public int getIDProffesseur() {
        return IDProffesseur;
    }

    public void setIDProffesseur(int IDProffesseur) {
        this.IDProffesseur = IDProffesseur;
    }

    public String getNomProffesseur() {
        return NomProffesseur;
    }

    public void setNomProffesseur(String nomProffesseur) {
        NomProffesseur = nomProffesseur;
    }

    public String getPrenomProffesseur() {
        return PrenomProffesseur;
    }

    public void setPrenomProffesseur(String prenomProffesseur) {
        PrenomProffesseur = prenomProffesseur;
    }

    public String getDateLieuNaissance() {
        return DateLieuNaissance;
    }

    public void setDateLieuNaissance(String dateLieuNaissance) {
        DateLieuNaissance = dateLieuNaissance;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }
}
