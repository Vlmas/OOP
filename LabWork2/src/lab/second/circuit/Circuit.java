package lab.second.circuit;

public abstract class Circuit {
    public Circuit() {}

    public abstract double getResistance();
    public abstract double getPotentialDiff();
    public abstract void applyPotentialDiff(double volts);

    public double getPower() {
        return getCurrent() * getPotentialDiff();
    }

    public double getCurrent() {
        return getPotentialDiff() / getResistance();
    }
}
