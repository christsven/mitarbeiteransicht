package com.itf201.mitarbeiteransicht.rollenspiel.characters;

import com.itf201.mitarbeiteransicht.rollenspiel.weapons.WeaponBehavior;

public class King extends Character {

    public King(WeaponBehavior weaponBehavior) {
        setWeapon(weaponBehavior);
    }

    @Override
    public void fight() {
        System.out.println("König verwendet Waffe: " + currentWeaponBehavior.useWeapon());
    }

}
