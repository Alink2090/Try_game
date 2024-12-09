package type_0.game_0;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class fail extends bg_back {

    @FXML
    protected ImageView imae7 = new ImageView();

    @FXML
    protected Label l1 = new Label(), l2 = new Label(), l3 = new Label();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        imae7.setImage(P[z].get_image());
        if (e <= 0 && b > 0) {
            l1.setText(" CONGRADULATION !!!");
            l2.setText(b + " " + P[z].get_nom());
            l3.setText(e + "" + b);

        } else if (e > 0 && b <= 0) {
            l1.setText(" OOOHHHH NOOOOO !!!");
            l2.setText(b + " " + P[z].get_nom());
            l3.setText(e + "" + b);
        } else if (b == 0 && e == 0) {
            l1.setText(b + " " + " OVER !!!");
            l3.setText(c + "" + d);
        }

        /*
         * cpt=0 ; i1 = 4 ; i2 = 4 ; i3=4 ;
         * e =1 ; b = 1 ; c=100 ; d=100;
         */
    }

    public void Retry() throws Exception {
        acceuil.setRacine("bg.fxml");
        pv1.setProgress(1);
        pv2.setProgress(1);
        pm1.setProgress(1);
        pm2.setProgress(1);
        pd1.setProgress(1);
        pd2.setProgress(1);
        for (int I = 0; I < 4; I++) {
            att_2[I] = P[a].get_nbr_use_attack(I);
            att_1[I] = P[z].get_nbr_use_attack(I);
        }
    }

    public void Choose() throws Exception {
        acceuil.setRacine("page-2.fxml");
        pv1.setProgress(1);
        pv2.setProgress(1);
        pm1.setProgress(1);
        pm2.setProgress(1);
        pd1.setProgress(1);
        pd2.setProgress(1);
        for (int I = 0; I < 4; I++) {
            att_2[I] = P[a].get_nbr_use_attack(I);
            att_1[I] = P[z].get_nbr_use_attack(I);
        }
    }
}