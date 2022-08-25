package com.itf201.mitarbeiteransicht.backend.fahrzeuge;


import com.itf201.mitarbeiteransicht.backend.person.mitarbeiter.Fahrer;
import com.itf201.mitarbeiteransicht.backend.person.mitarbeiter.Mitarbeiter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class PersonenTransportFahrzeug extends KraftFahrZeug {

    private final int sitze;

    /**
     * K/V-Map, da ansonsten bei bpsw einer ArrayList
     * 1.) die Sitzplätze sind nicht eindeutig
     * 2.) die Anzahl der Sitzplätze ist nicht eindeutig
     * wären.
     */
    private Map<Integer, Mitarbeiter> sitzplan;


    public PersonenTransportFahrzeug(Fahrer fahrer, GPS position, double tankgroesse, double tankinhalt, int sitze) {
        super(fahrer, position, tankgroesse, tankinhalt);
        if (sitze > 1) {
            this.sitze = sitze;
            createEmptyHashMapSitzplan();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean einsteigen(Mitarbeiter mitarbeiter) {
        int sitzplatz = returnEmptySeat();
        if (sitzplatz != -1 && !getSitzplan().containsValue(mitarbeiter)) {
            getSitzplan().put(sitzplatz, mitarbeiter);
            System.out.printf(
                    "Mitarbeiter %s eingestiegen auf Platz %s%n",
                    mitarbeiter.getName(),
                    sitzplatz);
            return true;
        }
        return false;
    }

    public void aussteigen(Mitarbeiter mitarbeiter) {
        if (getSitzplan().containsValue(mitarbeiter)) {
            int key = getSitzByMitarbeiter(mitarbeiter);
            getSitzplan().put(key, null);
            System.out.printf(
                    "Mitarbeiter %s ist ausgestiegen%n",
                    mitarbeiter.getName());
        }
    }

    public void aussteigen(int sitz) {
        getSitzplan().put(sitz, null);
    }

    private int getSitzByMitarbeiter(Mitarbeiter mitarbeiter) {
        List<Integer> ergebnis = getSitzplan().entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), mitarbeiter))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        if (ergebnis.size() != 0) {
            return ergebnis.get(0);
        }
        return -1;
    }

    private int returnEmptySeat() {
        int sitzplatz = -1;
        for (int i = 0; i < getSitze(); i++) {
            if (getSitzplan().get(i) == null) {
                sitzplatz = i;
            } else {
                i++;
            }
        }
        return sitzplatz;
    }

    //Getter und Setter
    public int getSitze() {
        return sitze;
    }

    public Map<Integer, Mitarbeiter> getSitzplan() {
        return sitzplan;
    }

    /**
     * Wir brauchen eine Map mit
     * einer festen Größe,
     * festen Sitzplätzen,
     * einer Möglichkeit, dass die Plätze leer sind.
     * Deshalb kann man weder Listen (nicht eindeutig)
     * noch Arrays (keine leeren Werte) verwenden.
     * <p>
     * Hier wird eine leere Map mit null-Werten auf
     * freien Sitzplätzen erzeugt.
     */
    private void createEmptyHashMapSitzplan() {
        HashMap<Integer, Mitarbeiter> sitzplan = new HashMap<>();
        for (int i = 0; i < sitze; i++) {
            sitzplan.put(i, null);
        }
        this.sitzplan = sitzplan;
    }
}
