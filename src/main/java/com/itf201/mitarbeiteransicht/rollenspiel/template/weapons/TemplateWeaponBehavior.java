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
            System.out.printf("%s hat %s gezogen.%n", attackerName, name);
            for (int i = 0; i < attackCount; i++) {
                System.out.printf("%s hat noch %s Angriffe.%n", attackerName, attackCount - i);
                if (aim()) {
                    System.out.printf("%s visiert erfolgreich an.%n", attackerName);
                    if (strike()) {
                        System.out.printf("%s hat den Feind getroffen!%n", attackerName);
                    } else {
                        System.out.printf("%s hat den Feind vefehlt!%n", attackerName);
                    }
                } else {
                    System.out.printf("%s kann kein Ziel finden.%n", attackerName);
                }
            }
            if (holster()) {
                System.out.printf("%s holstert %s.%n", attackerName, name);
            } else {
                System.out.printf("%s hält %s weiter in der Hand.%n", attackerName, name);
            }
        } else {
            System.out.printf("%s ist das Ziehen der Waffe misslungen.%n", attackerName);
        }
        System.out.printf("%s beendet den Zug.%n", attackerName);
        System.out.println("***************************************");
    }

    abstract boolean prepareWeapon();

    abstract boolean draw();

    abstract boolean aim();

    abstract boolean strike();

    abstract boolean holster();
}
