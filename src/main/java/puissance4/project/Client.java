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
            String message = "Insulte la daronne a Jules si jamais tu voit ce message";
            ByteBuffer bytes = ByteBuffer.wrap(message.getBytes("UTF-8"));
            while(bytes.hasRemaining()) {
                clientSocket.write(bytes);
            }
            Listen(clientSocket);
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
}