package com.itf201.mitarbeiteransicht.rollenspiel.characters;

import com.itf201.mitarbeiteransicht.rollenspiel.weapons.WeaponBehavior;

public class Knight extends Character {

    public Knight(WeaponBehavior weaponBehavior) {
        setWeapon(weaponBehavior);
    }

    @Override
    public void fight() {
        System.out.println("Ritter verwendet Waffe: " + currentWeaponBehavior.useWeapon());
    }

}