package com.itf201.mitarbeiteransicht.aixcuisine.object;


import com.itf201.mitarbeiteransicht.aixcuisine.shape.AbstractShape;

public abstract class GroundShapeObject extends AbstractObject {

    private final AbstractShape groundShape;

    private double height;

    public GroundShapeObject(int id, AbstractShape shape, double height) {
        super(id);
        this.groundShape = shape;
        setHeight(height);
    }

    public AbstractShape getGroundShape() {
        return groundShape;
    }

    public double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        this.height = height;
        onParametersChanged();
    }
}