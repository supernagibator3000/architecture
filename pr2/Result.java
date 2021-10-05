import java.io.Serializable;

public class Result implements Serializable {
    private Double firstValue;
    private Double secondValue;

    public Result(Double firstValue, Double secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public double getFirstValue() {
        return firstValue;
    }

    public Double getSecondValue() {
        return secondValue;
    }
}
