package sample;

import Model.Livre;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.geometry.Insets;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private HBox cardLayout;
    @FXML
    private GridPane LivreGrid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Livre> r = RecentlyAdded();
        List<Livre> rec = recommende();
        int column=0;
        int row=1;
        try {
            for (Livre livre : r) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxmlFile/card.fxml"));
                HBox cardBox = fxmlLoader.load();

                CardController cardController = fxmlLoader.getController();
                cardController.setcard(livre);

                cardLayout.getChildren().add(cardBox);
            }
            for(Livre livre : rec){
                FXMLLoader fx =new FXMLLoader();
                fx.setLocation(getClass().getResource("/fxmlFile/GridB.fxml"));
                VBox A = fx.load();
                GridBController Grid = fx.getController();
                Grid.setData(livre);
                if(column==5){
                    column=0;
                    ++row;
                }
                LivreGrid.add(A,column++,row);
                GridPane.setMargin(A,new Insets(10));

            }
        } catch (IOException e) {
            System.out.println( e.getMessage());
        }
    }

    private List<Livre> RecentlyAdded() {
        List<Livre> ls = new ArrayList<>();
        DbConnection connectNow = new DbConnection();
        Connection conn = connectNow.getConnexion();

        String sql = "SELECT * FROM livre ORDER BY idLivre DESC LIMIT 3;";
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
    private List<Livre> recommende() {
        List<Livre> ls = new ArrayList<>();
        DbConnection conNow = new DbConnection();
        Connection con = conNow.getConnexion();
        String sql = "select * from livre;";
        try (Statement stmt = con.createStatement(); ResultSet res = stmt.executeQuery(sql)) {
            while (res.next()) {
                Livre l = new Livre();
                l.setNom(res.getString(2));
                l.setAuthor(res.getString(3));
                l.setImgSrc(res.getString(4));
                l.setRateSrc(res.getString(5));

                ls.add(l);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ls;
    }
}
