package object;

import shape.AbstractShape;

public abstract class Prism extends GroundShapeObject {

    public Prism(int id, AbstractShape shape, double height) {
        super(id, shape, height);
    }

    @Override
    void calculateSurface() {
        setSurface(2 * getGroundShape().getArea() + getCircumferenceOfGroundShape() * getHeight());
    }

    @Override
    void calculateVolume() {
        setVolume(getGroundShape().getArea() * getHeight());
    }

    abstract double getCircumferenceOfGroundShape();

}