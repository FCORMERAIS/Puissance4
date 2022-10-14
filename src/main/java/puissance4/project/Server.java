package puissance4.project;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Server {
    /**
     * this method is for launch the server and connect the client to this
     * @param numberPlayer it's the number that we are waiting for
     */
    public static void LaunchServeur(int numberPlayer) {
        ArrayList<SocketChannel> listClient = new ArrayList<SocketChannel>(); //it's our list of clients who is connected
        try {
            // we open our serverSocket
            ServerSocketChannel serverSocket  = ServerSocketChannel.open();
            serverSocket.bind(new InetSocketAddress(4004));
            while(numberPlayer != listClient.size()) { // the while will stop when the good number of player will come 
                SocketChannel clientSocket = serverSocket.accept();
                System.out.println("Un client s'est connecté ! ");
                listClient.add(clientSocket);
                broadcast(Integer.toString(numberPlayer), clientSocket);
            }
        }catch (IOException e) {
            System.err.println(e.toString());
        }
        Player playerPlay = PlayerAleatoy(numberPlayer); // playerPlay is choose with an aleatory method that choose a player
        Grid grid = new Grid(numberPlayer);
        Map<Player, SocketChannel> dictionary = new HashMap<Player, SocketChannel>(); // this dictionnary is use for assimilate a Player with a socketClient
        for (int i = 0; i < listClient.size(); i++) {
            Player player;
            if (i==0) {player = Player.Player1;}else if (i==1) {player = Player.Player2;}else {player = Player.Player3;}
            dictionary.put(player, listClient.get(i));
        }
        while(!Verify.Win(grid.grille)&& !Verify.Egality(grid.grille)) { //we played this while nobody has won or there is not an egality
            for (SocketChannel socketChannel : listClient) {
                if (socketChannel == dictionary.get(playerPlay)) { // if it's the turn to the playerSocket
                    switch (playerPlay) {// we see what Player is the client and send him a X, O, V
                        case Player1:
                            broadcast("Your turn X",socketChannel);
                            break;
                        case Player2:
                            broadcast("Your turn O",socketChannel);
                            break;
                        default:
                            broadcast("Your turn V",socketChannel);
                            break;
                    }
                }else {//if it's not the turn to the client we just send him "turn"
                    broadcast("Turn",socketChannel);
                }
            }
            String Message = "";
            try {
                Message = Client.Listen(dictionary.get(playerPlay)); // we take the message from the client who has played 
            }catch (IOException e) {
                System.err.println(e.toString());
            }
            for (SocketChannel socketChannel : listClient) {
                broadcast(Message, socketChannel); // we send the same message to all Client, for update their grid with the play
            }
            playerPlay = NextPlayer(numberPlayer, playerPlay);// we passed to the next player 
            Display.played(grid.grille,String.valueOf(Message.charAt(5)),String.valueOf(Message.charAt(7)));// we use the method played to update the grid
        }
    }

    /**
     * This method is for send a message to a client 
     * @param message the message type String we want ot send
     * @param clientSocket 
     */
    public static void broadcast(String message, SocketChannel clientSocket){
        try{
            ByteBuffer bytes = ByteBuffer.wrap(message.getBytes("UTF-8"));
        while(bytes.hasRemaining()){
            clientSocket.write(bytes);
        }
        }catch(IOException e){
            System.err.println(e.toString());
        }
    }

    /**
     * this method is usefull for choose an aleatory player 
     * @param playerNb it's the number of player
     * @return we return the Player with an index in the enum Player
     */
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

    /**
     * this method is for take the next player to play 
     * @param playerNb it's the number of player who is playing power 4 
     * @param player it's the player that have played
     * @return we return the next player 
     */
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
}