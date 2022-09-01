package com.itf201.mitarbeiteransicht.backend;

import com.itf201.mitarbeiteransicht.backend.person.MitarbeiterTyp;

public record MitarbeiterDto(int id,
                             String name,
                             MitarbeiterTyp typ,
                             Double festgehalt,
                             Double stundenlohn,
                             Double bonussatz,
                             int stundenzahl) {

}
