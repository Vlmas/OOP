package lab.second.vehicle;

import java.util.Objects;

public class Tank extends Vehicle {
    private String cannon;

    public Tank() {}

    public Tank(Brand brand, float length, float width, float height, float weight, float maxSpeed, String cannon) {
        super(brand, length, width, height, weight, maxSpeed);
        this.cannon = cannon;
    }

    @Override
    public void honk() {
        System.out.println("BAH!!");
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        Tank tank = (Tank) obj;

        return cannon.equals(tank.cannon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cannon);
    }
}