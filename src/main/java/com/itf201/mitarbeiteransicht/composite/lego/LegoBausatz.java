package com.itf201.mitarbeiteransicht.composite.lego;

import java.util.List;

public class LegoBausatz implements LegoBauteil {

    private final List<LegoBauteil> bricks;

    private final String name;

    public LegoBausatz(final String name, final List<LegoBauteil> bricks) {
        this.bricks = bricks;
        this.name = name;
    }

    public void addBrick(final LegoBauteil brick) {
        if (brick == null) throw new NullPointerException();
        bricks.add(brick);
    }

    public void removeBrick(final LegoBauteil brick) {
        if (brick == null) throw new NullPointerException();
        bricks.remove(brick);
    }

    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return bricks.stream().map(LegoBauteil::getPrice).reduce(0.0, Double::sum);
    }
}
