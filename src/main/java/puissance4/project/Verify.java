package puissance4.project;

import java.util.ArrayList;

public class Verify {
    public static boolean Win(ArrayList<ArrayList<String>> Grid) {
        // horizontalCheck
        for (int j = 0; j<Grid.size()-3 ; j++ ){
            for (int i = 0; i<Grid.get(0).size(); i++){
                if (Grid.get(j).get(i) == Grid.get(j+1).get(i) && Grid.get(j+2).get(i) == Grid.get(j+1).get(i) && Grid.get(j+2).get(i) == Grid.get(j+3).get(i) && Grid.get(j).get(i) != " "){
                    System.out.println("le joueur " + Grid.get(j).get(i) + " a gagner !");
                    return true;
                }           
            }
        }
        // verticalCheck
        for (int j = 0; j<Grid.get(0).size()-3 ; j++ ){
            for (int i = 0; i<Grid.size(); i++){
                if (Grid.get(i).get(j) == Grid.get(i).get(j+1) && Grid.get(i).get(j+2) == Grid.get(i).get(j+1) && Grid.get(i).get(j+2) == Grid.get(i).get(j+3) && Grid.get(i).get(j) != " "){
                    System.out.println("le joueur " + Grid.get(i).get(j) + " a gagner !");
                    return true;
                }           
            }
        }
        // ascendingDiagonalCheck 
        for (int j = 3; j<Grid.get(0).size() ; j++ ){
            for (int i=0; i<Grid.size()-3; i++){
                if (Grid.get(i).get(j) == Grid.get(i+1).get(j-1) && Grid.get(i+1).get(j-1) == Grid.get(i+2).get(j-2) && Grid.get(i+2).get(j-2) == Grid.get(i+3).get(j-3) && Grid.get(i).get(j) != " ") {
                    System.out.println("le joueur " + Grid.get(i).get(j) + " a gagner !");
                    return true;
                }
            }
        }
        // descendingDiagonalCheck
        for (int j = 3; j<Grid.get(0).size() ; j++ ){
            for (int i=3; i<Grid.size(); i++){
                if (Grid.get(i).get(j) == Grid.get(i-1).get(j-1) && Grid.get(i-1).get(j-1) == Grid.get(i-2).get(j-2) && Grid.get(i-2).get(j-2) == Grid.get(i-3).get(j-3) && Grid.get(i).get(j) != " ") {
                    System.out.println("le joueur " + Grid.get(i).get(j) + " a gagner !");
                    return true;
                }
            }
        }
        return false;
    }
}
