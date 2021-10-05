import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    Result solve(double a, double b, double c) throws RemoteException;
}
