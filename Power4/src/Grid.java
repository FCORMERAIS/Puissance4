import java.util.ArrayList;

public class Grid {

    public ArrayList<ArrayList<String>> grille;

    public Grid() {
        grille = new ArrayList<ArrayList<String>>();
        for (int j = 0 ; j < 6; j++) {
            ArrayList<String> tempo = new ArrayList<String>();
            for (int i = 0; i <8; i++) {
                tempo.add(" ");
            }
            grille.add(tempo);
        }
    }

}
