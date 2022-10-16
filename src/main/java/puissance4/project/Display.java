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
    protected static String chooseWherePlay(ArrayList<ArrayList<String>> Grid) {
        String letter = "abcdefghijkl";
        System.out.println(ConsoleColors.YELLOW+"choose a value to put your piece (between a to "+letter.charAt(Grid.get(0).size()-1)+")"+ConsoleColors.RESET);
        InputStreamReader var = new InputStreamReader(System.in);
        BufferedReader var2 = new BufferedReader(var);
        int number = 0;
        String choose = "";
        try {
            choose = var2.readLine();// we take the value that the Player has Played
            number = letter.indexOf(choose);
            if (number>Grid.get(0).size()-1 || number<0) { // we verify if it's a correct value
                System.err.println(ConsoleColors.RED+"choose a correct value (a- "+letter.charAt(Grid.get(0).size()-1)+")"+ConsoleColors.RESET);
                return chooseWherePlay(Grid); // if it's not a correct value we reload the method
            } 
        }catch (IOException e){
            System.err.println(ConsoleColors.RED+"choose a correct value (a- "+letter.charAt(Grid.get(0).size()-1)+")" + e.toString()+ConsoleColors.RESET);
            return chooseWherePlay(Grid);
        }catch(NumberFormatException e) {
            System.err.println(ConsoleColors.RED+"choose a correct number not a str : " + e.toString()+ConsoleColors.RESET);
            return chooseWherePlay(Grid); 
        }
        for (int i = Grid.size()-1; i >=0 ; i--) {
            if (Grid.get(i).get(number) == " ") {
                return choose;
            }
        }
        System.err.println(ConsoleColors.RED+"the column you choose is already completed ! "+ConsoleColors.RESET);
        return chooseWherePlay(Grid); // if the program come here that's mean the Player choose a complete column
    }
    
    /**
     * this method is usefull for play at the index choose to the user with the string we want 
     * @param Grid the grid we want to
     * @param player
     * @param index
     */
    public static void played(ArrayList<ArrayList<String>> Grid,String player, String indexString ) {
        String letter = "abcdefghijkl";
        int index = letter.indexOf(indexString);
        for (int i = Grid.size()-1; i >= 0; i--) {
            if (Grid.get(i).get(index) == " ") {
                Grid.get(i).set(index, player);
                return;
            }
        }
    }
}
