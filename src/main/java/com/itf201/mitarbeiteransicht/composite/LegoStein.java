package com.itf201.mitarbeiteransicht.composite;

public class LegoStein implements LegoBauteil {

    private final double price;

    private final String name;

    public LegoStein(final String name, final double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
