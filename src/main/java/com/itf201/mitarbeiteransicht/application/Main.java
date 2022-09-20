package com.itf201.mitarbeiteransicht.application;

import com.itf201.mitarbeiteransicht.backend.MitarbeiterDto;
import com.itf201.mitarbeiteransicht.backend.ReaderWriter;
import com.itf201.mitarbeiteransicht.backend.person.MitarbeiterTyp;
import com.itf201.mitarbeiteransicht.frontend.MitarbeiterEditModal;

public class Main {

    public static void main(String[] args) {
        ReaderWriter readerWriter = new ReaderWriter();
        MitarbeiterEditModal modal = new MitarbeiterEditModal(
                readerWriter,
                new MitarbeiterDto(
                        1,
                        "Marcel D'Avis",
                        MitarbeiterTyp.MANAGER,
                        1234.0,
                        69.0,
                        1000000.0,
                        40));
        System.out.println("Moin Servus Moin");
    }
}
