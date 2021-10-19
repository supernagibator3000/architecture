public class Client {
    public static final int PORT = 8080;

    public static void main(String[] args) {
        new ClientLogic("localhost", PORT);
    }
}