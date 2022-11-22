package com.itf201.mitarbeiteransicht.rollenspiel.characters;

import com.itf201.mitarbeiteransicht.rollenspiel.weapons.WeaponBehavior;

public class Queen extends Character {

    public Queen(WeaponBehavior weaponBehavior) {
        setWeapon(weaponBehavior);
    }

    @Override
    public void fight() {
        System.out.println("Königin verwendet Waffe: " + currentWeaponBehavior.useWeapon());
    }

}