package object.pricereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * CSV-Reader speziell für den Import der Preislisten. Erstellt eine HashMap
 * (https://www.baeldung.com/java-hashmap), welche dem PriceController zur Verfügung gestellt
 * wird.
 */
public class PriceReader {

    private static final String DELIMITER = ";";

    //Format: name:price
    public HashMap<String, Double> readFromFile(String path) {
        try {
            HashMap<String, Double> result = new HashMap<>();
            BufferedReader reader = new BufferedReader(new FileReader(path));

            String currentLine = "";
            while ((currentLine = reader.readLine()) != null) {
                String[] array = convertRawInput(currentLine.split(DELIMITER));
                for (int i = 0; i < array.length - 1; i = i + 2) {
                    result.put(array[i], Double.parseDouble(array[i + 1]));
                }
            }
            return result;

        } catch (FileNotFoundException e) {
            System.out.printf("File could not be found for %s%n", path);
            return new HashMap<>();
        } catch (IOException e) {
            System.out.printf("Error while parsing: %s", e.getMessage());
            return new HashMap<>();
        }
    }

    private String[] convertRawInput(String[] input) {
        standardizeLocalization(input);
        removeUnnecessaryCharacters(input);
        return checkForMissingValues(input);
    }

    /**
     * removes german locale and changes the format to standard
     *
     * @param array - german formatted price list
     */
    private void standardizeLocalization(String[] array) {
        for (int i = 0; i < array.length; i++) {
            //nur bei Kosten, nicht im Namen
            if (i % 2 == 1) {
                String value = array[i];
                array[i] = value.replace(',', '.');
            }
        }
    }

    private void removeUnnecessaryCharacters(String[] array) {
        for (int i = 0; i < array.length; i++) {
            String value = array[i];
            array[i] = value.replaceAll(String.valueOf('"'), "");
        }
    }

    /**
     * if array has uneven size, the last value set will not be read, so this
     * at least fills in the field instead of dropping the last name. Might
     * be removed since it might be overlooked in calculation?
     *
     * @return an even sized array
     */
    private String[] checkForMissingValues(String[] array) {
        if (array.length % 2 != 0) {
            String[] result = new String[array.length + 1];
            System.arraycopy(array, 0, result, 0, array.length);
            result[result.length - 1] = "0.00";
            return result;
        }
        return array;
    }
}
