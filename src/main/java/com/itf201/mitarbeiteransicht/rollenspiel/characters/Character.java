package com.itf201.mitarbeiteransicht.rollenspiel.characters;

import com.itf201.mitarbeiteransicht.rollenspiel.weapons.WeaponBehavior;

public abstract class Character {

    WeaponBehavior currentWeaponBehavior;

    public abstract void fight();

    public void setWeapon(WeaponBehavior weaponBehavior) {
        if (weaponBehavior == null) throw new NullPointerException("WeaponBehaviour cannot be null.");
        currentWeaponBehavior = weaponBehavior;
    }

}
