package object;

import shape.Triangle;

public class TrianglePyramid extends Pyramid {

    public TrianglePyramid(int id, Triangle shape, double height) {
        super(id, shape, height);
    }

    @Override
    double getLateralSurface() {
        Triangle shape = (Triangle) getGroundShape();
        return shape.getA()
                * shape.getB()
                * shape.getC()
                + 0.5 * getHeight();
    }
}
