package puissance4.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Display {
    /**
     * This method is use for show to the user the grid we show the grid at every actions of the game
     * @param grid it's the grid we want to show
     */
    protected static void printGrid(ArrayList<ArrayList<String>> grid) {
        for (List<String> list : grid) {
            for (String caraString : list) {
                switch (caraString) {
                    case "X" :
                        System.out.print("├"+ConsoleColors.PURPLE + caraString +ConsoleColors.RESET + "┤");
                        continue;
                    case "O" : 
                        System.out.print("├"+ConsoleColors.BLUE + caraString +ConsoleColors.RESET + "┤");
                        continue;
                    case "V" :
                        System.out.print("├"+ConsoleColors.GREEN + caraString +ConsoleColors.RESET + "┤");
                        continue;
                    default : 
                        System.out.print("├"+caraString +ConsoleColors.RESET + "┤");
                        continue;
                }
            }
            System.out.print("\n");
        }
        System.out.print("└"+ "┴".repeat((grid.get(0).size()*3)-2)+"┘"+"\n");
        if (grid.get(0).size() == 8) {
            System.out.println(ConsoleColors.CYAN+" a  b  c  d  e  f  g  h "+ConsoleColors.RESET);
        }else {
            System.out.println(ConsoleColors.CYAN+" a  b  c  d  e  f  g  h  i  j  k  l "+ConsoleColors.RESET);
        }
    }

//################################################################################################//
//################################################################################################//
//################################################################################################//

    /**
     * this method is for the player who's play it ask where the player want to play and verify if it's possible.
     * @param Grid it's the grid where the player can played
     * @param player it's the Player who's play
     */
    protected static int chooseWherePlay(ArrayList<ArrayList<String>> Grid) {
        String letter = " abcdefghijkl";
        System.out.println(ConsoleColors.YELLOW+"choose a value to put your piece (between 1 to "+Grid.get(0).size()+")"+ConsoleColors.RESET);
        InputStreamReader var = new InputStreamReader(System.in);
        BufferedReader var2 = new BufferedReader(var);
        int number = 0;
        try {
            number = letter.indexOf(var2.readLine());
            if (number>Grid.get(0).size() || number<1) {
                System.err.println(ConsoleColors.RED+"choose a correct value (1- "+Grid.get(0).size()+")"+ConsoleColors.RESET);
                return chooseWherePlay(Grid);
            } 
        }catch (IOException e){
            System.err.println(ConsoleColors.RED+"choose a correct value (1- "+Grid.get(0).size()+")" + e.toString()+ConsoleColors.RESET);
            return chooseWherePlay(Grid);
        }catch(NumberFormatException e) {
            System.err.println(ConsoleColors.RED+"choose a correct number not a str : " + e.toString()+ConsoleColors.RESET);
            return chooseWherePlay(Grid); 
        }
        for (int i = Grid.size()-1; i >=0 ; i--) {
            if (Grid.get(i).get(number-1) == " ") {
                return number;
            }
        }
        System.err.println(ConsoleColors.RED+"the column you choose is already completed ! "+ConsoleColors.RESET);
        return chooseWherePlay(Grid);
    }
    
    public static void played(ArrayList<ArrayList<String>> Grid,String player, int index ) {
        for (int i = Grid.size()-1; i >= 0; i--) {
            if (Grid.get(i).get(index-1) == " ") {
                Grid.get(i).set(index-1, player);
                return;
            }
        }
    }
}
