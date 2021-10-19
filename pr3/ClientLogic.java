import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientLogic {
    private Socket clientSocket;
    private BufferedReader input;
    private BufferedWriter output;
    private BufferedReader inputUser;
    private String userName;

    public ClientLogic(String ip, int port) {
        try {
            this.clientSocket = new Socket(ip, port);
        } catch (IOException e) {
            System.err.println("Socket failed");
        }
        try {
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            output = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            this.setUserName();
            new ReadMessage().start();
            new WriteMessage().start();
        } catch (IOException e) {
            ClientLogic.this.stopConnection();
        }
    }

    private void setUserName() {
        System.out.print("Write your name: ");
        try {
            userName = inputUser.readLine();
            output.write("Hello " + userName + "\n");
            output.flush();
        } catch (IOException ignored) {}
    }
    
    private void stopConnection() {
        try {
            if (!clientSocket.isClosed()) {
                clientSocket.close();
                input.close();
                output.close();
            }
        } catch (IOException ignored) {}
    }
    
    private class ReadMessage extends Thread {
        @Override
        public void run() {
            String str;
            try {
                while (true) {
                    str = input.readLine();
                    if (str.equals("stop")) {
                        ClientLogic.this.stopConnection();
                        break;
                    }
                    System.out.println(str);
                }
            } catch (IOException e) {
                ClientLogic.this.stopConnection();
            }
        }
    }

    public class WriteMessage extends Thread {
        @Override
        public void run() {
            while (true) {
                String userWord;
                try {
                    Date time = new Date();
                    SimpleDateFormat dt1 = new SimpleDateFormat("hh:mm:ss");
                    userWord = inputUser.readLine();
                    if (userWord.equals("stop")) {
                        output.write("stop" + "\n");
                        ClientLogic.this.stopConnection();
                        break;
                    }
                    else {
                        output.write("(" + dt1.format(time) + ") " + userName + ": " + userWord + "\n");
                    }
                    output.flush();
                } catch (IOException e) {
                    ClientLogic.this.stopConnection();
                }
            }
        }
    }
}