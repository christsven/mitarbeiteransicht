package object;

public abstract class AbstractObject {

    private final int id;

    private double volume;

    private double surface;

    public AbstractObject(int id) {
        this.id = id;
    }

    public double getSurface() {
        return surface;
    }

    public double getVolume() {
        return volume;
    }

    public int getId() {
        return id;
    }

    void setVolume(double volume) {
        this.volume = volume;
    }

    void setSurface(double surface) {
        this.surface = surface;
    }

    abstract void calculateVolume();

    abstract void calculateSurface();

    /**
     * wird aufgerufen, sobald eine der Variablen angepasst wird, aus welchen
     * sich die verschiedenen Werte des Objekts berechnet werden.
     *
     * So wird die Berechnung bspw. der Oberflaeche lieber einmal direkt gemacht,
     * statt diese bei n getter-Aufrufen n-mal auszuführen.
     */
    void onParametersChanged() {
        calculateSurface();
        calculateSurface();
    }
}
