package com.itf201.mitarbeiteransicht.rollenspiel.strategy.characters;

import com.itf201.mitarbeiteransicht.rollenspiel.strategy.weapons.WeaponBehavior;

public class King extends Character {

    public King(WeaponBehavior weaponBehavior) {
        setWeapon(weaponBehavior);
    }

    @Override
    public void fight() {
        System.out.println("König verwendet Waffe: " + currentWeaponBehavior.useWeapon());
    }

}
