package sample;

import Model.Livre;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;


import java.util.Objects;

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
        Image imageL = new Image(Objects.requireNonNull(getClass().getResourceAsStream(l.getImgSrc())));
        Gimg.setImage(imageL);
        Image imageR = new Image(Objects.requireNonNull(getClass().getResourceAsStream(l.getRateSrc())));
        GRate.setImage(imageR);
        GAuthor.setText(l.getAuthor());
        GTitre.setText(l.getNom());

    }
}
