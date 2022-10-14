package puissance4.project;

import java.util.ArrayList;

public class Grid {

    protected ArrayList<ArrayList<String>> grille;

    /**
     * this constructor make the grid for the game and adapt the size by the number of player
     * @param number it's the number of players who's wants to play (2 or 3)
     */
    protected Grid(int number) {
        if (number == 2) { // grid for 2 players
            grille = new ArrayList<ArrayList<String>>();
            for (int j = 0 ; j < 6; j++) {
                ArrayList<String> tempo = new ArrayList<String>();
                for (int i = 0; i <8; i++) {
                    tempo.add(" ");
                }
                grille.add(tempo);
            }
        }else {// grid for 3 players
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
