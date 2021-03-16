package lab.second.shape;

public class Sphere extends Shape {
    private float radius;

    public Sphere() {}

    public Sphere(float radius) {
        this.radius = radius;
    }

    @Override
    public float volume() {
        return (float) ((4 / 3) * Math.PI * radius * radius * radius);
    }

    @Override
    public float surfaceArea() {
        return (float) (4 * Math.PI * radius * radius);
    }
}