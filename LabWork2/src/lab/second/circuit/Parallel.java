package lab.second.circuit;

public class Parallel extends Circuit {
    private Circuit circuit1;
    private Circuit circuit2;

    public Parallel() {}

    public Parallel(Circuit circuit1, Circuit circuit2) {
        this.circuit1 = circuit1;
        this.circuit2 = circuit2;
    }

    @Override
    public double getResistance() {
        return ((circuit1.getResistance() * circuit2.getResistance()) / (circuit1.getResistance() + circuit2.getResistance()));
    }

    @Override
    public double getPotentialDiff() {
        return circuit1.getPotentialDiff();
    }

    @Override
    public void applyPotentialDiff(double volts) {
        circuit1.applyPotentialDiff(volts);
        circuit2.applyPotentialDiff(volts);
    }
}
