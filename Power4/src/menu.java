import java.io.ObjectStreamConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        System.out.println("Welcome to the game Power 4!");
        System.out.println("1. Play");
        System.out.println("2. Regles");
        System.out.println("3. Exit");
    try {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("You chose to play");
                break;
            case 2:
                System.out.println("You chose to see the rules");
                break;
            case 3:
                System.out.println("You chose to exit");
                break;
            default:
                System.out.println("You chose an invalid option");
                break;
        }
    } catch (Exception e) {
        System.out.println("You chose an invalid option");
    }
}
}
