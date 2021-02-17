package pack;

public class Data {
    private double sum;
    private double maximum;
    private int count;

    public Data() {
        maximum=-1e18;
    }

    public void add(double value) {
        if(value>maximum) {
            maximum=value;
        }
        sum+=value;
        count++;
    }

    public double getAverage() {
        if(count==0) {
            return 0;
        } else {
            return sum/count;
        }
    }

    public String getMaximum() {
        return (count!=0)?Double.toString(maximum):"No value was added!";
    }
}