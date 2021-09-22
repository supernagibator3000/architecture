public class Main {
    public static void main(String[] args) {
        Object object = new Object();
        Thread ping = new PingPong("PING", object);
        Thread pong = new PingPong("PONG", object);
        ping.start();
        pong.start();
    }
}
