package com.itf201.mitarbeiteransicht.rollenspiel.template.weapons;

import java.util.Random;

public class TemplateBow extends TemplateWeaponBehavior {

    Random random = new Random();

    public TemplateBow() {
        super("Bogen", 1);
    }

    @Override
    boolean prepareWeapon() {
        return random.nextInt(100) > 5;
    }

    @Override
    boolean draw() {
        return random.nextInt(100) > 5;
    }

    @Override
    boolean aim() {
        return random.nextInt(100) > 20;
    }

    @Override
    boolean strike() {
        return random.nextInt(100) > 50;
    }

    @Override
    boolean holster() {
        return random.nextInt(100) > 5;
    }
}
