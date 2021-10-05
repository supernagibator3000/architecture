import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public Server() {}

    public static void main(String[] args) {
        try{
            CalculatorImpl obj = new CalculatorImpl();
            Remote stub = UnicastRemoteObject.exportObject(obj, 0);
            LocateRegistry.createRegistry(8080).bind("Calculator", stub);
            System.out.println("Server ready");
            Thread.sleep(Integer.MAX_VALUE);
        } catch (Exception e){
            System.err.println("Server exeption: " + e.toString());
            e.printStackTrace();
        }
    }
}
