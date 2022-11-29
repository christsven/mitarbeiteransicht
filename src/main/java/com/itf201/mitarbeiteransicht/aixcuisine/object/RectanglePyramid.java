package object;

import shape.Rectangle;

public class RectanglePyramid extends Pyramid {

    public RectanglePyramid(int id, Rectangle shape, double height) {
        super(id, shape, height);
    }

    @Override
    double getLateralSurface() {
        Rectangle shape = (Rectangle) getGroundShape();
        return shape.getLength()
                * shape.getHeight() //width of rectangle base
                + 0.5 * getHeight();
    }
}
