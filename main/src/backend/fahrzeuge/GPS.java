package backend.fahrzeuge;

public class GPS {

    private double x;
    private double y;

    public GPS(double hoehengrad, double laengengrad) {
        setX(hoehengrad);
        setY(laengengrad);
    }

    public String getPosition() {
        return String.format("X: %s, Y: %s", x, y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
