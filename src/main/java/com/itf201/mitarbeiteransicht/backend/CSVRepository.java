package com.itf201.mitarbeiteransicht.backend;

import com.itf201.mitarbeiteransicht.backend.person.MitarbeiterTyp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Code provided by Leon Bartz
 */
public class CSVRepository {

    private final Logger LOGGER = Logger.getLogger("CSVRepository");
    //TODO fix filepath
    private static final String FILE_PATH = "H:/christ_sve/leistungstraeger/die_datenbank.csv";
    private static final String DELIMINATOR = ";";

    public void addMitarbeiter(MitarbeiterDto dto, int id) {
        try {
            writeToFile(dto, id);
        } catch (IOException ex) {
            throw new RuntimeException(String.format("Failed to write Mitarbeiter %s to file.", dto.id()));
        }
    }

    public List<MitarbeiterDto> getAllMitarbeiter() throws IOException {
        try {
            ArrayList<String[]> rawData = readStringsFromFile();
            return rawData.stream().map(this::convertToDto).toList();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to read from file");
            return List.of();
        }
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
    public MitarbeiterDto getMitarbeiterById(int id) throws IOException {
        return getAllMitarbeiter().stream().filter(m -> m.id() == id).findFirst().orElse(null);
    }

    private ArrayList<String[]> readStringsFromFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
        ArrayList<String[]> elements = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] splitted = line.split(DELIMINATOR);
            elements.add(splitted);
        }
        br.close();
        return elements;
    }

    private MitarbeiterDto convertToDto(String[] strings) {
        return new MitarbeiterDto(
                Integer.parseInt(strings[0]),
                strings[1],
                MitarbeiterTyp.valueOf(strings[2]),
                Double.valueOf(strings[3]),
                Double.valueOf(strings[4]),
                Double.valueOf(strings[5]),
                Integer.parseInt(strings[6]));
    }

    private void writeToFile(MitarbeiterDto dto, int id) throws IOException {
        File file = new File(FILE_PATH);
        FileWriter fw = new FileWriter(file, true);
        String line = id +
                DELIMINATOR +
                dto.name() +
                DELIMINATOR +
                dto.typ() +
                DELIMINATOR +
                dto.festgehalt() +
                DELIMINATOR +
                dto.stundenlohn() +
                DELIMINATOR +
                dto.bonussatz() +
                DELIMINATOR +
                dto.stundenzahl() +
                "\n";
        fw.write(line);
        fw.close();
    }
}
