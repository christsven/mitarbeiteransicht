package com.itf201.mitarbeiteransicht.rollenspiel.template.weapons;


import java.util.Random;

public class TemplateAxe extends TemplateWeaponBehavior {

    Random random = new Random();

    public TemplateAxe() {
        super("Axt", 2);
    }

    @Override
    boolean prepareWeapon() {
        return random.nextInt(100) > 10;
    }

    @Override
    boolean draw() {
        return random.nextInt(100) > 10;
    }

    @Override
    boolean aim() {
        return random.nextInt(100) > 10;
    }

    @Override
    boolean strike() {
        return random.nextInt(100) > 20;
    }

    @Override
    boolean holster() {
        return random.nextInt(100) > 5;
    }
}
