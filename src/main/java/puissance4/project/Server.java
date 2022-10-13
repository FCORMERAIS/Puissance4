package puissance4.project;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
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
                Listen(clientSocket);
            }
        }catch (IOException e) {
            System.err.println(e.toString());
        }
        Player playerPlay = PlayerAleatoy(numberPlayer);
        Grid grid = new Grid(numberPlayer);
        while(!Verify.Win(grid.grille)&& !Verify.Egality(grid.grille)) {
            Display.printGrid(grid.grille);
            Display.chooseWherePlay(grid.grille,playerPlay);
            playerPlay = NextPlayer(numberPlayer, playerPlay);
        }
        for (SocketChannel socketChannel : listClient) {
            broadcast("La partie est maintenant terminé ! ",socketChannel);
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

    static void Listen(SocketChannel clientSocket) throws IOException {
        ByteBuffer bytes = ByteBuffer.allocate(1024);
        int bytesRead = clientSocket.read(bytes);
        if (bytesRead <= 0 ) {
            clientSocket.close();
            return;
        }
        String message = new String(bytes.array(),"UTF-8");
        System.out.println(message);
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