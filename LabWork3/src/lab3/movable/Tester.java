package lab3.movable;

public class Tester {
    public static void main(String[] args) {
        Swimmable whale = new Whale();
        Runnable human = new Human();

        whale.swim();
        whale.move();
        human.run();
        human.move();

        System.out.println(((Whale) whale).getSailing());
        System.out.println(((Human) human).getStepCount());
    }
}
