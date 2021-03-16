package lab.second.shape;

public class Cylinder extends Shape {
    private float height;
    private float baseRadius;

    public Cylinder() {}

    public Cylinder(float height, float baseRadius) {
        this.height = height;
        this.baseRadius = baseRadius;
    }

    @Override
    public float volume() {
        return (float) (height * Math.PI * baseRadius * baseRadius);
    }

    @Override
    public float surfaceArea() {
        return (float) (2 * Math.PI * baseRadius * (baseRadius + height));
    }
}