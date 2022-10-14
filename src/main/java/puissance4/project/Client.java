package puissance4.project;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    /**
     * this method use for connect the client to the server
     * @param numberPlayer it's the number of players who's want to play
     */
    public static void LaunchClient() {
        try {
            SocketChannel clientSocket = SocketChannel.open();
            clientSocket.connect(new InetSocketAddress("localhost", 4004));
            int nbPlayer2 = Integer.parseInt(String.valueOf(Listen(clientSocket).charAt(0)));
            Grid grille = new Grid(nbPlayer2); // we create the grid for each client
            Display.printGrid(grille.grille);// we show the grid
            while(!Verify.Egality(grille.grille) && !Verify.Win(grille.grille)) { // we played while nobody has won and there is no egality
                String Turn = Listen(clientSocket);// we take the message from the server
                if (Turn.charAt(0) == 'Y') { // if the first carachter of the message from the server is Y that mean is our turn
                    System.out.println(ConsoleColors.BLUE_UNDERLINED+"ITS YOUR TURN ! "+ConsoleColors.RESET);
                    String choose = Display.chooseWherePlay(grille.grille); 
                    String message = "Turn " + Turn.charAt(10) +" "+ choose;// we create a message with the index that the client have played and with the Symbol that represent the player
                    ByteBuffer bytes = ByteBuffer.wrap(message.getBytes("UTF-8"));
                    while(bytes.hasRemaining()) {// we send all the message to the server
                        clientSocket.write(bytes);
                    }
                }
                String Message = Listen(clientSocket);// we lissen for a message from the server. the message is the played that have been 
                Display.played(grille.grille,String.valueOf(Message.charAt(5)), String.valueOf(Message.charAt(7))); // we update the grid
                Display.printGrid(grille.grille);// and we shos the grid
            }
        }catch (IOException e) {
            System.err.println(e.toString());
        }
    }

    /**
     * this method is for take a message that the server send
     * @param clientSocket it's the clientSocket of the server
     * @return we return the string that the socket have recieved
     * @throws IOException
     */
    public static String Listen(SocketChannel clientSocket) throws IOException {
        ByteBuffer bytes = ByteBuffer.allocate(1024);
        int bytesRead = clientSocket.read(bytes);
        if (bytesRead <= 0 ) {
            clientSocket.close();
            return "";
        }
        String message = new String(bytes.array(),"UTF-8");
        return message;
    }
}