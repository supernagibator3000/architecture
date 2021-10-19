import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {
    public static final int PORT = 8080;
    public static LinkedList<ServerLogic> serverList = new LinkedList<>();
    public static Message message;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        message = new Message();
        System.out.println("Server started");
        try {
            while (true) {
                Socket socket = server.accept();
                try {
                    serverList.add(new ServerLogic(socket));
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}