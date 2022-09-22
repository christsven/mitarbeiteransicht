package com.itf201.mitarbeiteransicht.backend;

import java.util.List;
import java.util.logging.Logger;

public class CSVRepository {

    private final Logger LOGGER = Logger.getLogger("CSVRepository");
    private static final String FILE_PATH = "H:/Schule/src/mitarbeiteransicht/src/main/java/com/itf201/mitarbeiteransicht/persistence/die_datenbank.csv";

    public void addMitarbeiter(MitarbeiterDto dto, int id) {
        MitarbeiterDto dtoToSave = new MitarbeiterDto(
                id,
                dto.name(),
                dto.typ(),
                dto.festgehalt(),
                dto.stundenlohn(),
                dto.bonussatz(),
                dto.stundenzahl());
        //TODO hinzufügen von dtoToSave zu CSV
    }

    public List<MitarbeiterDto> getAllMitarbeiter() {
        //TODO einmal komplette liste in dtos ausgeben
        return List.of();
    }

    public void deleteMitarbeiter(int id) {
        //TODO filtern und auslöschen, ansonsten kein fehler schmeißen
    }

    /**
     * Returns a {@link MitarbeiterDto} from a CSV entity.
     *
     * @param id - id of user
     * @return - {@link MitarbeiterDto} or null
     */
    public MitarbeiterDto getMitarbeiterById(int id) {
        return getAllMitarbeiter().stream().filter(m -> m.id() == id).findFirst().orElse(null);
    }
}
