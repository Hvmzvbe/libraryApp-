package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Objects;

public class CategorieController {


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
}
