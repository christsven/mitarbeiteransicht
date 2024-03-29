package com.itf201.mitarbeiteransicht.composite.aixcuisine.object;

import com.itf201.mitarbeiteransicht.composite.aixcuisine.shape.AbstractShape;

public abstract class Prism extends GroundShapeObject {

    public Prism(final int id, AbstractShape shape, double height) {
        super(id, shape, height);
    }

    @Override
    void calculateSurface() {
        setSurface(2 * getGroundShape().getArea() + getCircumferenceOfGroundShape() * getHeight());
    }

    @Override
    void calculateVolume() {
        setVolume(getGroundShape().getArea() * getHeight());
    }

    abstract double getCircumferenceOfGroundShape();

}