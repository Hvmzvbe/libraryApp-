package sample;

import Model.Livre;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class CategorieController implements Initializable {


    @FXML
    private Label UserNameAccounts;

    @FXML
    private Button btnBrows;

    @FXML
    private Button btnCategorie;

    @FXML
    private Button btnFavorites;

    @FXML
    private Button btnHistory;
    @FXML
    private HBox hbxBandesDessinées;

    @FXML
    private HBox hbxInfo;

    @FXML
    private HBox hbxRomans;
    @FXML
    private Button btnReading;

    @FXML
    private Button btnShelves;

    @FXML
    private Button btnShelvesAdd;

    @FXML
    private Button btnTopBooks;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Livre> rinfo = Info();
        List<Livre> rromans = Roman();
        List<Livre> rbandesdessinées = Bandedessine();
        try {


            for (Livre livre : rinfo) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxmlFile/card.fxml"));
                HBox cardBox = fxmlLoader.load();

                CardController cardController = fxmlLoader.getController();
                cardController.setcard(livre);

                hbxInfo.getChildren().add(cardBox);
            }
            for (Livre livre : rromans) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxmlFile/card.fxml"));
                HBox cardBox = fxmlLoader.load();

                CardController cardController = fxmlLoader.getController();
                cardController.setcard(livre);

                hbxRomans.getChildren().add(cardBox);
            }
            for (Livre livre : rbandesdessinées) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxmlFile/card.fxml"));
                HBox cardBox = fxmlLoader.load();

                CardController cardController = fxmlLoader.getController();
                cardController.setcard(livre);

                hbxBandesDessinées.getChildren().add(cardBox);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //bouton
    public void btncategories(ActionEvent a){

        openFXML("categorie",btnCategorie);
    }
    public void btntopbooks(ActionEvent a){

        openFXML("TopBooks",btnTopBooks);
    }
    public void btnfavorites(ActionEvent a){

        openFXML("favorites",btnFavorites);
    }
    public void btnHistory(ActionEvent a){

        openFXML("History",btnHistory);
    }
    public void btnReading(ActionEvent a){

      openFXML("Reading",btnReading);
    }
    public void btnShelves(ActionEvent a){

        openFXML("Shelves",btnShelves);
    }
    public void btnBrows(ActionEvent a){

        openFXML("bib1",btnBrows);
    }














    public void openFXML(String file ,Button b){
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxmlFile/"+file+".fxml")));
            Stage p = new Stage();
            p.setTitle("library");
            p.setScene(new Scene(root,1050,700));
            p.show();
            Stage currentStag = (Stage) b.getScene().getWindow();
            currentStag.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    private List<Livre> Info(){
        List<Livre> ls = new ArrayList<>();
        DbConnection connectNow = new DbConnection();
        Connection conn = connectNow.getConnexion();

        String sql = "SELECT * FROM livre ORDER BY idLivre DESC LIMIT 6;";
        try {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                Livre l = new Livre();
                l.setNom(res.getString(2));
                l.setAuthor(res.getString(3));
                l.setImgSrc(res.getString(4));
                l.setRateSrc(res.getString(5));
                ls.add(l);
            }
        } catch (SQLException e) {
            System.out.println( e.getMessage());
        }
        return ls;
    }
    private List<Livre> Roman(){
        List<Livre> ls = new ArrayList<>();
        DbConnection connectNow = new DbConnection();
        Connection conn = connectNow.getConnexion();

        String sql = "SELECT * FROM livre ORDER BY idLivre DESC LIMIT 6;";
        try {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                Livre l = new Livre();
                l.setNom(res.getString(2));
                l.setAuthor(res.getString(3));
                l.setImgSrc(res.getString(4));
                l.setRateSrc(res.getString(5));
                ls.add(l);
            }
        } catch (SQLException e) {
            System.out.println( e.getMessage());
        }
        return ls;
    }
    private List<Livre> Bandedessine(){
        List<Livre> ls = new ArrayList<>();
        DbConnection connectNow = new DbConnection();
        Connection conn = connectNow.getConnexion();

        String sql = "SELECT * FROM livre ORDER BY idLivre DESC LIMIT 6;";
        try {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                Livre l = new Livre();
                l.setNom(res.getString(2));
                l.setAuthor(res.getString(3));
                l.setImgSrc(res.getString(4));
                l.setRateSrc(res.getString(5));
                ls.add(l);
            }
        } catch (SQLException e) {
            System.out.println( e.getMessage());
        }
        return ls;
    }


}
