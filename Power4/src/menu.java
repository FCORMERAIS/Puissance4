import java.io.ObjectStreamConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class menu {
    public static void Menu() {
        System.out.println("Welcome to the game Power 4!");
        System.out.println("1. Play");
        System.out.println("2. Rules");
        System.out.println("3. Exit");
    // try {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("You chose to play");
                Display.printGrid();
                break;
            case 2:
                System.out.println("You chose to see the rules");
                System.out.println("The object of the game is to line up 4 pawns on a grid with 6 rows and 7 columns. Each player plays alternately by dropping one of their tokens from the top of one of the columns. This token therefore fills the lowest unoccupied space in the column. Good luck !");
                System.out.println("1. Play");
                System.out.println("2. Rules");
                System.out.println("3. Exit");
                Scanner sc2 = new Scanner(System.in);
                String choice2 = sc2.nextLine();
                if (choice2.equals("1")) {
                    System.out.println("You chose to play");
                    Display.printGrid();
                    break;
                } else if (choice2.equals("2")) {
                    System.out.println("You chose to see the rules");
                } else if (choice2.equals("3")) {
                    System.out.println("You chose to exit");
                    break;
                }
            case 3:
                System.out.println("You chose to exit");
                break;
                // Scanner sc3 = new Scanner(System.in);
                // String choice3 = sc3.nextLine();
                // if (choice3.equals("1")) {
                //     System.out.println("You chose to play");
                // } else if (choice3.equals("2")) {
                //     System.out.println("You chose to see the rules");
                // } else if (choice3.equals("3")) {
                //     System.out.println("You chose to exit");
                // }
            default:
                System.out.println("You chose an invalid option");
                break;
        }
    }  
}

