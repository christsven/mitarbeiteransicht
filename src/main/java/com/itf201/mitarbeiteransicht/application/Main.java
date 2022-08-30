package com.itf201.mitarbeiteransicht.application;

import com.itf201.mitarbeiteransicht.backend.person.MitarbeiterTyp;
import com.itf201.mitarbeiteransicht.frontend.MitarbeiterEditModal;

public class Main {

    public static void main (String[] args) {
        MitarbeiterEditModal modal = new MitarbeiterEditModal(MitarbeiterTyp.MANAGER);
        System.out.println("Moin Servus Moin");
    }
}
