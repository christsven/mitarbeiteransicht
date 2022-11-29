package com.itf201.mitarbeiteransicht.aixcuisine.object;

import com.itf201.mitarbeiteransicht.aixcuisine.shape.Circle;

public class CirclePyramid extends Pyramid {

    public CirclePyramid(int id, Circle shape, double height) {
        super(id, shape, height);
    }

    @Override
    double getLateralSurface() {
        Circle circle = (Circle) getGroundShape();
        return Math.sqrt(getHeight() * getHeight() + circle.getRadius() * circle.getRadius());
    }
}
