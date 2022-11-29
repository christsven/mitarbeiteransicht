package com.itf201.mitarbeiteransicht.rollenspiel.strategy.characters;


import com.itf201.mitarbeiteransicht.rollenspiel.strategy.weapons.WeaponBehavior;

public abstract class Character {

    WeaponBehavior currentWeaponBehavior;

    public abstract void fight();

    public void setWeapon(WeaponBehavior weaponBehavior) {
        if (weaponBehavior == null) throw new NullPointerException("WeaponBehaviour cannot be null.");
        currentWeaponBehavior = weaponBehavior;
    }

}
