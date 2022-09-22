package com.itf201.mitarbeiteransicht.application;

import com.itf201.mitarbeiteransicht.backend.ReaderWriter;

public class Main {

    public static void main(String[] args) {
        ReaderWriter readerWriter = new ReaderWriter();
        readerWriter.getAllMitarbeiter();
        /*MitarbeiterEditModal modal = new MitarbeiterEditModal(
                readerWriter,
                new MitarbeiterDto(
                        1,
                        "Marcel D'Avis",
                        MitarbeiterTyp.MANAGER,
                        1234.0,
                        69.0,
                        1000000.0,
                        40));*/
    }
}
