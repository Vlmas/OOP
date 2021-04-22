package lab3.intvsabs;

public class Tester {
    public static void main(String[] args) {
        Pluggable car = new ElectricCar();
        Pluggable laptop = new Laptop();
        Pluggable hybrid = new HybridCar();

        Pluggable[] pluggables = {car, laptop, hybrid};

        for(Pluggable pluggable : pluggables) {
            pluggable.charge();
            System.out.println(pluggable);
        }
    }
}