package object;

import shape.Circle;

public class CirclePrism extends Prism {

    public CirclePrism(int id, Circle shape, double height) {
        super(id, shape, height);
    }

    @Override
    double getCircumferenceOfGroundShape() {
        Circle circle = (Circle) getGroundShape();
        return circle.getCircumference();
    }
}
