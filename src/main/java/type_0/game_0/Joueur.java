package type_0.game_0;

import javafx.scene.image.Image;

public class Joueur {

    protected String name, classe, type;

    protected Image image;
    protected int pv, strength, defense;
    protected skill[] attack = new skill[4];

    public Joueur() {
        attack[0] = new skill("inconnu",0, 0, 0);
        attack[1] = new skill("inconnu",0, 0, 0);
        attack[2] = new skill("inconnu",0, 0, 0);
        attack[3] = new skill("inconnu",0, 0, 0);
        name = "inconnu";
        classe = "inconnu";
        type= "inconnu";
        pv = strength = defense = 0;

    }

    public Joueur(String n, String c, String t, int p, int s, int d , Image im) {
        name = n;
        classe = c;
        type = t;
        pv = p;
        strength = s;
        defense = d;
        image = im;
    }

    public String get_nom() {
        return name;
    }

    public String get_classe() {
        return classe;
    }

    public String get_type() {
        return type;
    }

    public Image get_image() {
        return image;
    }


    public int get_Pv() {
        return pv;
    }

    public int get_strength() {
        return strength;
    }

    public int get_defense() {
        return defense;
    }

    public void set_pv(int P_pv) {
        pv = P_pv;
    }

    public void set_strength(int P_s) {
        strength = P_s;
    }

    public void set_defense(int P_d) {
        pv = P_d;
    }

    public void set_Skill(int i, String n, int d, int s , int nbr) {
        attack[i] = new skill(n, d,s, nbr);
    }

    public String get_nom_attack(int i) {
        return attack[i].name;
    }

    public int get_degat_attack(int i) {
        return attack[i].get_dégat();
    }

    public int get_stamina_attack(int i) {
        return attack[i].get_stamina();
    }

    public int get_nbr_use_attack(int i) {
        return attack[i].get_nbr_used();
    }

    public void set_nbr_use_attack(int i, int b) {
        attack[i].set_nbr_used(b);
    }


}
