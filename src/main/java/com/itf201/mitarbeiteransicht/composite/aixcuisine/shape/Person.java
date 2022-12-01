package com.itf201.mitarbeiteransicht.composite.aixcuisine.shape;

import java.util.ArrayList;
import java.util.List;

public class Person extends AbstractShape {

    private final List<AbstractShape> parts;

    public Person() {
        parts = new ArrayList<>();
        parts.add(new Circle(10));
        parts.add(new Circle(3));
        parts.add(new Rectangle(1, 1));
        for (int i = 0; i < 4; i++) parts.add(new Rectangle(4, 1));
        onParametersChanged();
    }

    @Override
    protected void onParametersChanged() {
        setArea(parts.stream().map(AbstractShape::getArea).reduce(0.0, Double::sum));
    }
}
