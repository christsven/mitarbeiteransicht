package com.itf201.mitarbeiteransicht.rollenspiel.strategy.characters;

import com.itf201.mitarbeiteransicht.rollenspiel.strategy.weapons.WeaponBehavior;

public class Knight extends Character {

    public Knight(WeaponBehavior weaponBehavior) {
        setWeapon(weaponBehavior);
    }

    @Override
    public void fight() {
        System.out.println("Ritter verwendet Waffe: " + currentWeaponBehavior.useWeapon());
    }

}