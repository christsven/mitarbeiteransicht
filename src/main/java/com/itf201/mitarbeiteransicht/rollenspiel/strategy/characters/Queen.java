package com.itf201.mitarbeiteransicht.rollenspiel.strategy.characters;

import com.itf201.mitarbeiteransicht.rollenspiel.strategy.weapons.WeaponBehavior;

public class Queen extends Character {

    public Queen(WeaponBehavior weaponBehavior) {
        setWeapon(weaponBehavior);
    }

    @Override
    public void fight() {
        System.out.println("Königin verwendet Waffe: " + currentWeaponBehavior.useWeapon());
    }

}