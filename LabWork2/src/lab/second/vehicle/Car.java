package lab.second.vehicle;

public class Car extends Vehicle {
    public Car() {}

    public Car(Brand brand, float length, float width, float height, float weight, float maxSpeed) {
        super(brand, length, width, height, weight, maxSpeed);
    }

    @Override
    public void honk() {
        System.out.println("BEEP");
    }
}
