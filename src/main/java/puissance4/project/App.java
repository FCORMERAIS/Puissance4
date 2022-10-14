package puissance4.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {   
        StartGame();
    }

    /**
     * it's the menu for choose what do you want to do like be the server how many players, see rules etc..
     */
    public static void StartGame() {
        System.out.println(ConsoleColors.GREEN+"Welcome to the game Power 4!\n1. Play\n2. Rules\n3. Exit"+ConsoleColors.RESET);
        try {
            InputStreamReader bis0 = new InputStreamReader(System.in);
            BufferedReader br0 = new BufferedReader(bis0);
            String choice = br0.readLine();
            switch (choice.charAt(0)) {
                case '1':
                    System.out.println(ConsoleColors.PURPLE_UNDERLINED+"You choose to Play !"+ConsoleColors.RESET);
                    InputStreamReader bis = new InputStreamReader(System.in);
                    BufferedReader br = new BufferedReader(bis);
                    System.out.println(ConsoleColors.GREEN+"Do you want to be :\n1. The Server\n2. Client"+ConsoleColors.RESET);
                    String what = br.readLine();
                    switch(what.charAt(0)) {
                        case '1' :
                            System.out.println(ConsoleColors.PURPLE_UNDERLINED+"you choose Server"+ConsoleColors.RESET);
                            InputStreamReader bis2 = new InputStreamReader(System.in);
                            BufferedReader br2 = new BufferedReader(bis2);
                            System.out.println(ConsoleColors.GREEN+"How many Player do you Want :\n1. 2 Players\n2. 3 Players"+ConsoleColors.RESET);
                            String nbPlayer = br2.readLine();
                            switch (nbPlayer.charAt(0)) {
                                case '1':
                                    System.out.println(ConsoleColors.PURPLE_UNDERLINED+"you choose 2 Players"+ConsoleColors.RESET);
                                    Server.LaunchServeur(2);
                                    break;
                                case '2' :
                                    System.out.println(ConsoleColors.PURPLE_UNDERLINED+"you choose 3 Players"+ConsoleColors.RESET);
                                    Server.LaunchServeur(3);
                                    break;
                                default : 
                                StartGame();
                                break;
                            }
                            break;
                        case '2' :
                            System.out.println(ConsoleColors.PURPLE_UNDERLINED+"you choose Client"+ConsoleColors.RESET);
                            Client.LaunchClient();
                            break;
                        default:
                            StartGame();
                            break;
                }
                break;
            case '2':
                System.out.println(ConsoleColors.PURPLE_UNDERLINED+"You choose to see the rules"+ConsoleColors.RESET);
                System.out.println(ConsoleColors.GREEN_BOLD+"The object of the game is to line up 4 pawns on a grid. Each player plays alternately by dropping one of their tokens from the top of one of the columns. This token therefore fills the lowest unoccupied space in the column. Good luck !"+ConsoleColors.RESET);
                StartGame();
                break;
            case '3':
                System.out.println(ConsoleColors.RED_UNDERLINED+"You chose to exit"+ConsoleColors.RESET);
                break;
            default :
                StartGame();
            }
        } catch (IOException e) {
            System.out.println(ConsoleColors.RED_BOLD+"You chose an invalid option : " + e.toString()+ConsoleColors.RESET);
            StartGame();
        }
    }
}