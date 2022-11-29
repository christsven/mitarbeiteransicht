package shape;

public class Circle extends AbstractShape {

    private double circumference;

    private double radius;

    public Circle(double radius) {
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        onParametersChanged();
    }

    public double getCircumference() {
        return circumference;
    }

    private void setCircumference(double circumference) {
        if(circumference > 0) {
            this.circumference = circumference;
        } else {
            throw new IllegalArgumentException(String.format("Circumference cant be negative: %s", circumference));
        }
    }

    private void calculateCircumference() {
        setCircumference(2 * Math.PI * getRadius());
    }

    @Override
    protected void onParametersChanged() {
        setArea(Math.PI * getRadius() * getRadius());
        calculateCircumference();
    }

    /**
     * calculates the radius of the outer circle of a regular polygon.
     *
     * @param a = area of polygon
     * @param n = vertices
     * @return radius
     */
    public static double calculateRadiusInnerCircle(double a, int n) {
        return Math.round(a / (2 * Math.tan(Math.PI / n)));
    }

    /**
     * calculates the radius of the outer circle of a regular polygon.
     *
     * @param a = area of polygon
     * @param n = vertices
     * @return radius
     */
    public static double calculateRadiusOuterCircle(double a, int n) {
        return Math.round(a / (2 * Math.sin(Math.PI / n)));
    }
}
