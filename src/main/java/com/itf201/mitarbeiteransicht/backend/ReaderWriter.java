package com.itf201.mitarbeiteransicht.backend;


import com.itf201.mitarbeiteransicht.backend.idvalidation.IDValidator;
import com.itf201.mitarbeiteransicht.backend.person.MitarbeiterTyp;

import java.io.IOException;
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
    private static final CSVRepository csvRepository = new CSVRepository();
    private static final Logger LOGGER = Logger.getLogger("ReaderWriter");

    public static void createMitarbeiter(MitarbeiterDto dto) {
        switch (dto.typ()) {
            case MANAGER -> createManager(dto);
            case BUEROARBEITER -> createBueroarbeiter(dto);
            case SCHICHTARBEITER -> createSchichtarbeiter(dto);
        }
    }

    public static List<MitarbeiterDto> getAllMitarbeiter() {
        try {
            return csvRepository.getAllMitarbeiter();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to read from file.");
            return null;
        }
    }

    public static void editMitarbeiter(MitarbeiterDto dto) {
        csvRepository.deleteMitarbeiter(dto.id());
        csvRepository.addMitarbeiter(dto, dto.id());
        LOGGER.log(Level.INFO, String.format("Mitarbeiter with id %s successfully edited.", dto.id()));
    }

    public static void deleteMitarbeiter(int id) {
        csvRepository.deleteMitarbeiter(id);
        LOGGER.log(Level.INFO, String.format("Removed Mitarbeiter with id %s.", id));
    }

    private static void createManager(MitarbeiterDto dto) {
        if (dto.name() == null || dto.festgehalt() == null || dto.bonussatz() == null) {
            LOGGER.log(Level.SEVERE, "Null values found, failed to create Manager.");
            throw new IllegalArgumentException();
        }
        IDValidator.saveId(MitarbeiterTyp.MANAGER, managerCounter);
        csvRepository.addMitarbeiter(dto, managerCounter);
        managerCounter = managerCounter + 1;
        LOGGER.log(Level.INFO, String.format("New Manager with id %s created.", managerCounter));
    }

    private static void createSchichtarbeiter(MitarbeiterDto dto) {
        if (dto.name() == null || dto.stundenlohn() == null) {
            LOGGER.log(Level.SEVERE, "Null values found, failed to create Schichtarbeiter.");
            throw new IllegalArgumentException();
        }
        IDValidator.saveId(MitarbeiterTyp.SCHICHTARBEITER, schichtArbeiterCounter);
        csvRepository.addMitarbeiter(dto, schichtArbeiterCounter);
        schichtArbeiterCounter = schichtArbeiterCounter + 1;
        LOGGER.log(Level.INFO, String.format("New Schichtarbeiter with id %s created.", schichtArbeiterCounter));
    }

    private static void createBueroarbeiter(MitarbeiterDto dto) {
        if (dto.name() == null || dto.festgehalt() == null) {
            LOGGER.log(Level.SEVERE, "Null values found, failed to create Bueroarbeiter.");
            throw new IllegalArgumentException();
        }
        IDValidator.saveId(MitarbeiterTyp.BUEROARBEITER, bueroArbeiterCounter);
        csvRepository.addMitarbeiter(dto, bueroArbeiterCounter);
        bueroArbeiterCounter = bueroArbeiterCounter + 1;
        LOGGER.log(Level.INFO, String.format("New Bueroarbeiter with id %s created.", bueroArbeiterCounter));
    }

}
