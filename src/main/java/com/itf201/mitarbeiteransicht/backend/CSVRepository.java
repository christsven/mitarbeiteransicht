package com.itf201.mitarbeiteransicht.backend;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVRepository {

    private final Logger LOGGER;

    private static final String FILE_PATH = "H:/Schule/src/mitarbeiteransicht/src/main/java/com/itf201/mitarbeiteransicht/persistence/die_datenbank.csv";

    public CSVRepository() {
        LOGGER = Logger.getLogger("CSVRepository");
        LOGGER.log(Level.INFO, String.format("Created CSVRepository for filepath %s", FILE_PATH));

    }

    public void addMitarbeiterToCSV(MitarbeiterDto dto) {

    }

    public List<MitarbeiterDto> getAllFromCSV() {
        return List.of();
    }

    public void deleteFromCSV(int id) {

    }

    /**
     * Returns a {@link MitarbeiterDto} from a CSV entity.
     * @param id - id of user
     * @return - {@link MitarbeiterDto} or null
     */
    public MitarbeiterDto getFromCSV(int id) {
        return getAllFromCSV().stream().filter(m -> m.id() == id).findFirst().orElse(null);
    }
}
