package type_0.game_0;

public class skill {
    public String name;
    protected int dégat, stamina , nbr_used;

    public skill() {
        name = "unknown";
        stamina = 0;
        dégat = 0;
        nbr_used = 0;
    }

    public skill(String n, int d,int s, int nbr) {
        name = n;
        dégat = d;
        stamina = s;
        nbr_used = nbr;
    }

    public int get_dégat() {
        return dégat;
    }

    public int get_stamina() {
        return stamina;
    }

    public int get_nbr_used() {
        return nbr_used;
    }

    public void set_nbr_used(int i) {
        nbr_used = i ;
    }

}
