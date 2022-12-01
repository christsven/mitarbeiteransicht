package com.itf201.mitarbeiteransicht.composite.aixcuisine.object;

import com.itf201.mitarbeiteransicht.composite.aixcuisine.shape.Circle;

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
