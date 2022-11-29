package object;

import shape.Triangle;

public class TrianglePrism extends Prism {

    public TrianglePrism(int id, Triangle shape, double height) {
        super(id, shape, height);
    }

    @Override
    double getCircumferenceOfGroundShape() {
        Triangle triangle = (Triangle) getGroundShape();
        return triangle.getCircumference();
    }
}
