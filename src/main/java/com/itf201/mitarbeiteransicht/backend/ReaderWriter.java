package com.itf201.mitarbeiteransicht.backend;


import com.itf201.mitarbeiteransicht.backend.idvalidation.IDValidator;
import com.itf201.mitarbeiteransicht.backend.person.MitarbeiterTyp;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility Class, die mit dem Frontend per {@link MitarbeiterDto} kommuniziert und die Verwaltung der Mitarbeiterliste
 * übernimmt, um die Arbeit im Frontend zu erleichtern.
 */
public class ReaderWriter {

    private static int managerCounter = 5000;
    private static int bueroArbeiterCounter = 5100;
    private static int schichtArbeiterCounter = 3000;
    private static final Logger LOGGER = Logger.getLogger("ReaderWriter");;
    private static final CSVRepository csvRepository = new CSVRepository();

    public static List<MitarbeiterDto> getAllMitarbeiter() {
        return csvRepository.getAllFromCSV();
    }

    public static void createMitarbeiter(MitarbeiterDto dto) {
        switch (dto.typ()) {
            case MANAGER -> createManager(dto);
            case BUEROARBEITER -> createBueroarbeiter(dto);
            case SCHICHTARBEITER -> createSchichtarbeiter(dto);
        }
    }

    public static void deleteMitarbeiter(int id) {
        csvRepository.deleteFromCSV(id);
        LOGGER.log(Level.INFO, "Removed Mitarbeiter.");
    }

    private static void createManager(MitarbeiterDto dto) {
        if (dto.name() == null || dto.festgehalt() == null || dto.bonussatz() == null) {
            LOGGER.log(Level.SEVERE, "Null values found, failed to create Manager.");
            throw new IllegalArgumentException();
        }
        IDValidator.saveID(MitarbeiterTyp.MANAGER, managerCounter);
        csvRepository.addMitarbeiterToCSV(dto);
        managerCounter = managerCounter + 1;
        LOGGER.log(Level.INFO, "New Manager created.");
    }

    private static void createSchichtarbeiter(MitarbeiterDto dto) {
        if (dto.name() == null || dto.stundenlohn() == null) {
            LOGGER.log(Level.SEVERE, "Null values found, failed to create Schichtarbeiter.");
            throw new IllegalArgumentException();
        }
        IDValidator.saveID(MitarbeiterTyp.SCHICHTARBEITER, schichtArbeiterCounter);
        csvRepository.addMitarbeiterToCSV(dto);
        schichtArbeiterCounter = schichtArbeiterCounter + 1;
        LOGGER.log(Level.INFO, "New Schichtarbeiter created.");
    }

    private static void createBueroarbeiter(MitarbeiterDto dto) {
        if (dto.name() == null || dto.festgehalt() == null) {
            LOGGER.log(Level.SEVERE, "Null values found, failed to create Bueroarbeiter.");
            throw new IllegalArgumentException();
        }
        IDValidator.saveID(MitarbeiterTyp.BUEROARBEITER, bueroArbeiterCounter);
        csvRepository.addMitarbeiterToCSV(dto);
        bueroArbeiterCounter = bueroArbeiterCounter + 1;
        LOGGER.log(Level.INFO, "New Bueroarbeiter created.");
    }

}
