import java.rmi.RemoteException;

public class CalculatorImpl implements Calculator{

    @Override
    public Result solve(double a, double b, double c) throws RemoteException {
        Result result;
        double d = b * b - 4 * a * c;

        if (d > 0){
            result = new Result(((-b + Math.sqrt(d)) / (2 * a)), ((-b - Math.sqrt(d)) / (2 * a)));
        }
        else if (d == 0){
            result = new Result((-b) / (2 * a), Double.POSITIVE_INFINITY);
        }
        else {
            result = new Result(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        }

        return result;
    }
}
