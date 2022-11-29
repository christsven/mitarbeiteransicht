package com.itf201.mitarbeiteransicht.rollenspiel.template.characters;

import com.itf201.mitarbeiteransicht.rollenspiel.template.weapons.TemplateWeaponBehavior;

public class TemplateKing extends TemplateCharacter {

    public TemplateKing(TemplateWeaponBehavior weaponBehavior) {
        super("König");
        setWeapon(weaponBehavior);
    }

    @Override
    public void fight() {
        currentWeaponBehavior.useWeapon(this.name);
    }

}
