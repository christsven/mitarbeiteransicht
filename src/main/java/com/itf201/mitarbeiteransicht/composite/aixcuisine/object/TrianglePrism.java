package com.itf201.mitarbeiteransicht.composite.aixcuisine.object;

import com.itf201.mitarbeiteransicht.composite.aixcuisine.shape.Triangle;

public class TrianglePrism extends Prism {

    public TrianglePrism(int id, Triangle shape, double height) {
        super(id, shape, height);
    }

    @Override
    double getCircumferenceOfGroundShape() {
        return ((Triangle) getGroundShape()).getCircumference();
    }
}
