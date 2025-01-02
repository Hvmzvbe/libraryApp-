package sample;

import Model.Livre;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ReadingController implements Initializable {
    @FXML
    private Label UserNameAccounts;

    @FXML
    private Button btnBrows;

    @FXML
    private Button btnCtegori;

    @FXML
    private Button btnFavorites;

    @FXML
    private Button btnHistory;

    @FXML
    private Button btnReading;

    @FXML
    private Button btnShelves;

    @FXML
    private Button btnShelvesAdd;

    @FXML
    private Button btnTopBooks;

    @FXML
    private HBox cardLayout;

    @FXML
    private GridPane GridReading;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Livre> r = Reading();
        int column=0;
        int row=1;
        try {
            for (Livre livre : r) {
                FXMLLoader fx = new FXMLLoader();
                fx.setLocation(getClass().getResource("/fxmlFile/GridB.fxml"));
                VBox A = fx.load();
                GridBController g = fx.getController();
                g.setData(livre);
                if(column==6){
                    ++row;
                    column=0;
                }
                GridReading.add(A,column++,row);
                GridPane.setMargin(A,new Insets(10));


            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //bouton
    public void btnCtegori(ActionEvent a){

        openFXML("categorie",btnCtegori);
    }
    public void btnTopBooks(ActionEvent a){

        openFXML("TopBooks",btnTopBooks);
    }
    public void btnFavorites(ActionEvent a){

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
    private List<Livre> Reading(){
        List<Livre> ls = new ArrayList<>();
        DbConnection conow = new DbConnection();
        Connection conn = conow.getConnexion();
        String sql = "SELECT * FROM livre;";
        try(Statement stmt = conn.createStatement(); ResultSet res = stmt.executeQuery(sql)){
            while(res.next()){
                Livre l = new Livre();
                l.setNom(res.getString(2));
                l.setAuthor(res.getString(3));
                l.setImgSrc(res.getString(4));
                l.setRateSrc(res.getString(5));
                ls.add(l);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ls;
    }
}
