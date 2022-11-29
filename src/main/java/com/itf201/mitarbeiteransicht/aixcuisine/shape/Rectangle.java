package shape;


public class Rectangle extends AbstractShape {

    private double height;

    private double length;

    public Rectangle(double height, double length) throws IllegalAccessException {
        setSize(height, length);
        onParametersChanged();
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    public void setSize(double hight, double length) throws IllegalAccessException {
        if (hight > 0 && length > 0) {
            this.height = hight;
            this.length = length;
            onParametersChanged();
        } else {
            throw new IllegalAccessException("Hight and Length have to be positive");
        }
    }

    @Override
    protected void onParametersChanged() {
        setArea(length * height);
    }
}
