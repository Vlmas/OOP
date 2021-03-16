package lab.second.circuit;

public class Resistor extends Circuit {
    private double resistance;
    private double potentialDifference;

    public Resistor() {}

    public Resistor(double resistance) {
        this.resistance = resistance;
    }

    @Override
    public double getResistance() {
        return this.resistance;
    }

    @Override
    public double getPotentialDiff() {
        return this.potentialDifference;
    }

    @Override
    public void applyPotentialDiff(double volts) {
        this.potentialDifference = volts;
    }
}