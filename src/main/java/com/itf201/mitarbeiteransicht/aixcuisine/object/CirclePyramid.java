package object;

import shape.Circle;

public class CirclePyramid extends Pyramid{

    public CirclePyramid(int id, Circle shape, double height) {
        super(id, shape, height);
    }

    @Override
    double getLateralSurface() {
        Circle circle = (Circle) getGroundShape();
        return Math.sqrt(getHeight() * getHeight() + circle.getRadius() * circle.getRadius());
    }
}
