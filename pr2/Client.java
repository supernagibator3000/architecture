import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private Client() {}

    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.getRegistry(8080);
            Calculator calculator = (Calculator) registry.lookup("Calculator");

            System.out.println("a=1, b=6, c=2");
            printResult(calculator.solve(1, 6, 2));
            System.out.println("a=1, b=6, c=9");
            printResult(calculator.solve(1, 6, 9));
            System.out.println("a=10, b=6, c=9");
            printResult(calculator.solve(10, 6, 9));
        } catch (Exception e){
            System.err.println("Client exeption: " + e.toString());
            e.printStackTrace();
        }
    }

    private static void printResult(Result result){
        Double firstValue = result.getFirstValue();
        Double secondValue = result.getSecondValue();
        if (secondValue != Double.POSITIVE_INFINITY){
            System.out.println("x1=" + firstValue + "\nx2=" + secondValue);
        }
        else if (firstValue != Double.POSITIVE_INFINITY){
            System.out.println("x=" + firstValue);
        }
        else {
            System.out.println("There is no solution");
        }
        System.out.println('\n');
    }
}
