package sample;
import Model.Livre;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;


import java.util.Objects;


public class CardController {

    @FXML
    private Label LivreAuthor;
    @FXML
    private ImageView LivreImg;
    @FXML
    private ImageView LivreRate;
    @FXML
    private Label LivreTitre;
    @FXML
    private HBox box;


    private final String[] colors = {"B9E5FF", "BDB2FE", "FB9AA8", "418FDE","00A3E0","008675"};



    public void setcard(Livre l) {

            Image imageL = new Image(Objects.requireNonNull(getClass().getResourceAsStream(l.getImgSrc())));
            LivreImg.setImage(imageL);
         Image imageR = new Image(Objects.requireNonNull(getClass().getResourceAsStream(l.getRateSrc())));
        LivreRate.setImage(imageR);

            LivreTitre.setText(l.getNom());
            LivreAuthor.setText(l.getAuthor());
            box.setStyle("-fx-background-color: #" + colors[(int)(Math.random() * colors.length)]+";"
                    +" -fx-background-radius:15;"+"-fx-effect:dropShadow(three-pass-box,rgba(0,0,0,0),10,0,0,10);");
        }
    }

