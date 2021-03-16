package lab.second.shape;

public class Cube extends Shape {
    private float edgeLength;

    public Cube() {}

    public Cube(float edgeLength) {
        this.edgeLength = edgeLength;
    }

    @Override
    public float volume() {
        return (edgeLength * edgeLength * edgeLength);
    }

    @Override
    public float surfaceArea() {
        return (6 * edgeLength * edgeLength);
    }
}
