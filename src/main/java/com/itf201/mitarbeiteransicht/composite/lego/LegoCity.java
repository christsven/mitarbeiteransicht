package com.itf201.mitarbeiteransicht.composite.lego;

import java.util.List;

public class LegoCity implements LegoBauteil {

    private final List<LegoBausatz> buildings;

    public LegoCity(final List<LegoBausatz> buildings) {
        this.buildings = buildings;
    }

    public void addBuilding(final LegoBausatz building) {
        if (building == null) throw new NullPointerException();
        buildings.add(building);
    }

    public void removeBuilding(final LegoBausatz building) {
        buildings.remove(building);
    }

    @Override
    public double getPrice() {
        return buildings.stream().map(LegoBausatz::getPrice).reduce(0.0, Double::sum);
    }

}
