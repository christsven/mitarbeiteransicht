package com.itf201.mitarbeiteransicht.backend;


import com.itf201.mitarbeiteransicht.backend.institution.Abteilung;
import com.itf201.mitarbeiteransicht.backend.person.mitarbeiter.BueroArbeiter;
import com.itf201.mitarbeiteransicht.backend.person.mitarbeiter.Manager;
import com.itf201.mitarbeiteransicht.backend.person.mitarbeiter.Mitarbeiter;
import com.itf201.mitarbeiteransicht.backend.person.mitarbeiter.SchichtArbeiter;

import java.util.List;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Verwaltet Mitarbeiterlisten und stellt Schnittstellen für das Frontend zur vereinfachten
 * Bedienung des Backends zur Verfügung.
 */
public class Controller {

    private List<Abteilung> abteilungsListe;
    private TreeSet<Mitarbeiter> mitarbeiterListe;
    private static Logger LOGGER;

    private int managerCounter = 5000;
    private int bueroArbeiterCounter = 5100;
    private int schichtArbeiterCounter = 3000;

    public Controller() {
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
        mitarbeiterListe.add(new Manager(managerCounter, name, festgehalt, bonussatz));
        managerCounter = managerCounter + 1;
        LOGGER.log(Level.INFO, "New Manager created.");
    }

    private void createSchichtarbeiter(String name, Double stundenlohn, int stundenzahl) {
        if (name == null || stundenlohn == null) {
            LOGGER.log(Level.SEVERE, "Null values found, failed to create Schichtarbeiter.");
            throw new IllegalArgumentException();
        }
        mitarbeiterListe.add(new SchichtArbeiter(schichtArbeiterCounter, name, stundenlohn, stundenzahl));
        schichtArbeiterCounter = schichtArbeiterCounter + 1;
        LOGGER.log(Level.INFO, "New Schichtarbeiter created.");
    }

    private void createBueroarbeiter(String name, Double festgehalt) {
        if (name == null || festgehalt == null) {
            LOGGER.log(Level.SEVERE, "Null values found, failed to create Bueroarbeiter.");
            throw new IllegalArgumentException();
        }
        mitarbeiterListe.add(new BueroArbeiter(bueroArbeiterCounter, name, festgehalt));
        bueroArbeiterCounter = bueroArbeiterCounter + 1;
        LOGGER.log(Level.INFO, "New Bueroarbeiter created.");
    }

    public boolean deleteMitarbeiter(int id) {
        return true;
    }

    public boolean createAbteilung(String nameAbteilung, int idLeiter, List<Integer> idsMitarbeiter) {
        return true;
    }

    public boolean deleteAbteilung(String nameAbteilung) {
        return true;
    }

    public boolean addMitarbeiterToAbteilung(int idMitarbeiter, String nameAbteilung) {
        return true;
    }

    public boolean removeMitarbeiterFromAbteilung(int idMitarbeiter, String nameAbteilung) {
        return true;
    }

}
