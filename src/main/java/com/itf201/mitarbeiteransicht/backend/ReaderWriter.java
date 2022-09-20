package com.itf201.mitarbeiteransicht.backend;


import com.google.gson.Gson;
import com.itf201.mitarbeiteransicht.backend.idvalidation.IDValidator;
import com.itf201.mitarbeiteransicht.backend.institution.Abteilung;
import com.itf201.mitarbeiteransicht.backend.person.MitarbeiterTyp;
import com.itf201.mitarbeiteransicht.backend.person.mitarbeiter.BueroArbeiter;
import com.itf201.mitarbeiteransicht.backend.person.mitarbeiter.Manager;
import com.itf201.mitarbeiteransicht.backend.person.mitarbeiter.Mitarbeiter;
import com.itf201.mitarbeiteransicht.backend.person.mitarbeiter.SchichtArbeiter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Verwaltet Mitarbeiterlisten und stellt Schnittstellen für das Frontend zur vereinfachten
 * Bedienung des Backends zur Verfügung.
 */
public class ReaderWriter {

    private List<Abteilung> abteilungsListe;
    private TreeSet<Mitarbeiter> mitarbeiterListe;
    private static Logger LOGGER;

    private int managerCounter = 5000;
    private int bueroArbeiterCounter = 5100;
    private int schichtArbeiterCounter = 3000;

    private static final String FILE_PATH = "H:/Schule/src/mitarbeiteransicht/src/main/java/com/itf201/mitarbeiteransicht/persistence/die_datenbank.json";

    public ReaderWriter() {
        LOGGER = Logger.getGlobal();
        LOGGER.log(Level.INFO, "Create Controller.");
    }

    public List<Abteilung> getAllAbteilungen() {

        LOGGER.log(Level.INFO, "Returning all Abteilungen.");
        return abteilungsListe;
    }

    public List<Mitarbeiter> getAllMitarbeiter() {

        LOGGER.log(Level.INFO, "Returning all Mitarbeiter.");
        return mitarbeiterListe.stream().toList();
    }

    public boolean createMitarbeiter(MitarbeiterDto dto) {
        switch (dto.typ()) {
            case MANAGER -> createManager(dto.name(), dto.festgehalt(), dto.bonussatz());
            case BUEROARBEITER -> createBueroarbeiter(dto.name(), dto.festgehalt());
            case SCHICHTARBEITER -> createSchichtarbeiter(dto.name(), dto.stundenlohn(), dto.stundenzahl());
        }
        return true;
    }

    private void createManager(String name, Double festgehalt, Double bonussatz) {
        if (name == null || festgehalt == null || bonussatz == null) {
            LOGGER.log(Level.SEVERE, "Null values found, failed to create Manager.");
            throw new IllegalArgumentException();
        }
        IDValidator.saveID(MitarbeiterTyp.MANAGER, managerCounter);
        //mitarbeiterListe.add(new Manager(managerCounter, name, festgehalt, bonussatz));
        try {
            writeToDataBase(new MitarbeiterDto(
                    managerCounter,
                    name,
                    MitarbeiterTyp.MANAGER,
                    festgehalt,
                    0.0,
                    bonussatz,
                    0));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to save.");
        }
        managerCounter = managerCounter + 1;
        LOGGER.log(Level.INFO, "New Manager created.");
    }

    private void writeToDataBase(MitarbeiterDto dto) throws IOException {
        Gson gson = new Gson();
        FileWriter writer = new FileWriter(FILE_PATH);
        gson.toJson(dto, writer);
        writer.flush();
        writer.close();
    }

    private void createSchichtarbeiter(String name, Double stundenlohn, int stundenzahl) {
        if (name == null || stundenlohn == null) {
            LOGGER.log(Level.SEVERE, "Null values found, failed to create Schichtarbeiter.");
            throw new IllegalArgumentException();
        }
        IDValidator.saveID(MitarbeiterTyp.SCHICHTARBEITER, schichtArbeiterCounter);
        mitarbeiterListe.add(new SchichtArbeiter(schichtArbeiterCounter, name, stundenlohn, stundenzahl));
        schichtArbeiterCounter = schichtArbeiterCounter + 1;
        LOGGER.log(Level.INFO, "New Schichtarbeiter created.");
    }

    private void createBueroarbeiter(String name, Double festgehalt) {
        if (name == null || festgehalt == null) {
            LOGGER.log(Level.SEVERE, "Null values found, failed to create Bueroarbeiter.");
            throw new IllegalArgumentException();
        }
        IDValidator.saveID(MitarbeiterTyp.BUEROARBEITER, bueroArbeiterCounter);
        mitarbeiterListe.add(new BueroArbeiter(bueroArbeiterCounter, name, festgehalt));
        bueroArbeiterCounter = bueroArbeiterCounter + 1;
        LOGGER.log(Level.INFO, "New Bueroarbeiter created.");
    }

