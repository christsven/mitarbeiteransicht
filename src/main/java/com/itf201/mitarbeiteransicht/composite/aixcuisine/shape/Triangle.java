package com.itf201.mitarbeiteransicht.composite.aixcuisine.shape;

public class Triangle extends AbstractShape {

    private final String ERROR_MESSAGE = "Sidelength %s doesnt work with sides %s, %s";
    private double a;
    private double b;
    private double c;
    private double circumference;

    public Triangle(double sideA, double sideB, double sideC) {
        if (!valideSidelengths(sideA, sideB, sideC)) throw new IllegalArgumentException("Lengths are invalid");
        a = sideA;
        b = sideB;
        c = sideC;
        onParametersChanged();
    }

    @Override
    protected void onParametersChanged() {
        setArea(calculateTriangleAreaHeronFormula(a, b, c));
        setCircumference(a + b + c);
    }

    /**
     * calculates if three given sides can be connected to a triangle
     *
     * @return if a triangle can be created with the given sidelengths
     */
    private static boolean valideSidelengths(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public void setA(double sideA) {
        if (valideSidelengths(sideA, b, c)) {
            this.a = sideA;
            onParametersChanged();
        } else throw new IllegalArgumentException(String.format(ERROR_MESSAGE, sideA, b, c));
    }

    public void setB(double sideB) {
        if (valideSidelengths(a, sideB, c)) {
            this.b = sideB;
            onParametersChanged();
        } else throw new IllegalArgumentException(String.format(ERROR_MESSAGE, sideB, a, c));
    }

    public void setC(double sideC) {
        if (valideSidelengths(a, b, sideC)) {
            this.c = sideC;
            onParametersChanged();
        } else throw new IllegalArgumentException(String.format(ERROR_MESSAGE, sideC, b, a));
    }

    public void setCircumference(double circumference) {
        if (circumference > 0) this.circumference = circumference;
        else throw new IllegalArgumentException("Circumference has to be greater than 0.");
    }

    public double getCircumference() {
        return circumference;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    /**
     * calculates the area of a triangle given by its three sides.
     *
     * @param a,b,c = the three sides of the triangle
     * @return the area of the given triangle
     */
    public static double calculateTriangleAreaHeronFormula(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.round(Math.sqrt(s * (s - a) * (s - b) * (s - c)));
    }
}
