package lab3.movable;

public class Whale implements Swimmable {
    private int sailing;

    {
        sailing = 0;
    }

    public Whale() {}

    public int getSailing() {
        return sailing;
    }

    public void setSailing(int sailing) {
        this.sailing = sailing;
    }

    @Override
    public void move() {
        sailing += 5;
    }

    @Override
    public void swim() {
        sailing += 100;
    }
}
