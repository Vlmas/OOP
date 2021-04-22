package lab3.intvsabs;

public class Laptop implements Pluggable {
    private int batteryChargeLevel;

    {
        batteryChargeLevel = Pluggable.FULL_CHARGE;
    }

    public Laptop() {}

    @Override
    public void charge() {
        batteryChargeLevel = Pluggable.FULL_CHARGE;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + getBatteryChargeLevel();
    }

    public int getBatteryChargeLevel() {
        return batteryChargeLevel;
    }
}
