package com.itf201.mitarbeiteransicht.rollenspiel.strategy.characters;

import com.itf201.mitarbeiteransicht.rollenspiel.strategy.weapons.WeaponBehavior;

public class Troll extends Character {

    public Troll(WeaponBehavior weaponBehavior) {
        setWeapon(weaponBehavior);
    }

    @Override
    public void fight() {
        System.out.println("Troll verwendet Waffe: " + currentWeaponBehavior.useWeapon());
    }
}