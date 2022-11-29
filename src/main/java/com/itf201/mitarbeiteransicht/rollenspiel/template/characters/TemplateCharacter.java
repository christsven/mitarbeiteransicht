package com.itf201.mitarbeiteransicht.rollenspiel.template.characters;


import com.itf201.mitarbeiteransicht.rollenspiel.template.weapons.TemplateWeaponBehavior;

public abstract class TemplateCharacter {

    final String name;

    TemplateWeaponBehavior currentWeaponBehavior;

    protected TemplateCharacter(final String name) {
        this.name = name;
    }

    public abstract void fight();

    public void setWeapon(TemplateWeaponBehavior weaponBehavior) {
        if (weaponBehavior == null) throw new NullPointerException("WeaponBehavior cannot be null.");
        currentWeaponBehavior = weaponBehavior;
        System.out.printf("%s wechselte zu %s.%n", name, currentWeaponBehavior.getName());
    }
}
