package lab3.sorting;

public class Chocolate implements Comparable<Chocolate> {
    private float weight;
    private String name;

    public Chocolate() {}

    public Chocolate(float weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    @Override
    public String toString() {
        return (name + ": " + weight);
    }

    @Override
    public int compareTo(Chocolate o) {
        if(weight == o.weight) {
            return 0;
        }
        return (weight > o.weight) ? 1 : -1;
    }
}
