package sample;

import Model.Livre;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
public class GridBController {
    @FXML
    private Label GAuthor;

    @FXML
    private ImageView GRate;

    @FXML
    private Label GTitre;

    @FXML
    private ImageView Gimg;

    public void setData(Livre l){
        Image imageL = new Image(getClass().getResourceAsStream(l.getImgSrc()));
        Gimg.setImage(imageL);
        Image imageR = new Image(getClass().getResourceAsStream(l.getRateSrc()));
        GRate.setImage(imageR);
        GAuthor.setText(l.getAuthor());
        GTitre.setText(l.getNom());
    }
}
