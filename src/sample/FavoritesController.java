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

import java.io.IOException;
import java.net.URL;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class FavoritesController implements Initializable {
    @FXML
    private GridPane GridFavorites;
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
    private Button btnReading;

    @FXML
    private Button btnShelves;

    @FXML
    private Button btnShelvesAdd;

    @FXML
    private Button btnTopBooks;

    @FXML
    private HBox cardLayout;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Livre> r =Favorites();
        int column =0;
        int row =1;
        try{
            for(Livre livre : r ) {
                FXMLLoader fx = new FXMLLoader();
                fx.setLocation(getClass().getResource("/fxmlFile/GridB.fxml"));
                VBox A = fx.load();
                GridBController Grid= fx.getController();
                Grid.setData(livre);
                if(column==6){
                    column=0;
                    ++row;
                }
                GridFavorites.add(A,column++,row);
                GridPane.setMargin(A,new Insets(10));

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











    public List<Livre> Favorites(){
        List<Livre> ls = new ArrayList<>();
        DbConnection conNow = new DbConnection();
        Connection con =conNow.getConnexion();
        String sql="SELECT * FROM livre ;";
        try(Statement stmt = con.createStatement(); ResultSet res = stmt.executeQuery(sql)){
            while (res.next()){
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

}
