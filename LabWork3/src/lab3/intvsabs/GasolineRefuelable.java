package lab3.intvsabs;

public interface GasolineRefuelable {
    int EMPTY = 0;
    int PARTIAL = 1;
    int FULL = 2;

    void refuel();
}
