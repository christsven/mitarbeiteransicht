package object;

public class Sphere extends AbstractObject {

    private double radius;

    public Sphere(int id, double radius) {
        super(id);
        setRadius(radius);
    }

    public void setRadius(double radius) {
        this.radius = radius;
        onParametersChanged();
    }

    @Override
    void calculateVolume() {
        setVolume((4 / 3) * Math.PI * radius * radius * radius);
    }

    @Override
    void calculateSurface() {
        setSurface(4 * Math.PI * radius * radius);
    }

}