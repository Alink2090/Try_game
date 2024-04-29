package type_0.game_0;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class acc_back extends VBox implements Initializable {
    protected Image im = new Image("/theme.jpeg") ;
    @FXML
    protected ImageView imae2;
    @FXML
    protected Button b1 ;
    @FXML
    protected AnchorPane pane;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        imae2.setImage(im);
    }

    public void next() throws Exception {
        acceuil.setRacine("page-2.fxml");
    }

}
