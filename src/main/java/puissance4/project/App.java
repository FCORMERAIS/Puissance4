package puissance4.project;

import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {   
        int number = 2;
        Player playerPlay = PlayerAleatoy(number);
        Grid grid = new Grid(number);
        while(!Verify.Win(grid.grille)&& !Verify.Egality(grid.grille)) {
            Display.printGrid(grid.grille);
            Display.chooseWherePlay(grid.grille,playerPlay);
            playerPlay = NextPlayer(number, playerPlay);
        }
    }

    public static Player NextPlayer(int playerNb,Player player) {
        switch (player) {
            case Player1:
                return Player.Player2;
            case Player2:
                if (playerNb == 3) {
                    return Player.Player3;
                }
                return Player.Player1;
            case Player3:
                return Player.Player1;
        }
        return NextPlayer(playerNb, player);
    }

    public static Player PlayerAleatoy(int playerNb) {
        Random rnd = new Random();
        int random = rnd.nextInt(playerNb);
        System.out.println(random);
        switch(random) {
            case 0 : 
                return Player.Player1;
            case 1 :
                return Player.Player2;
            case 2 :
                return Player.Player3;
        }
        return PlayerAleatoy(playerNb);
    }
}
