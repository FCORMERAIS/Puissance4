package puissance4.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void LunchClient(int numberPlayer) {
        Grid grille = new Grid(numberPlayer);
        try {
            SocketChannel clientSocket = SocketChannel.open();
            clientSocket.connect(new InetSocketAddress("localhost", 4004));
            while(!Verify.Egality(grille.grille) && !Verify.Win(grille.grille)) {
                String Turn = Listen(clientSocket);
                if (Turn.charAt(0) == 'Y') {
                    System.out.println(ConsoleColors.BLUE_UNDERLINED+"ITS YOUR TURN ! "+ConsoleColors.RESET);
                    int choose = Display.chooseWherePlay(grille.grille);
                    String message = "Turn" + " X "+ Integer.toString(choose);
                    ByteBuffer bytes = ByteBuffer.wrap(message.getBytes("UTF-8"));
                    while(bytes.hasRemaining()) {
                        clientSocket.write(bytes);
                    }
                }else {
                    System.out.println(Turn);
                }
                String Message = Listen(clientSocket);
                Display.played(grille.grille,String.valueOf(Message.charAt(5)), Integer.parseInt(String.valueOf(Message.charAt(7))));
                Display.printGrid(grille.grille);
            }
        }catch (IOException e) {
            System.err.println(e.toString());
        }
    }

    public static String promptForString(){
        InputStreamReader bis = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(bis);
        try {
            return br.readLine();
        }
        catch(IOException e){
            System.err.println("Something went wrong : " + e.getMessage());
            System.err.println("Please retry : ");
            return promptForString();
        }
    }

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