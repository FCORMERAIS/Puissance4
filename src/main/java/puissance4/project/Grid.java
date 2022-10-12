package puissance4.project;

import java.util.ArrayList;

public class Grid {

    public ArrayList<ArrayList<String>> grille;

    public Grid(int number) {
        if (number == 2) {
            grille = new ArrayList<ArrayList<String>>();
            for (int j = 0 ; j < 6; j++) {
                ArrayList<String> tempo = new ArrayList<String>();
                for (int i = 0; i <8; i++) {
                    tempo.add(" ");
                }
                grille.add(tempo);
            }
        }else {
            grille = new ArrayList<ArrayList<String>>();
            for (int j = 0 ; j < 10; j++) {
                ArrayList<String> tempo = new ArrayList<String>();
                for (int i = 0; i <12; i++) {
                    tempo.add(" ");
                }
                grille.add(tempo);
            }
        }
    }

}
