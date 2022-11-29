package com.itf201.mitarbeiteransicht.rollenspiel.template.characters;

import com.itf201.mitarbeiteransicht.rollenspiel.template.weapons.TemplateWeaponBehavior;

public class TemplateTroll extends TemplateCharacter {

    public TemplateTroll(TemplateWeaponBehavior weaponBehavior) {
        super("Troll");
        setWeapon(weaponBehavior);
    }

    @Override
    public void fight() {
        currentWeaponBehavior.useWeapon(this.name);
    }

}