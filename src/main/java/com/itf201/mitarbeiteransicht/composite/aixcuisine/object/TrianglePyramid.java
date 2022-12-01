package com.itf201.mitarbeiteransicht.composite.aixcuisine.object;

import com.itf201.mitarbeiteransicht.composite.aixcuisine.shape.Triangle;

public class TrianglePyramid extends Pyramid {

    public TrianglePyramid(int id, Triangle shape, double height) {
        super(id, shape, height);
    }

    @Override
    double getLateralSurface() {
        return ((Triangle) getGroundShape()).getA()
                * ((Triangle) getGroundShape()).getB()
                * ((Triangle) getGroundShape()).getC()
                + 0.5 * getHeight();
    }
}
