package com.itf201.mitarbeiteransicht.backend.fahrzeuge.varianten;


import com.itf201.mitarbeiteransicht.backend.fahrzeuge.GPS;
import com.itf201.mitarbeiteransicht.backend.fahrzeuge.KraftFahrZeug;
import com.itf201.mitarbeiteransicht.backend.fahrzeuge.PersonenTransportFahrzeug;
import com.itf201.mitarbeiteransicht.backend.person.mitarbeiter.Fahrer;

public class Bus extends PersonenTransportFahrzeug {

    public Bus(Fahrer fahrer, GPS position, double tankgroesse, double tankinhalt, int sitze) {
        super(fahrer, position, tankgroesse, tankinhalt, sitze);
    }

    @Override
    public double auslastung() {
        return 0;
    }

    @Override
    public int compareTo(KraftFahrZeug o) {
        return 0;
    }
}
