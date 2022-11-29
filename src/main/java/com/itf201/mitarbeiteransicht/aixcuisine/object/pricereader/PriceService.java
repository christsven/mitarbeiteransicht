package object.pricereader;

import object.AbstractObject;

import java.util.HashMap;

/**
 * Dient dem Zugriff auf die Preisliste und verwaltet intern alle Preiskalkulationen
 * und das Auslesen der Datei, ohne dass man von außen mehr als den Dateipfad eingeben
 * muss.
 * <p>
 * Im Nachhinein soll auch die Preisliste aktualisiert werden können, der Controller soll
 * desweiteren die Liste ausgeben, Preise auslesen oder aktualisieren können.
 */
public class PriceService {

    //map of all prices, has to be imported on initialization
    private HashMap<String, Double> surfaceList;
    private HashMap<String, Double> fillList;
    private final PriceReader reader = new PriceReader();

    public PriceService(String pathToSurfaceList, String pathToFillList) {
        setSurfaceList(reader.readFromFile(pathToSurfaceList));
        setFillList(reader.readFromFile(pathToFillList));
    }

    public HashMap<String, Double> getSurfaceList() {
        return surfaceList;
    }

    public HashMap<String, Double> getFillList() {
        return fillList;
    }

    private void setFillList(HashMap<String, Double> unvalidatedMap) {
        fillList = unvalidatedMap;
    }

    private void setSurfaceList(HashMap<String, Double> unvalidatedMap) {
        surfaceList = unvalidatedMap;
    }

    /**
     * returns value for a string name of material
     *
     * @return - value of material or -1.0 of not found
     */
    public double getPriceForSurface(String material) {
        return getSurfaceList().getOrDefault(material, -1.0);
    }

    /**
     * returns value for a string name of material
     *
     * @return - value of material or -1.0 of not found
     */
    public double getPriceForFilling(String material) {
        return getFillList().getOrDefault(material, -1.0);
    }

    public void importSurfaceList(String importPath) throws IllegalArgumentException {
        setSurfaceList(importList(importPath));

    }

    public void importFillList(String importPath) throws IllegalArgumentException {
       setFillList(importList(importPath));
    }

    private HashMap<String, Double> importList(String path) {
        HashMap<String, Double> result = reader.readFromFile(path);
        if (result.size() == 0) {
            throw new IllegalArgumentException("Empty array - abort import");
        }
        return result;
    }

    public boolean doesMaterialExist(String material) {
        return getFillList().containsKey(material) || getSurfaceList().containsKey(material);
    }

    /**
     * Calculates a price in € for an object with a selected filling and surface material.
     * <p>
     * These material names can be read from the lists provided by {@link PriceService}.
     *
     * @param object          - The shape we need
     * @param fillingMaterial - String name for the filling to be used
     * @param surfaceMaterial - String name for the surface to be used
     * @return Double price for selected parameters
     */
    public <T extends AbstractObject> Double calculatePriceForObject(T object, String surfaceMaterial, String fillingMaterial) {
        if (object == null
                || !getFillList().containsKey(fillingMaterial)
                || !getSurfaceList().containsKey(surfaceMaterial)) {
            throw new IllegalArgumentException("Materials could not be found in lists or object is null");
        }
        double fillingValue = getPriceForFilling(fillingMaterial);
        double surfaceValue = getPriceForSurface(surfaceMaterial);

        return (fillingValue * object.getVolume()) + (surfaceValue * object.getSurface());
    }
}
