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

    public static void LunchServeur(int numberPlayer) {
        ArrayList<SocketChannel> listClient = new ArrayList<SocketChannel>();
        try {
            ServerSocketChannel serverSocket  = ServerSocketChannel.open();
            serverSocket.bind(new InetSocketAddress(4004));
            while(numberPlayer != listClient.size()) {
                SocketChannel clientSocket = serverSocket.accept();
                System.out.println("Un client s'est connecté ! ");
                listClient.add(clientSocket);
            }
        }catch (IOException e) {
            System.err.println(e.toString());
        }
        Player playerPlay = PlayerAleatoy(numberPlayer);
        Grid grid = new Grid(numberPlayer);
        Map<Player, SocketChannel> dictionary = new HashMap<Player, SocketChannel>();
        for (int i = 0; i < listClient.size(); i++) {
            Player player;
            if (i==0) {player = Player.Player1;}else if (i==1) {player = Player.Player2;}else {player = Player.Player3;}
            dictionary.put(player, listClient.get(i));
        }
        while(!Verify.Win(grid.grille)&& !Verify.Egality(grid.grille)) {
            for (SocketChannel socketChannel : listClient) {
                if (socketChannel == dictionary.get(playerPlay)) {
                    broadcast("Your turn",socketChannel);
                }else {
                    broadcast("Turn",socketChannel);
                }
            }
            String Message = "";
            try {
                Message = Client.Listen(dictionary.get(playerPlay));
            }catch (IOException e) {
                System.err.println(e.toString());
            }
            for (SocketChannel socketChannel : listClient) {
                broadcast(Message, socketChannel);
            }
            playerPlay = NextPlayer(numberPlayer, playerPlay);
            Display.played(grid.grille,String.valueOf(Message.charAt(5)), Integer.parseInt(String.valueOf(Message.charAt(7))));
            Display.printGrid(grid.grille);
        }
    }

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