package main.java.puissance4.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Display {
    public static void printGrid(ArrayList<ArrayList<String>> grid) {
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
            System.out.println(ConsoleColors.CYAN+" a  b  c  d  e  f  g  h ");
        }else {
            System.out.println(ConsoleColors.CYAN+" a  b  c  d  e  f  g  h  i  j  k  l ");
        }
    }

//################################################################################################//
//################################################################################################//
//################################################################################################//

    public static void chooseWherePlayX(ArrayList<ArrayList<String>> Grid) {
        String letter = " abcdefghijkl";
        System.out.println(ConsoleColors.YELLOW+"choose a value to put your piece (between 1 to "+Grid.get(0).size()+")"+ConsoleColors.RESET);
        InputStreamReader var = new InputStreamReader(System.in);
        BufferedReader var2 = new BufferedReader(var);
        int number = 0;
        try {
            number = letter.indexOf(var2.readLine());
            if (number>Grid.get(0).size() || number<1) {
                System.err.println(ConsoleColors.RED+"choose a correct value (1- "+Grid.get(0).size()+")"+ConsoleColors.RESET);
                chooseWherePlayX(Grid);
                return; 
            } 
        }catch (IOException e){
            System.err.println(ConsoleColors.RED+"choose a correct value (1- "+Grid.get(0).size()+")" + e.toString()+ConsoleColors.RESET);
            chooseWherePlayX(Grid);
            return;
        }catch(NumberFormatException e) {
            System.err.println(ConsoleColors.RED+"choose a correct number not a str : " + e.toString()+ConsoleColors.RESET);
            chooseWherePlayX(Grid);
            return; 
        }
        for (int i = Grid.size()-1; i >=0 ; i--) {
            if (Grid.get(i).get(number-1) == " ") {
                Grid.get(i).set(number-1,"X");
                return; 
            }
        }
        System.err.println(ConsoleColors.RED+"the column you choose is already completed ! "+ConsoleColors.RESET);
        chooseWherePlayX(Grid);
        return; 
    }

//################################################################################################//
//################################################################################################//
//################################################################################################//


    public static void chooseWherePlayV(ArrayList<ArrayList<String>> Grid) {
        String letter = " abcdefghijkl";
        System.out.println(ConsoleColors.YELLOW+"choose a value to put your piece (between 1 to  "+Grid.get(0).size()+")"+ConsoleColors.RESET);
        InputStreamReader var = new InputStreamReader(System.in);
        BufferedReader var2 = new BufferedReader(var);
        int number = 0;
        try {
            number = letter.indexOf(var2.readLine());
            if (number>Grid.get(0).size() || number<1) {
                System.err.println(ConsoleColors.RED+"choose a correct value (1- "+Grid.get(0).size()+")"+ConsoleColors.RESET);
                chooseWherePlayV(Grid);
                return; 
            } 
        }catch (IOException e){
            System.err.println(ConsoleColors.RED+"choose a correct value (1- "+Grid.get(0).size()+")" + e.toString()+ConsoleColors.RESET);
            chooseWherePlayV(Grid);
            return; 
        }catch(NumberFormatException e) {
            System.err.println(ConsoleColors.RED+"choose a correct number not a str : " + e.toString()+ConsoleColors.RESET);
            chooseWherePlayV(Grid);
            return; 
        }
        for (int i = Grid.size()-1; i >=0 ; i--) {
            if (Grid.get(i).get(number-1) == " ") {
                Grid.get(i).set(number-1,"V");
                return;
            }
        }
        System.err.println(ConsoleColors.RED+"the column you choose is already completed ! "+ConsoleColors.RESET);
        chooseWherePlayV(Grid);
        return; 
    }

//################################################################################################//
//################################################################################################//
//################################################################################################//



    public static void chooseWherePlayO(ArrayList<ArrayList<String>> Grid) {
        String letter = " abcdefghijkl";
        System.out.println(ConsoleColors.YELLOW+"choose a value to put your piece (between 1 to  "+Grid.get(0).size()+")"+ConsoleColors.RESET);
        InputStreamReader var = new InputStreamReader(System.in);
        BufferedReader var2 = new BufferedReader(var);
        int number = 0;
        try {
            number = letter.indexOf(var2.readLine());
            if (number>Grid.get(0).size() || number<1) {
                System.err.println(ConsoleColors.RED+"choose a correct value (1- "+Grid.get(0).size()+")"+ConsoleColors.RESET);
                chooseWherePlayO(Grid);
                return; 
            } 
        }catch (IOException e){
            System.err.println(ConsoleColors.RED+"choose a correct value (1- "+Grid.get(0).size()+")" + e.toString()+ConsoleColors.RESET);
            chooseWherePlayO(Grid);
            return; 
        }catch(NumberFormatException e) {
            System.err.println(ConsoleColors.RED+"choose a correct number not a str : " + e.toString()+ConsoleColors.RESET);
            chooseWherePlayO(Grid);
            return; 
        }
        for (int i = Grid.size()-1; i >=0 ; i--) {
            if (Grid.get(i).get(number-1) == " ") {
                Grid.get(i).set(number-1,"O");
                return;
            }
        }
        System.err.println(ConsoleColors.RED+"the column you choose is already completed ! "+ConsoleColors.RESET);
        chooseWherePlayO(Grid);
        return; 
    }
}