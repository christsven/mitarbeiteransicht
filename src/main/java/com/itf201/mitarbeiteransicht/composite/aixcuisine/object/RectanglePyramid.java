package com.itf201.mitarbeiteransicht.composite.aixcuisine.object;

import com.itf201.mitarbeiteransicht.composite.aixcuisine.shape.Rectangle;

public class RectanglePyramid extends Pyramid {

    public RectanglePyramid(final int id, Rectangle shape, double height) {
        super(id, shape, height);
    }

    @Override
    double getLateralSurface() {
        Rectangle shape = (Rectangle) getGroundShape();
        return shape.getLength() * shape.getHeight() + 0.5 * getHeight();
    }
}
