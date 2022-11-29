package shape;

public abstract class AbstractShape {

    protected double area;

    public double getArea() {
        return area;
    }

    protected void setArea(double area) {
        if(area < 0) {
            throw new IllegalArgumentException("Area has to be positive.");
        } else {
            this.area = area;
        }
    }

    /**
     * is to be implemented for child classes as method
     * to calculate the area from the given parameters
     * of each shape.
     *
     * Called when size, vertices, etc. of a shape change
     * and updates the area and other values to save operational
     * time.
     */
    protected abstract void onParametersChanged();
}
