package type_0.game_0;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class bg_back extends wp_back {

    Random rand = new Random();

    // P1 : z b c

    @FXML
    protected ProgressBar pv1 = new ProgressBar();
    @FXML
    protected ProgressBar pv2 = new ProgressBar();
    @FXML
    protected ProgressBar pm1 = new ProgressBar();
    @FXML
    protected ProgressBar pm2 = new ProgressBar();
    @FXML
    protected ProgressBar pd1 = new ProgressBar();
    @FXML
    protected ProgressBar pd2 = new ProgressBar();
    @FXML
    protected Button b1, b2, b3, b4; // P1
    @FXML
    protected Button bu1, bu2, bu3, bu4; // P2
    @FXML
    protected ImageView imae5, imae6 = new ImageView();
    @FXML
    protected TextArea textArea = new TextArea(), textArea2 = new TextArea();
    @FXML
    protected ComboBox<String> c24 = new ComboBox<>();

    protected int cpt, i1 = 4, i2 = 4, i3 = 4;
    protected int[] att_1 = new int[4], att_2 = new int[4];
    public static float e=1 , b=1 ,c=100 ,d=100 ;
    // e b vitalite
    // c d stamina
    protected int ver, verdct = 0;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        textArea.setEditable(false);
        e = 1;
        b = 1;
        c = 100;
        d = 100;
        for (int i = 0; i < 4; i++) {
            att_1[i] = P[z].get_nbr_use_attack(i);
            att_2[i] = P[a].get_nbr_use_attack(i);
        }
        textArea.setText("Début de la manche " +
                "\n à votre tour !!!!! " +
                "\n veuillez choisir votre attaque " +
                "\n 1 : " + P[z].get_nom_attack(0) + " ; " + P[z].get_degat_attack(0) + "points de dégats "
                + " ; utilisable :" + +att_1[0] + " fois " +
                "\n 1 : " + P[z].get_nom_attack(1) + " ; " + P[z].get_degat_attack(1) + "points de dégats "
                + " ; utilisable :" + +att_1[1] + " fois " +
                "\n 1 : " + P[z].get_nom_attack(2) + " ; " + P[z].get_degat_attack(2) + "points de dégats "
                + " ; utilisable :" + +att_1[2] + " fois " +
                "\n 1 : " + P[z].get_nom_attack(3) + " ; " + P[z].get_degat_attack(3) + "points de dégats "
                + " ; utilisable :" + +att_1[3] + " fois " +
                "\n ............................");
        setText();

        b1.setText(P[z].get_nom_attack(0));
        b2.setText(P[z].get_nom_attack(1));
        b3.setText(P[z].get_nom_attack(2));
        b4.setText(P[z].get_nom_attack(3));

        bu1.setText(P[a].get_nom_attack(0));
        bu2.setText(P[a].get_nom_attack(1));
        bu3.setText(P[a].get_nom_attack(2));
        bu4.setText(P[a].get_nom_attack(3));

        imae5.setImage(P[z].get_image());
        imae6.setImage(P[a].get_image());

        pv1.setProgress(1);
        pv2.setProgress(1);
        pm1.setProgress(1);
        pm2.setProgress(1);
        pd1.setProgress(1);
        pd2.setProgress(1);

        c24.getItems().addAll("heal *" + i1, "power *" + i2, "def *" + i3, "regen");

    }

    public void action1() throws Exception {

        setAction(0);

    }

    public void action2() throws Exception {

        setAction(1);

    }

    public void action3() throws Exception {

        setAction(2);

    }

    public void action4() throws Exception {

        setAction(3);

    }

    public void setAction(int i) throws Exception {
        if (P[a].get_stamina_attack(cpt) > d) {
            d = d + 10;
            ver = 1;
        } else if (b < ((float) P[a].get_degat_attack(cpt) / P[z].get_Pv())) {
            verdict();
        } else {
            b = b - ((float) P[a].get_degat_attack(cpt) / P[z].get_Pv());
            if (P[a].get_stamina_attack(cpt) == d) {
                d = 0;
            } else if (P[a].get_stamina_attack(cpt) < d) {
                d = d - P[a].get_stamina_attack(cpt);
            }
            att_2[cpt] = att_2[cpt] - 1;
            ver = 0;
        }
        if (att_1[i] == 0) {
            textArea.setText(" you can't use !!!!");
        } else if (P[z].get_stamina_attack(i) > c) {
            textArea.setText(" not enough energies");
        } else if (e < ((float) P[z].get_degat_attack(i) / P[a].get_Pv())) {
            verdict();
        } else {
            /*
             * do {
             * }while(P[a].get_stamina_attack(cpt)>d);
             */
            do {
                cpt = rand.nextInt(4);
            } while (att_2[cpt] == 0);

            // P[a].set_pv(P[a].get_Pv() - P[z].get_degat_attack(i) );
            e = e - ((float) P[z].get_degat_attack(i) / P[a].get_Pv());
            System.out.println(e+" a "+b);
            if (ver == 0) {
                textArea.setText(P[z].get_nom() + " utilise " + P[z].get_nom_attack(i)
                        + "\n" + P[a].get_nom() + " recoit " + P[z].get_degat_attack(i) + " de dégats !!!!!!" +
                        "\n" +
                        "\n" + P[a].get_nom() + " utilise " + P[a].get_nom_attack(cpt) + "\n"
                        + P[z].get_nom() + " recoit " + P[a].get_degat_attack(cpt) + " de dégats !!!!!!" + "\n"
                        + b + " " + e + " " + d + " " + e);
            } else if (ver == 1) {
                textArea.setText(P[z].get_nom() + " utilise " + P[z].get_nom_attack(i)
                        + "\n" + P[a].get_nom() + " recoit " + P[z].get_degat_attack(i) + " de dégats !!!!!!" +
                        "\n" +
                        "\n" + P[a].get_nom() + " utilise regen " + "\n"
                        + b + " " + e + " " + d + " " + e);
            }

            c = c - P[z].get_stamina_attack(i);
            if (b <= 0 || e <= 0) {
                verdict();
            }

            pv1.setProgress(b);
            pv2.setProgress(e);

            if (c <= 0) {
                c = 0;
                pm1.setProgress(0);
            } else if (d <= 0) {
                d = 0;
                pm2.setProgress(0);
            } else if (!(c > 0 || d > 0)) {
                d = 0;
                c = 0;
                pm1.setProgress(0);
                pm2.setProgress(0);
            } else {
                pm1.setProgress(c / 100);
                pm2.setProgress(d / 100);
            }
            att_1[i] = att_1[i] - 1;
            setText();
            /*if (b <= 0.0 && e > 0.0) {
                verdict();
                verdct = 1;
            } else if (e <= 0.0 && b > 0.0) {
                verdict();
                verdct = 2;
            } else if (b == 0.0 && e == 0.0) {
                verdict();
                verdct = 3;
            }*/

            if (b <= 0.0 || e <= 0.0) {
                verdict();
            }
            System.out.println(e+" 2 "+b);
        }
    }

    public void setText() {
        textArea2.setText("skill 1 / dégats / nbr utilisations \n" + P[z].get_nom_attack(0) + " \n "
                + P[z].get_degat_attack(0) + " \n " + att_1[0] +
                "\n" + "skill 2 / dégats / nbr utilisations  \n" + P[z].get_nom_attack(1) + " \n "
                + P[z].get_degat_attack(1) + " \n " + att_1[1] +
                "\n" + "skill 3 / dégats / nbr utilisations  \n" + P[z].get_nom_attack(2) + " \n "
                + P[z].get_degat_attack(2) + " \n " + att_1[2] +
                "\n" + "skill 4 / dégats / nbr utilisations  \n" + P[z].get_nom_attack(3) + " \n "
                + P[z].get_degat_attack(3) + " \n " + att_1[3]);
    }

    public void verdict() throws Exception {
        acceuil.setRacine("fail.fxml");
        b = b + 0;
        e = e + 0;
    }

    public void reg() throws Exception {
        if (P[a].get_stamina_attack(cpt) > d) {
            d = d + 10;
            ver = 1;
        } else if (b < ((float) P[a].get_degat_attack(cpt) / P[z].get_Pv())) {
            verdict();
        } else {
            b = b - ((float) P[a].get_degat_attack(cpt) / P[z].get_Pv());
            if (P[a].get_stamina_attack(cpt) == d) {
                d = 0;
            } else if (P[a].get_stamina_attack(cpt) < d) {
                d = d - P[a].get_stamina_attack(cpt);
            }
            att_2[cpt] = att_2[cpt] - 1;
            ver = 0;
        }

        if (c24.getValue().equals("heal *" + i1)) {
            if (i1 == 0) {
                textArea.setText("you can't use cause it's over");
            } else {
                c24.getItems().clear();
                c24.getItems().addAll("heal *" + (i1 - 1), "power *" + i2, "def *" + i3, "regen");
                if (ver == 1) {
                    textArea.setText(P[z].get_nom() + " utilise " + "heal" +
                            "\n" +
                            "\n" + P[a].get_nom() + " utilise " + P[a].get_nom_attack(cpt) + "\n"
                            + P[z].get_nom() + " recoit " + P[a].get_degat_attack(cpt) + " de dégats !!!!!!");
                } else if (ver == 0) {
                    textArea.setText(P[z].get_nom() + " utilise " + "heal" +
                            "\n" +
                            "\n" + P[a].get_nom() + " utilise regen ");
                }

                i1 = i1 - 1;
                b = (float) (b + 0.15);

            }
        } else if (c24.getValue().equals("power *" + i2)) {
            if (i2 == 0) {
                textArea.setText("you can't use cause it's over");
            } else {
                c24.getItems().clear();
                c24.getItems().addAll("heal *" + i1, "power *" + (i2 - 1), "def *" + i3, "regen");
                if (ver == 0) {
                    textArea.setText(P[z].get_nom() + " utilise " + "power" +
                            "\n" +
                            "\n" + P[a].get_nom() + " utilise " + P[a].get_nom_attack(cpt) + "\n"
                            + P[z].get_nom() + " recoit " + P[a].get_degat_attack(cpt) + " de dégats !!!!!!");
                } else if (ver == 1) {
                    textArea.setText(P[z].get_nom() + " utilise " + "power" +
                            "\n" +
                            "\n" + P[a].get_nom() + " utilise regen ");
                }

                i2 = i2 - 1;
            }

        } else if (c24.getValue().equals("def *" + i3)) {
            if (i3 == 0) {
                textArea.setText("you can't use cause it's over");
            } else {
                c24.getItems().clear();
                c24.getItems().addAll("heal *" + i1, "def *" + i2, "def *" + (i3 - 1), "regen");
                if (ver == 0) {
                    textArea.setText(P[z].get_nom() + " utilise " + "def" +
                            "\n" +
                            "\n" + P[a].get_nom() + " utilise " + P[a].get_nom_attack(cpt) + "\n"
                            + P[z].get_nom() + " recoit " + P[a].get_degat_attack(cpt) + " de dégats !!!!!!");
                } else if (ver == 1) {
                    textArea.setText(P[z].get_nom() + " utilise " + "def" +
                            "\n" +
                            "\n" + P[a].get_nom() + " utilise regen ");
                }

                i3 = i3 - 1;

            }

        } else if (c24.getValue().equals("regen")) {
            c24.getItems().clear();
            c24.getItems().addAll("heal *" + i1, "regen*" + i2, "def *" + i3, "regen");
            if (ver == 0) {
                textArea.setText(P[z].get_nom() + " utilise " + "regen" +
                        "\n" +
                        "\n" + P[a].get_nom() + " utilise " + P[a].get_nom_attack(cpt) + "\n"
                        + P[z].get_nom() + " recoit " + P[a].get_degat_attack(cpt) + " de dégats !!!!!!");
            } else {
                textArea.setText(P[z].get_nom() + " utilise " + "regen" +
                        "\n" +
                        "\n" + P[a].get_nom() + " utilise regen");
            }

            c = c + 20;
            pm1.setProgress(c / 100);

        }

        if (b <= 0) {
            pv1.setProgress(0);
        } else {
            pv1.setProgress(b);
            pv2.setProgress(e);
        }
        pm2.setProgress(d / 100);
        if (b <= 0 || e <= 0) {
            verdict();
        }
    }
}
