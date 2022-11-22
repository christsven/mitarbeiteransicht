package com.itf201.mitarbeiteransicht.rollenspiel.characters;

import com.itf201.mitarbeiteransicht.rollenspiel.weapons.WeaponBehavior;

public class Troll extends Character {

    public Troll(WeaponBehavior weaponBehavior) {
        setWeapon(weaponBehavior);
    }

    @Override
    public void fight() {
        System.out.println("Troll verwendet Waffe: " + currentWeaponBehavior.useWeapon());
    }
}