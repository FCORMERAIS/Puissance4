package puissance4.project;

import java.util.Random;

public class App {
    protected static void main(String[] args) throws Exception {   
        int number = 2;
        Player playerPlay = PlayerAleatoy(number);
        Grid grid = new Grid(number);
        while(!Verify.Win(grid.grille)&& !Verify.Egality(grid.grille)) {
            Display.printGrid(grid.grille);
            Display.chooseWherePlay(grid.grille,playerPlay);
            playerPlay = NextPlayer(number, playerPlay);
        }
    }

    /**
     * this method is for take the next player to play 
     * @param playerNb it's the number of player who is playing power 4 
     * @param player it's the player that have played
     * @return we return the next player 
     */
    private static Player NextPlayer(int playerNb,Player player) {
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

    /**
     * this method is usefull for choose an aleatory player 
     * @param playerNb it's the number of player
     * @return we return the Player with an index in the enum Player
     */
    private static Player PlayerAleatoy(int playerNb) {
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
