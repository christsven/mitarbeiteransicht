package person.mitarbeiter;

import person.MitarbeiterTyp;

public class SchichtArbeiter extends Mitarbeiter {

    private double stundenSatz;
    private int anzahlStunden;

    public SchichtArbeiter(int id, String name, double stundenSatz, int anzahlStunden) {
        super(MitarbeiterTyp.SCHICHTARBEITER, id, name);
        setStundensatz(stundenSatz);
        setAnzahlStunden(anzahlStunden);
    }

    @Override
    public double einkommen() {
        return stundenSatz * anzahlStunden;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, ID: %s, Typ: %s, Stunden: %s, Stundensatz: %s.",
                getName(),
                getId(),
                getTyp(),
                getAnzahlStunden(),
                getStundenSatz());
    }

    public int getAnzahlStunden() {
        return anzahlStunden;
    }

    public double getStundenSatz() {
        return stundenSatz;
    }

    public void setStundensatz(double stundenSatz) {
        if (stundenSatz >= 0) {
            this.stundenSatz = stundenSatz;
        } else {
            throw new IllegalArgumentException("Stundensatz has to be positive.");
        }
    }

    public void setAnzahlStunden(int anzahlStunden) {
        if (anzahlStunden >= 0) {
            this.anzahlStunden = anzahlStunden;
        } else {
            throw new IllegalArgumentException("anzahlStunden has to be positive.");
        }
    }
}
