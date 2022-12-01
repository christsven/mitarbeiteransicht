package com.itf201.mitarbeiteransicht.composite.aixcuisine.shape;

import java.util.ArrayList;
import java.util.List;

public class Star extends AbstractShape {
    private final List<AbstractShape> parts;

    public Star(double internSidelength) {
        parts = new ArrayList<>();
        parts.add(new RegularPolygon(internSidelength, 5));
        for (int i = 0; i < 5; i++) {
            parts.add(new Triangle(internSidelength, internSidelength, internSidelength));
        }
        onParametersChanged();
    }

    @Override
    protected void onParametersChanged() {
        setArea(parts.stream().map(AbstractShape::getArea).reduce(0.0, Double::sum));
    }
}
