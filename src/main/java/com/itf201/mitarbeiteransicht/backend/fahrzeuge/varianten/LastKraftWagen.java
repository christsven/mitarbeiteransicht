package com.itf201.mitarbeiteransicht.backend.fahrzeuge.varianten;


import com.itf201.mitarbeiteransicht.backend.fahrzeuge.GPS;
import com.itf201.mitarbeiteransicht.backend.fahrzeuge.KraftFahrZeug;
import com.itf201.mitarbeiteransicht.backend.person.mitarbeiter.Fahrer;

public class LastKraftWagen extends KraftFahrZeug {

    private final double ladeflaeche;
    private double ladung;

    public LastKraftWagen(Fahrer fahrer, GPS position, double tankgroesse, double tankinhalt, double ladeflaeche) {
        super(fahrer, position, tankgroesse, tankinhalt);
        if(ladeflaeche > 0) {
            this.ladeflaeche = ladeflaeche;
        } else {
            throw new IllegalArgumentException("Ladeflaeche has to be greater than 0.");
        }
    }

    public double getLadeflaeche() {
        return ladeflaeche;
    }

    public double getLadung() {
        return ladung;
    }

    /**
     * Belädt und gibt die Ladung zurück. Wenn nicht genug Platz ist, schlägt der Ladevorgang
     * fehl.
     * @param input zusätzliche Menge
     * @return tatsächliche Menge
     */
    public double beladen(double input) {
        if(ladung + input <= getLadeflaeche()) {
            setLadung(ladung + input);
        }
        return ladung;
    }

    private void setLadung(double ladung) {
        if(ladung <= getLadeflaeche()) {
            this.ladung = ladung;
        } else {
            throw new IllegalStateException("Mehr Ladung als Ladeflaeche gesetzt.");
        }
    }

    public double entladen() {
        setLadung(0);
        return getLadung();
    }

    /**
     * Entlädt den angegebenen Wert, wenn zu viel angegeben wird, wird die Ladung komplett entladen.
     * @param input zu entladende Menge
     * @return tatsächlicher Ladezustand
     */
    public double entladen(double input) {
        if(input > ladung) {
            setLadung(0);
        } else {
            setLadung(getLadung() - input);
        }
        return getLadung();
    }

    @Override
    public double auslastung() {
        return ladeflaeche - ladung;
    }


    @Override
    public int compareTo(KraftFahrZeug object) {
        if(object.auslastung() == auslastung()) return 0;
        return (object.auslastung() > auslastung()) ? 1 : -1;
    }

}
