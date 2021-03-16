package lab.second.vehicle;

import java.util.Objects;

public abstract class Vehicle {
    private Brand brand;
    private float length;
    private float width;
    private float height;
    private float weight;
    private float maxSpeed;

    public Vehicle() {}

    public Vehicle(Brand brand, float length, float width, float height, float weight, float maxSpeed) {
        this.brand = brand;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
    }

    public abstract void honk();

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Vehicle vehicle = (Vehicle) obj;

        return (this.brand == vehicle.brand && this.length == vehicle.length && this.width == vehicle.width
            && this.height == vehicle.height && this.weight == vehicle.weight
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, length, width, height, weight);
    }

    public Brand getBrand() {
        return brand;
    }

    public float getLength() {
        return length;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }
}