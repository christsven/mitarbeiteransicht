package institution;

import fahrzeuge.KraftFahrZeug;
import person.MitarbeiterTyp;
import person.mitarbeiter.Manager;
import person.mitarbeiter.Mitarbeiter;
import person.mitarbeiter.SchichtArbeiter;

import java.util.List;

public class Verwaltung extends Abteilung {

    //Verwaltung als child von Abteilung hat eine eigene liste!
    private List<Mitarbeiter> gesamtpersonal;
    private List<SchichtArbeiter> schichtArbeiterList;
    private List<Abteilung> abteilungList;
    private List<KraftFahrZeug> fuhrpark;

    public Verwaltung(String name, Manager leiter) {
        super(name, leiter);
    }

    public List<Abteilung> getAbteilungList() {
        return abteilungList;
    }

    public List<KraftFahrZeug> getFuhrpark() {
        return fuhrpark;
    }

    public List<Mitarbeiter> getGesamtpersonal() {
        return gesamtpersonal;
    }

    public List<SchichtArbeiter> getSchichtArbeiterList() {
        return schichtArbeiterList;
    }

    /**
     * Fügt nicht zur Abteilungsebene, sondern zur Unternehmensebene hinzu!
     * <p>
     * Es gibt nur einen add/remove trotz zwei Listen, da es kein Szenario gibt,
     * indem ein Schichtarbeiter nicht in beiden Listen ist, da er neu erzeugt
     * werden muss bei einer "Beförderung".
     */
    public void addGesamtmitarbeiter(Mitarbeiter mitarbeiter) {
        if (!getGesamtpersonal().contains(mitarbeiter)) {
            if (mitarbeiter.getTyp() == MitarbeiterTyp.SCHICHTARBEITER) {
                getSchichtArbeiterList().add((SchichtArbeiter) mitarbeiter);
            }
            getGesamtpersonal().add(mitarbeiter);
        }
    }

    public void removeGesamtmitarbeiter(Mitarbeiter mitarbeiter) {
        if (mitarbeiter.getTyp() == MitarbeiterTyp.SCHICHTARBEITER) {
            getSchichtArbeiterList().remove((SchichtArbeiter) mitarbeiter);
        }
        getGesamtpersonal().remove(mitarbeiter);
    }

    public void addFahrzeug(KraftFahrZeug kfz) {
        if (!getFuhrpark().contains(kfz)) {
            getFuhrpark().add(kfz);
        }
    }

    public void removeFahrzeug(KraftFahrZeug kfz) {
        getFuhrpark().remove(kfz);
    }

    public void addAbteilung(Abteilung abteilung) {
        if (!getAbteilungList().contains(abteilung)) {
            getAbteilungList().add(abteilung);
        }
    }

    public void removeAbteilung(Abteilung abteilung) {
        getAbteilungList().remove(abteilung);
    }

    public double berechneKostenArbeitstag() {
        double gesamtkosten = 0;

        for (Mitarbeiter mitarbeiter : getGesamtpersonal()) {
            gesamtkosten += mitarbeiter.einkommen();
        }
        return gesamtkosten;
    }

}
