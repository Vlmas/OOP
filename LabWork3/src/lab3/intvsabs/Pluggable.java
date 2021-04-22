package lab3.intvsabs;

public interface Pluggable {
    int UNCHARGED = 0;
    int PARTIAL = 1;
    int FULL_CHARGE = 2;


    void charge();
}
