package object;

import shape.AbstractShape;

public abstract class Pyramid extends GroundShapeObject {

    public Pyramid(int id, AbstractShape shape, double height) {
        super(id, shape, height);
    }

    @Override
    void calculateSurface() {
        setSurface(getGroundShape().getArea() * getLateralSurface());
    }

    @Override
    void calculateVolume() {
        setVolume((getGroundShape().getArea() * getHeight()) / 3);
    }

    abstract double getLateralSurface();
}
