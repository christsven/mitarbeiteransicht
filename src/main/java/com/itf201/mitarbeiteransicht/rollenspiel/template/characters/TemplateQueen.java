package com.itf201.mitarbeiteransicht.rollenspiel.template.characters;

import com.itf201.mitarbeiteransicht.rollenspiel.template.weapons.TemplateWeaponBehavior;

public class TemplateQueen extends TemplateCharacter {

    public TemplateQueen(TemplateWeaponBehavior weaponBehavior) {
        super("Königin");
        setWeapon(weaponBehavior);
    }

    @Override
    public void fight() {
        currentWeaponBehavior.useWeapon(this.name);
    }

}