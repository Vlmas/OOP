package lab3.intvsabs;

public class ElectricCar extends Vehicle implements Pluggable {
    private int batteryChargeLevel;

    {
        batteryChargeLevel = Pluggable.FULL_CHARGE;
    }

    public ElectricCar() {}

    public ElectricCar(Brand brand, float length, float width, float height, float weight, float maxSpeed) {
        super(brand, length, width, height, weight, maxSpeed);
    }

    @Override
    public void honk() {
        System.out.println("BEEP");
    }

    @Override
    public void charge() {
        batteryChargeLevel = Pluggable.PARTIAL;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + getBatteryChargeLevel();
    }

    public int getBatteryChargeLevel() {
        return batteryChargeLevel;
    }
}
