package puissance4.project;

import java.util.ArrayList;

public class Verify {

    /**
     * This method verify if the grid is full or not, if its full return true 
     * @param Grid it's the grid that we verified if its full or not 
     * @return the result of "if the gris is full"
     */
    protected static boolean Egality(ArrayList<ArrayList<String>> Grid) {
        for (int i = 0; i<Grid.get(0).size();i++) {
            if (Grid.get(0).get(i)==" ") {
                return false;
            }
        }
        System.out.println(ConsoleColors.YELLOW_UNDERLINED+"NO BODY WIN ! EGALITY !!"+ConsoleColors.RESET);
        return true;
    }

    /** 
     * This method verify if a user have won the game Power 4, we verified if there is 4 elements align and if it is we return true and annonced the winner
     * @param Grid it's the grid that we verified if a user have won or not
     * @return the result of "someone have won"
     */
    protected static boolean Win(ArrayList<ArrayList<String>> Grid) {
        // horizontalCheck
        for (int j = 0; j<Grid.size()-3 ; j++ ){
            for (int i = 0; i<Grid.get(0).size(); i++){
                if (Grid.get(j).get(i) == Grid.get(j+1).get(i) && Grid.get(j+2).get(i) == Grid.get(j+1).get(i) && Grid.get(j+2).get(i) == Grid.get(j+3).get(i) && Grid.get(j).get(i) != " "){
                    System.out.println(ConsoleColors.YELLOW_UNDERLINED+"le joueur " + Grid.get(j).get(i) + " a gagner !"+ConsoleColors.RESET);
                    return true;
                }           
            }
        }
        // verticalCheck
        for (int j = 0; j<Grid.get(0).size()-3 ; j++ ){
            for (int i = 0; i<Grid.size(); i++){
                if (Grid.get(i).get(j) == Grid.get(i).get(j+1) && Grid.get(i).get(j+2) == Grid.get(i).get(j+1) && Grid.get(i).get(j+2) == Grid.get(i).get(j+3) && Grid.get(i).get(j) != " "){
                    System.out.println(ConsoleColors.YELLOW_UNDERLINED+"le joueur " + Grid.get(i).get(j) + " a gagner !"+ConsoleColors.RESET);
                    return true;
                }           
            }
        }
        // ascendingDiagonalCheck 
        for (int j = 3; j<Grid.get(0).size() ; j++ ){
            for (int i=0; i<Grid.size()-3; i++){
                if (Grid.get(i).get(j) == Grid.get(i+1).get(j-1) && Grid.get(i+1).get(j-1) == Grid.get(i+2).get(j-2) && Grid.get(i+2).get(j-2) == Grid.get(i+3).get(j-3) && Grid.get(i).get(j) != " ") {
                    System.out.println(ConsoleColors.YELLOW_UNDERLINED+"le joueur " + Grid.get(i).get(j) + " a gagner !"+ConsoleColors.RESET);
                    return true;
                }
            }
        }
        // descendingDiagonalCheck
        for (int j = 3; j<Grid.get(0).size() ; j++ ){
            for (int i=3; i<Grid.size(); i++){
                if (Grid.get(i).get(j) == Grid.get(i-1).get(j-1) && Grid.get(i-1).get(j-1) == Grid.get(i-2).get(j-2) && Grid.get(i-2).get(j-2) == Grid.get(i-3).get(j-3) && Grid.get(i).get(j) != " ") {
                    System.out.println(ConsoleColors.YELLOW_UNDERLINED+"le joueur " + Grid.get(i).get(j) + " a gagner !"+ConsoleColors.RESET);
                    return true;
                }
            }
        }
        return false;
    }
}
