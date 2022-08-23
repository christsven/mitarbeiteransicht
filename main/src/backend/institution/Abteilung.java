package institution;

import person.mitarbeiter.Mitarbeiter;
import person.mitarbeiter.Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Abteilung {

    private String name;
    private TreeSet<Mitarbeiter> mitarbeiterListe;
    private Manager leiter;

    public Abteilung(String name, Manager leiter) {
        setName(name);
        setLeiter(leiter);
        mitarbeiterListe = new TreeSet<>();
        mitarbeiterListe.add(leiter);
    }

    public Manager getLeiter() {
        return leiter;
    }

    public String getName() {
        return name;
    }

    public TreeSet<Mitarbeiter> getMitarbeiterListe() {
        return mitarbeiterListe;
    }

    public void setName(String name) {
        if(!name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("String name cannot be blank.");
        }
    }

    public void setLeiter(Manager leiter) {
        this.leiter = leiter;
    }

    public void setMitarbeiterListe(TreeSet<Mitarbeiter> mitarbeiterListe) {
        this.mitarbeiterListe = mitarbeiterListe;
    }

    public void addMitarbeiter(Mitarbeiter toBeAdded) {
        mitarbeiterListe.add(toBeAdded);
    }

    public void removeMitarbeiter(Mitarbeiter mitarbeiter) {
        mitarbeiterListe.remove(mitarbeiter);
    }

    public String getGehalsliste() {
        StringBuilder gehaltsliste = new StringBuilder(String.format(
                "Gehaltsliste Abteilung: %s\n",
                getName()));
        double gehaltsCounter = 0.0;
        for (Mitarbeiter mitarbeiter: getMitarbeiterListe()) {
            gehaltsliste.append(mitarbeiter.toString());
            gehaltsliste.append("\n");
            gehaltsCounter += mitarbeiter.einkommen();
        }
        gehaltsliste.append(String.format(
                "Gesamtbetrag Gehalt: %s€",
                gehaltsCounter));
        return gehaltsliste.toString();
    }

    public String toString() {
        return String.format("Name: %s, Leiter: %s, Mitarbeiterliste: %s, Gehaltsliste: %s",
                getName(),
                getLeiter(),
                getMitarbeiterListe(),
                getGehalsliste()
        );
    }
}
