package com.itf201.mitarbeiteransicht.backend.idvalidation;


import com.itf201.mitarbeiteransicht.backend.person.MitarbeiterTyp;

import java.util.ArrayList;
import java.util.List;

public class IDValidator {

    private static final List<Integer> listIDs = new ArrayList<>();

    private static int counterSchicht = 3000;
    private static int counterBuero = 5100;
    private static int counterManager = 5000;

    public static boolean checkIdIsFree(int id) {
        return !listIDs.contains(id);
    }

    /**
     * validates and saves ID to list.
     */
    public static IDStatus saveId(MitarbeiterTyp typ, int id) {
        IDStatus returnValue = validateId(typ, id);
        if (returnValue.equals(IDStatus.OK)) {
            listIDs.add(id);
            switch (typ) {
                case MANAGER -> counterManager++;
                case BUEROARBEITER -> counterBuero++;
                case SCHICHTARBEITER -> counterSchicht++;
            }
        }
        return returnValue;
    }

    public static int getValidId(MitarbeiterTyp typ) {
        if (typ == null) throw new NullPointerException("Typ is null");
        switch (typ) {
            case MANAGER -> {
                counterManager++;
                saveId(typ, counterManager - 1);
                return counterManager - 1;
            }
            case BUEROARBEITER -> {
                counterBuero++;
                saveId(typ, counterBuero - 1);
                return counterBuero - 1;
            }
            case SCHICHTARBEITER -> {
                counterSchicht++;
                saveId(typ, counterSchicht - 1);
                return counterSchicht - 1;
            }
            default -> throw new IllegalArgumentException("Invalid Type parameter");
        }
    }

    /**
     * validates if id is correct and not taken.
     * All ids are required to consist of four positive digits. ID Ranges for each type:
     * Schichtarbeiter = 3000 - 3999,
     * Manager = 5000 - 5099,
     * Bueroarbeiter = 5100 - 5999
     */
    public static IDStatus validateId(MitarbeiterTyp typ, int id) {
        if (!checkIdIsFree(id)) {
            return IDStatus.ALREADY_TAKEN;
        }
        switch (typ) {
            case SCHICHTARBEITER:
                if (id >= 3000 && id <= 3999) {
                    break;
                } else {
                    return IDStatus.INVALID_ID;
                }
            case MANAGER:
                if (id >= 5000 && id <= 5099) {
                    break;
                } else {
                    return IDStatus.INVALID_ID;
                }
            case BUEROARBEITER:
                if (id >= 5100 && id <= 5999) {
                    break;
                } else {
                    return IDStatus.INVALID_ID;
                }
            default:
                return IDStatus.UNKNOWN_TYPE;
        }
        return IDStatus.OK;
    }

}
