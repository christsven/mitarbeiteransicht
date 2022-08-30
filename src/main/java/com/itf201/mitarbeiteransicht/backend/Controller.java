package com.itf201.mitarbeiteransicht.backend;


import com.itf201.mitarbeiteransicht.backend.institution.Abteilung;
import com.itf201.mitarbeiteransicht.backend.person.MitarbeiterTyp;
import com.itf201.mitarbeiteransicht.backend.person.mitarbeiter.Mitarbeiter;

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

    public boolean createMitarbeiter(MitarbeiterTyp typ, String nachname, String vorname) {
        // TODO add ID
        // TODO validity checks

        return true;
    }

    public boolean deleteMitarbeiter(int id) {
        return true;
    }

    public boolean createAbteilung(String nameAbteilung, int idLeiter, List<Integer> idsMitarbeiter) {
        return true;
    }

    public boolean deleteAbteilung() {
        return true;
    }

    public boolean addMitarbeiterToAbteilung(int idMitarbeiter, String nameAbteilung) {
        return true;
    }

    public boolean removeMitarbeiterFromAbteilung(int idMitarbeiter, String nameAbteilung) {
        return true;
    }

}
