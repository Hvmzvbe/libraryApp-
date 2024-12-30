package Model;

public class Livre {
    private  String nom;
    private  String imgSrc;
    private  String Author;
    private String rateSrc;
//    private Boolean dispo;
//
//    public Boolean getDispo() {
//        return dispo;
//    }
//
//    public void setDispo(Boolean dispo) {
//        this.dispo = dispo;
//    }

    public String getRateSrc() {
        return rateSrc;
    }

    public void setRateSrc(String rateSrc) {
        this.rateSrc = rateSrc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }
}
