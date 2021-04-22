package lab3.intvsabs;

public class HybridCar extends Vehicle implements GasolineRefuelable, Pluggable {
    private int fuelTankLevel;
    private int batteryChargeLevel;

    {
        fuelTankLevel = GasolineRefuelable.FULL;
        batteryChargeLevel = Pluggable.FULL_CHARGE;
    }

    public HybridCar() {}

    public HybridCar(Brand brand, float length, float width, float height, float weight, float maxSpeed) {
        super(brand, length, width, height, weight, maxSpeed);
    }

    @Override
    public void honk() {
        System.out.println("BEEP");
    }

    @Override
    public void refuel() {
        fuelTankLevel = GasolineRefuelable.FULL;
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
