package com.itf201.mitarbeiteransicht.composite.aixcuisine.object;

import com.itf201.mitarbeiteransicht.composite.aixcuisine.shape.Circle;

public class CirclePyramid extends Pyramid {

    public CirclePyramid(final int id, Circle shape, double height) {
        super(id, shape, height);
    }

    @Override
    double getLateralSurface() {
        return Math.sqrt(getHeight() * getHeight()
                + ((Circle) getGroundShape()).getRadius()
                * ((Circle) getGroundShape()).getRadius());
    }
}
