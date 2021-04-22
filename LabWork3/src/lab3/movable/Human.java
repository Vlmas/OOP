package lab3.movable;

public class Human implements Runnable {
    private int stepCount;

    {
        stepCount = 0;
    }

    public Human() {}

    public int getStepCount() {
        return stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    @Override
    public void run() {
        stepCount += 1000;
    }

    @Override
    public void move() {
        stepCount += 100;
    }
}
