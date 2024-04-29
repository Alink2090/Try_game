package type_0.game_0;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class initialize_game extends VBox implements Initializable {

    Random rand = new Random();
    public static int z;
    int a;
    @FXML
    protected ImageView imae = new ImageView();
    public static Image[] im = new Image[8] ;
    @FXML
    protected Label nom , classe , type , s1 , s2, s3 , s4;
    protected String t;
    protected String[] ch = new String[]{ "al", "extasia", "gach", "gilgamesh", "ike" ,"oz", "leronero",  "zak" };
    protected static Joueur[] P = new Joueur[8];
    @FXML
    protected ComboBox<String> c = new ComboBox<>();

    @FXML
    protected Button b2;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        im[0] = new Image("/al.jpeg");
        imae.setImage(im[0]);
        while (z < 8){
            im[z] = new Image("/"+ch[z]+".jpeg");
            z++;
        }

        P[0] = new Joueur(ch[0]," laughing coffin", " cheater", 100000, 25000, 90,im[0]);
        P[1] = new Joueur(ch[1]," golden order", " berserker",100000, 19000, 70, im[1]);
        P[2] = new Joueur(ch[2]," laughing coffin", " berserker", 100000, 30000, 100, im[2]);
        P[3] = new Joueur(ch[3]," golden order", " cheater", 100000, 28000, 80,im[3]);
        P[4] = new Joueur(ch[4]," trinity 7", " hero",  100000, 25000, 90,im[4]);
        P[5] = new Joueur(ch[5]," trinity 7" ," mage_sombre", 100000, 19000, 70, im[5]);
        P[6] = new Joueur(ch[6]," trinity 7", " berserker", 100000, 30000, 100, im[6]);
        P[7] = new Joueur(ch[7]," laughing coffin", " mage_sombre", 100000, 28000, 80,im[7]);

        // Initialisation des skills
        // P1 Alink
        P[0].set_Skill(0, " fire burst", 4000,5, 10);
        P[0].set_Skill(1, " galactic impact", 7000,7, 6);
        P[0].set_Skill(2, " gamuza : armurie fantome", 10000,9, 5);
        P[0].set_Skill(3, " unlimited star dust", 20000,14, 4);
        // P2 Nero
        P[1].set_Skill(0, " chainsaw", 3500,4, 12);
        P[1].set_Skill(1, " kick-n-cut", 5000,7, 12);
        P[1].set_Skill(2, " witch slice", 10000,10, 12);
        P[1].set_Skill(3, " the death", 30000,30, 2);

        // P3 Vanitas
        P[2].set_Skill(0, " stasis gatling", 7000,10, 8);
        P[2].set_Skill(1, " ultra stasis canon", 10000,12, 8);
        P[2].set_Skill(2, " stasis devastation", 17000,18, 8);
        P[2].set_Skill(3, " berserker wrath", 25000,25, 5);

        // P4 Black
        P[3].set_Skill(0, " gran cero", 10000,9, 6);
        P[3].set_Skill(1, " balan", 5000,8, 8);
        P[3].set_Skill(2, " enuma elish", 20000,15, 6);
        P[3].set_Skill(3, " pandémonium", 40000,40, 1);

        // P1 Alink
        P[4].set_Skill(0, " tranche céleste", 3500,5, 12);
        P[4].set_Skill(1, " galactic impulse", 7000,10, 10);
        P[4].set_Skill(2, " gamuza : phantom keeper ", 15000,15, 5);
        P[4].set_Skill(3, " you've met a terible fate", 20000,20, 4);
        // P2 Nero
        P[5].set_Skill(0, " zeta flare", 5000,8, 10);
        P[5].set_Skill(1, " thunder wave", 10000, 13, 10);
        P[5].set_Skill(2, " ice flare ", 17000,14, 6);
        P[5].set_Skill(3, " elemental breathing : tentai zenmetsu ", 28000,28, 2);

        // P3 Vanitas
        P[6].set_Skill(0, " slice", 4000,7, 10);
        P[6].set_Skill(1, " chopper", 7500,11, 6);
        P[6].set_Skill(2, " stasis slice", 17000,18, 3);
        P[6].set_Skill(3, " nightmare", 28000,20, 2);

        // P4 Black
        P[7].set_Skill(0, " cero", 7000,10, 7);
        P[7].set_Skill(1, " balan", 14000,14, 10);
        P[7].set_Skill(2, " anatar the demonic judge", 7000,18, 3);
        P[7].set_Skill(3, " shadow garden", 35000,35, 1);

        c.getItems().addAll(ch);



    }

    public void action() throws Exception{

        z=0;
        a=0;
        t = c.getValue();
        do{
            if (t.equals(P[z].get_nom())){
                break;
            }
            else {z++;}
        }
        while (!(t.equals(P[z].get_nom())) && z<8);
        do {
            a = rand.nextInt(8);
        }while (a==z);

        if (z==0){
            nom.setText(" "+P[z].get_nom()+" Nosterd");
            classe.setText(P[z].get_classe());
            type.setText(P[z].get_type());
        }
        else {
            nom.setText(" " + P[z].get_nom());
            classe.setText(P[z].get_classe());
            type.setText(P[z].get_type());
        }

        imae.setImage(P[z].get_image());

        s1.setText(P[z].get_nom_attack(0));
        s2.setText(P[z].get_nom_attack(1));
        s3.setText(P[z].get_nom_attack(2));
        s4.setText(P[z].get_nom_attack(3));



    }

    public void next() throws Exception {
        acceuil.setRacine("wp.fxml");
    }


}