    public boolean deleteMitarbeiter(int id) {
        Optional<Mitarbeiter> found = mitarbeiterListe.stream()
                .filter(mitarbeiter -> mitarbeiter.getId() == id)
                .findFirst();
        if (found.isEmpty()) {
            LOGGER.log(Level.SEVERE, "Mitarbeiter ID is not used, failed to remove Mitarbeiter.");
            return false;
        }
        mitarbeiterListe.remove(found.get());
        LOGGER.log(Level.INFO, "Removed Mitarbeiter.");

        return true;
    }

    public boolean createAbteilung(String nameAbteilung, int idLeiter, List<Integer> idsMitarbeiter) {
        if (nameAbteilung == null) {
            LOGGER.log(Level.SEVERE, "Name cannot be null");
            throw new IllegalArgumentException();
        }
        Optional<Mitarbeiter> leiter = mitarbeiterListe.stream()
                .filter(mitarbeiter -> mitarbeiter.getId() == idLeiter)
                .findFirst();
        if (leiter.isEmpty()) throw new IllegalArgumentException("Leiter does not exist");
        Abteilung abteilung = new Abteilung(nameAbteilung, (Manager) leiter.get());
        idsMitarbeiter.forEach(id -> {
            Optional<Mitarbeiter> foundMitarbeiter = mitarbeiterListe.stream()
                    .filter(mitarbeiter -> mitarbeiter.getId() == id)
                    .findFirst();
            if (foundMitarbeiter.isPresent()) {
                abteilung.addMitarbeiter(foundMitarbeiter.get());
            } else {
                LOGGER.log(Level.SEVERE, String.format("ID %s does not exist", id));
            }
        });
        abteilungsListe.add(abteilung);
        LOGGER.log(Level.INFO, "Abteilung successfully created.");
        return true;
    }

    public boolean deleteAbteilung(String nameAbteilung) {
        Optional<Abteilung> found = abteilungsListe.stream()
                .filter(abteilung -> abteilung.getName().equals(nameAbteilung))
                .findFirst();
        if (found.isEmpty()) {
            LOGGER.log(Level.SEVERE, "name of Abteilung is not used, failed to remove Abteilung.");
            return false;
        }
        abteilungsListe.remove(found.get());
        LOGGER.log(Level.INFO, "Removed Abteilung.");

        return true;
    }

    public boolean addMitarbeiterToAbteilung(int idMitarbeiter, String nameAbteilung) {
        return findMitarbeiterInAbteilungAndProcess(false, idMitarbeiter, nameAbteilung);
    }

    public boolean removeMitarbeiterFromAbteilung(int idMitarbeiter, String nameAbteilung) {
        return findMitarbeiterInAbteilungAndProcess(true, idMitarbeiter, nameAbteilung);
    }

    private boolean findMitarbeiterInAbteilungAndProcess(boolean remove, int idMitarbeiter, String nameAbteilung) {
        Optional<Abteilung> abteilung = abteilungsListe.stream()
                .filter(abteilungInListe -> abteilungInListe.getName().equals(nameAbteilung))
                .findFirst();

        Optional<Mitarbeiter> mitarbeiter = mitarbeiterListe.stream()
                .filter(mitarbeiterInListe -> mitarbeiterInListe.getId() == idMitarbeiter)
                .findFirst();

        if(mitarbeiter.isPresent() && abteilung.isPresent()) {
            Optional<Mitarbeiter> foundMitarbeiter = abteilung.get().getMitarbeiterListe().stream()
                    .filter((mitarbeiterInAbteilung -> mitarbeiterInAbteilung.getId() == mitarbeiter.get().getId()))
                    .findFirst();
            if(foundMitarbeiter.isPresent()) {
                if (remove) {
                    abteilung.get().removeMitarbeiter(foundMitarbeiter.get());
                } else {
                    abteilung.get().addMitarbeiter(foundMitarbeiter.get());
                }
                LOGGER.log(Level.INFO, "Successfully removed Mitarbeiter from Abteilung.");
                return true;
            }
        } else {
            LOGGER.log(Level.SEVERE, "Failed to remove, either didnt find Abteilung or Mitarbeiter.");
        }
        LOGGER.log(Level.SEVERE,"Failed to remove Mitarbeiter.");
        return false;
    }

}