import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Display {
    public static void printGrid(ArrayList<ArrayList<String>> grid) {
        for (List<String> list : grid) {
            System.out.print("#|");
            for (String caraString : list) {
                System.out.print(caraString+'|');
            }
            System.out.print("#\n");
        }
        System.out.print("#".repeat(18)+"\n");
        System.out.println(" "+" 1 2 3 4 5 6 7 8"+" ");
    }


//################################################################################################//
//################################################################################################//
//################################################################################################//

    public static void chooseWherePlayX(ArrayList<ArrayList<String>> Grid) {
        System.out.println("choose a value to put your piece (between 1 to 8)");
        InputStreamReader var = new InputStreamReader(System.in);
        BufferedReader var2 = new BufferedReader(var);
        int number = 0;
        try {
            number = Integer.parseInt(var2.readLine());
            if (number>8 || number<1) {
                System.err.println("choose a correct value (1-8)");
                chooseWherePlayX(Grid);
                return; 
            } 
        }catch (IOException e){
            System.err.println("choose a correct value (1-8)" + e.toString());
            chooseWherePlayX(Grid);
            return; 
        }
        for (int i = Grid.size()-1; i >=0 ; i--) {
            if (Grid.get(i).get(number-1) == " ") {
                Grid.get(i).set(number-1,"X");
                return; 
            }
        }
        System.err.println("the column you choose is already completed ! ");
        chooseWherePlayX(Grid);
        return; 
    }

//################################################################################################//
//################################################################################################//
//################################################################################################//


    public static void chooseWherePlayV(ArrayList<ArrayList<String>> Grid) {
        System.out.println("choose a value to put your piece (between 1 to 8)");
        InputStreamReader var = new InputStreamReader(System.in);
        BufferedReader var2 = new BufferedReader(var);
        int number = 0;
        try {
            number = Integer.parseInt(var2.readLine());
            if (number>8 || number<1) {
                System.err.println("choose a correct value (1-8)");
                chooseWherePlayV(Grid);
                return; 
            } 
        }catch (IOException e){
            System.err.println("choose a correct value (1-8)" + e.toString());
            chooseWherePlayV(Grid);
            return; 
        }
        for (int i = Grid.size()-1; i >=0 ; i--) {
            if (Grid.get(i).get(number-1) == " ") {
                Grid.get(i).set(number-1,"V");
                return;
            }
        }
        System.err.println("the column you choose is already completed ! ");
        chooseWherePlayV(Grid);
        return; 
    }

//################################################################################################//
//################################################################################################//
//################################################################################################//



    public static void chooseWherePlayO(ArrayList<ArrayList<String>> Grid) {
        System.out.println("choose a value to put your piece (between 1 to 8)");
        InputStreamReader var = new InputStreamReader(System.in);
        BufferedReader var2 = new BufferedReader(var);
        int number = 0;
        try {
            number = Integer.parseInt(var2.readLine());
            if (number>8 || number<1) {
                System.err.println("choose a correct value (1-8)");
                chooseWherePlayO(Grid);
                return; 
            } 
        }catch (IOException e){
            System.err.println("choose a correct value (1-8)" + e.toString());
            chooseWherePlayO(Grid);
            return; 
        }
        for (int i = Grid.size()-1; i >=0 ; i--) {
            if (Grid.get(i).get(number-1) == " ") {
                Grid.get(i).set(number-1,"O");
                return;
            }
        }
        System.err.println("the column you choose is already completed ! ");
        chooseWherePlayO(Grid);
        return; 
    }
}