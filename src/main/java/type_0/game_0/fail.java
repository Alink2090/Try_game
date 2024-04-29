package type_0.game_0;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class fail extends bg_back{

    @FXML
    protected ImageView imae7 = new ImageView();

    @FXML
    protected Label l1 = new Label(),l2 = new Label(),l3 = new Label();
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        imae7.setImage(P[z].get_image());
        if (b>=0){
            l1.setText(" CONGRADULATION !!!");
            l2.setText(" "+P[z].get_nom());
            l3.setText(" WIN");
        }else if (e>=0){
            l1.setText(" OOOHHHH NOOOOO !!!");
            l2.setText(P[z].get_nom());
            l3.setText(" LOOSE");
        }
        pv1.setProgress(1);
        pv2.setProgress(1);
        pm1.setProgress(1);
        pm2.setProgress(1);
        pd1.setProgress(1);
        pd2.setProgress(1);
        P[z].get_nbr_use_attack(0);
        P[z].get_nbr_use_attack(1);
        P[z].get_nbr_use_attack(2);
        P[z].get_nbr_use_attack(3);
        P[a].get_nbr_use_attack(0);
        P[a].get_nbr_use_attack(1);
        P[a].get_nbr_use_attack(1);
        P[a].get_nbr_use_attack(3);

        cpt=0 ; i1 = 4 ; i2 = 4 ; i3=4 ;
        e =1 ; b = 1 ; c=100 ; d=100;
    }
    public void Retry() throws Exception {
        acceuil.setRacine("bg.fxml");
    }
    public void Choose() throws Exception {
        acceuil.setRacine("page-2.fxml");
    }
}