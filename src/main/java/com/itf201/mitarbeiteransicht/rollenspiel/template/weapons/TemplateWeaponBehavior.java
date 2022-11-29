package com.itf201.mitarbeiteransicht.rollenspiel.template.weapons;

public abstract class TemplateWeaponBehavior {

    final String name;

    final int attackCount;

    protected TemplateWeaponBehavior(final String name, final int attackCount) {
        this.name = name;
        this.attackCount = attackCount;
    }

    public String getName() {
        return name;
    }

    public void useWeapon(final String attackerName) {
        if (draw() && prepareWeapon()) {
            print("%s hat %s gezogen.", attackerName, name);
            for (int i = 0; i < attackCount; i++) {
                print("%s hat noch %s Angriffe.", attackerName, attackCount - i);
                if (aim()) {
                    print("%s visiert erfolgreich an.", attackerName);
                    if (strike()) print("%s hat den Feind getroffen!", attackerName);
                    else print("%s hat den Feind vefehlt!", attackerName);
                } else print("%s kann kein Ziel finden.", attackerName);
            }
            if (holster()) print("%s holstert %s.", attackerName, name);
            else print("%s hält %s weiter in der Hand.", attackerName, name);
        } else print("%s ist das Ziehen der Waffe misslungen.", attackerName);
        print("%s beendet den Zug.", attackerName);
        System.out.println("***************************************");
    }

    abstract boolean prepareWeapon();

    abstract boolean draw();

    abstract boolean aim();

    abstract boolean strike();

    abstract boolean holster();

    private void print(String pattern, Object... arguments) {
        System.out.printf(pattern.concat("%n"), arguments);
    }
}
