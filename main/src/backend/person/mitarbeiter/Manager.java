package person.mitarbeiter;

import person.MitarbeiterTyp;

public class Manager extends BueroArbeiter {

    private double bonussatz;

    public Manager(int id, String name, double festgehalt, double bonussatz) {
        super(id, name, festgehalt);
        setMitarbeiterTyp(MitarbeiterTyp.MANAGER);
        setBonussatz(bonussatz);
    }

    public double berechneBonus() {
        return getFestgehalt() * (getBonussatz() / 100);
    }

    public double getBonussatz() {
        return bonussatz;
    }

    public void setBonussatz(double bonussatz) {
        if(bonussatz >= 0) {
            this.bonussatz = bonussatz;
        } else {
            throw new IllegalArgumentException("Bonusgehalt has to be positive.");
        }
    }

    @Override
    public String toString() {
        return String.format("Name: %s, ID: %s, Typ: %s, Festgehalt: %s, Bonussatz: %s",
                getName(),
                getId(),
                getTyp(),
                getFestgehalt(),
                getBonussatz());
    }

    @Override
    public double einkommen() {
        return berechneBonus() * getFestgehalt();
    }
}
