package lab3.intvsabs;

public class GasolineCar extends Vehicle implements GasolineRefuelable {
    private int fuelTankLevel;

    {
        fuelTankLevel = GasolineRefuelable.FULL;
    }

    public GasolineCar() {}

    public GasolineCar(Brand brand, float length, float width, float height, float weight, float maxSpeed) {
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
}