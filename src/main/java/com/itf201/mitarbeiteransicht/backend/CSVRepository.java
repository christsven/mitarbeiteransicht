package com.itf201.mitarbeiteransicht.backend;

import java.util.List;
import java.util.logging.Logger;

public class CSVRepository {

    private final Logger LOGGER = Logger.getLogger("CSVRepository");
    private static final String FILE_PATH = "H:/Schule/src/mitarbeiteransicht/src/main/java/com/itf201/mitarbeiteransicht/persistence/die_datenbank.csv";

    public void addMitarbeiterToCSV(MitarbeiterDto dto) {
        //TODO hinzufügen von Mitarbeiter zu CSV
    }

    public List<MitarbeiterDto> getAllFromCSV() {
        //TODO einmal komplette liste in dtos ausgeben
        return List.of();
    }

    public void deleteFromCSV(int id) {
        //TODO filtern und auslöschen, ansonsten kein fehler schmeißen
    }

    /**
     * Returns a {@link MitarbeiterDto} from a CSV entity.
     *
     * @param id - id of user
     * @return - {@link MitarbeiterDto} or null
     */
    public MitarbeiterDto getFromCSV(int id) {
        return getAllFromCSV().stream().filter(m -> m.id() == id).findFirst().orElse(null);
    }
}
