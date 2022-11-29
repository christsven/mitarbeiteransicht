package com.itf201.mitarbeiteransicht.rollenspiel.template.characters;

import com.itf201.mitarbeiteransicht.rollenspiel.template.weapons.TemplateWeaponBehavior;

public class TemplateKnight extends TemplateCharacter {

    public TemplateKnight(TemplateWeaponBehavior weaponBehavior) {
        super("Ritter");
        setWeapon(weaponBehavior);
    }

    @Override
    public void fight() {
        currentWeaponBehavior.useWeapon(this.name);
    }

}