package type_0.game_0;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class wp_back extends initialize_game{

    static int a;
    @FXML
    protected ImageView imae4  = new ImageView() ;
    @FXML
    protected ImageView imae3  = new ImageView() ;
    @FXML
    protected Button b3;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){

        do {
            a = rand.nextInt(8);
        }while (a==z);

        imae3.setImage(P[z].get_image());
        imae4.setImage(P[a].get_image());

    }
    public void next1() throws Exception {
        acceuil.setRacine("Bg.fxml");
    }
}
