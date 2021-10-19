import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Message {
    private LinkedList<String> storage = new LinkedList<>();

    public void addMessage(String message) {
        storage.add(message);
    }

    public void printMessage(BufferedWriter writer) {
        if(storage.size() > 0) {
            try {
                for (String message : storage) {
                    writer.write(message + "\n");
                }
                writer.flush();
            } catch (IOException ignored) {}
        }
    }

    public void clear(){
        storage.clear();
    }
}