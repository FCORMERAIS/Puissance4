package Power4.src;

import java.util.ArrayList;
import java.util.List;

public class display {
    public static void printGrid() {
        ArrayList<ArrayList<String>> Grid = new ArrayList<ArrayList<String>>();
        for (int j = 0 ; j < 6; j++) {
            ArrayList<String> tempo = new ArrayList<String>();
            for (int i = 0; i <8; i++) {
                tempo.add(" ");
            }
            Grid.add(tempo);
        }
        Grid.get(0).set(5, "X");
        for (List<String> list : Grid) {
            System.out.print("#");
            for (String caraString : list) {
                System.out.print(caraString+'|');
            }
            System.out.print("#\n");
        }
        System.out.print("#".repeat(18)+"\n");
        System.out.print(" "+"abcdefgh"+" ");
    }
}