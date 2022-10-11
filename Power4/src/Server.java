import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;


public class Server {
    int number = 2;
    Grid grid = new Grid(number);
    ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.launch();
        if (server.number == 3) {
            while(!Verify.Win(server.grid.grille)) {
                Display.printGrid(server.grid.grille);
                server.chooseWherePlayX(server.grid.grille);
                Display.printGrid(server.grid.grille);
                server.chooseWherePlayV(server.grid.grille);
                Display.printGrid(server.grid.grille);
                server.chooseWherePlayO(server.grid.grille);
            }
        }else {
            while(!Verify.Win(server.grid.grille)) {
                Display.printGrid(server.grid.grille);
                server.chooseWherePlayX(server.grid.grille);
                Display.printGrid(server.grid.grille);
                server.chooseWherePlayO(server.grid.grille);
            }
        } 
    }

    private void chooseWherePlayX(ArrayList<ArrayList<String>> grille) {
        for (ClientHandler client : clients) {
            if (client.player == "X") {
                client.chooseWherePlay(grille);
            }
        }
    }

    private void launch(){
        try {
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            serverSocket.bind(new InetSocketAddress(8000));
            while(true){
                SocketChannel clientSocket = serverSocket.accept();
                ClientHandler client = new ClientHandler(clientSocket,this);
                clients.add(client);
                Thread clientThread = new Thread(client);
                clientThread.start();
            }
        }catch (IOException e){
            System.err.println(e.toString());
            System.err.println("Server stopped due to unexpected exception");
        }
    }

    public void broadcast(String message, ClientHandler handler) throws IOException{
        for (ClientHandler client : clients) {
            if(client != handler){
                client.send(message);
            }
        }
    }
}
