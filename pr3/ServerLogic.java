import java.io.*;
import java.net.Socket;

public class ServerLogic extends Thread{
    private final Socket serverSocket;
    private final BufferedReader input;
    private final BufferedWriter output;

    public ServerLogic(Socket serverSocket) throws IOException {
        this.serverSocket = serverSocket;
        input = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        output = new BufferedWriter(new OutputStreamWriter(serverSocket.getOutputStream()));
        Server.message.printMessage(output);
        start();
    }

    @Override
    public void run() {
        String word;
        try {
            word = input.readLine();
            try {
                output.write(word + "\n");
                output.flush();
            } catch (IOException ignored) {}
            try {
                new Sender(Server.message, output).start();
                while (true) {
                    word = input.readLine();
//                    System.out.println(word);
                    if(word.equals("stop")) {
                        for (ServerLogic vr : Server.serverList) {
                            Server.message.printMessage(vr.output);
                        }
                        this.ServiceStop();
                        break;
                    }
                    Server.message.addMessage(word);
                }
            } catch (NullPointerException ignored) {}
        } catch (IOException e) {
            this.ServiceStop();
        }
    }

    private void ServiceStop() {
        try {
            if(!serverSocket.isClosed()) {
                serverSocket.close();
                input.close();
                output.close();
                for (ServerLogic vr : Server.serverList) {
                    if(vr.equals(this)) vr.interrupt();
                    Server.serverList.remove(this);
                }
            }
        } catch (IOException ignored) {}
    }

    private static class Sender extends Thread {
        Message message;
        BufferedWriter writer;

        public Sender(Message message, BufferedWriter writer) {
            this.message = message;
            this.writer = writer;
        }

        @Override
        public void run() {
            try {
                while(true) {
                    for (ServerLogic serverLogic : Server.serverList){
                        Server.message.printMessage(serverLogic.output);
                    }
                    message.clear();
                    Thread.sleep(5000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}