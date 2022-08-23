package idvalidation;

import person.MitarbeiterTyp;

import java.util.ArrayList;
import java.util.List;

public class IDValidator {

    private static final List<Integer> listIDs = new ArrayList<>();

    public static boolean checkIDisFree(int id) {
        return !listIDs.contains(id);
    }

    /**
     * validates and saves ID to list.
     */
    public static IDStatus saveID(MitarbeiterTyp typ, int id) {
        IDStatus returnValue = validateID(typ, id);
        if(returnValue.equals(IDStatus.OK)) {
            listIDs.add(id);
        }
        return returnValue;
    }

    /**
     * validates if id is correct and not taken.
     * All ids are required to consist of four positive digits. ID Ranges for each type:
     * Schichtarbeiter = 3000 - 3999,
     * Manager = 5000 - 5099,
     * Bueroarbeiter = 5100 - 5999
     */
    public static IDStatus validateID(MitarbeiterTyp typ, int id) {
        if (!checkIDisFree(id)) {
            return IDStatus.ALREADY_TAKEN;
        }

        switch (typ) {
            case SCHICHTARBEITER:
                if(id >= 3000 && id <= 3999) {
                    break;
                } else {
                    return IDStatus.INVALID_ID;
                }
            case MANAGER:
                if(id >= 5000 && id <= 5099) {
                    break;
                } else {
                    return IDStatus.INVALID_ID;
                }
            case BUEROARBEITER:
                if(id >= 5100 && id <= 5999) {
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
