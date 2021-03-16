package lab.second;

import java.util.HashSet;
import java.util.Vector;

import lab.second.vehicle.*;
import lab.second.shape.*;

public class FirstTester {
    public static void main(String[] args) {
        // Problem 1
        /*
        Shape cylinder = new Cylinder(4, 3);
        Shape sphere = new Sphere(5);
        Shape cube = new Cube(7);

        Vector<Shape> shapes = new Vector<>();
        shapes.add(cylinder);
        shapes.add(sphere);
        shapes.add(cube);

        for(Shape shape : shapes) {
            System.out.println("Shape " + shape.getClass().getSimpleName() + "'s volume and surface area are " + shape.volume() + ", " + shape.surfaceArea());
        }
        */

        // Problem 2

        Tank tank1 = new Tank(Brand.M1, 7.9f, 3.7f, 2.4f, 60, 72, "M1A1");
        Tank tank2 = new Tank(Brand.M1, 7.9f, 3.7f, 2.4f, 60, 72, "M1A1");
        Tank tank3 = new Tank(Brand.BUSHMAN, 7.5f, 3.8f, 2.5f, 56, 80, "M1A1");
        Tank tank4 = new Tank(Brand.M1, 7.9f, 3.7f, 2.4f, 61, 70, "M1A1");
        Car car = new Car(Brand.LEXUS, 4.9f, 1.9f, 1.5f, 1.6f, 220);

        HashSet<Vehicle> vehicles = new HashSet<>();
        vehicles.add(tank1);
        vehicles.add(tank2);
        vehicles.add(tank3);
        vehicles.add(tank4);
        vehicles.add(car);

        int i = 1;

        for(Vehicle vehicle : vehicles) {
            System.out.println(i);
            i++;
            System.out.print(vehicle.getBrand() + "'s honk sound: ");
            vehicle.honk();

            if(tank1.equals(vehicle)) {
                System.out.println("This vehicle " + vehicle.getBrand() + " is equal to Tank-1");
            } else {
                System.out.println("This vehicle " + vehicle.getBrand() + " is not equal to Tank-1");
            }
        }

    }
}