package shape;

public class RegularPolygon extends AbstractShape {

    private Circle innerCircle;

    private Circle outerCircle;

    //number of sides, e. g. triangle = 3, rectangle = 4, octagon = 8
    private int vertices;

    private double sidelength;

    public RegularPolygon(double sidelength, int vertices) {
        if (vertices < 3) throw new IllegalArgumentException("There are no Polygons with less than 3 sides");
        if (sidelength <= 0) throw new IllegalArgumentException("Sidelength have to be positive");

        this.vertices = vertices;
        this.sidelength = sidelength;

        onParametersChanged();
    }

    public double getSidelength() {
        return sidelength;
    }

    public void setSidelength(double sidelength) {
        if (sidelength > 0) {
            this.sidelength = sidelength;
            onParametersChanged();
        } else {
            throw new IllegalArgumentException("Sidelength have to be positive.");
        }
    }

    public Circle getInnerCircle() {
        return innerCircle;
    }

    public Circle getOuterCircle() {
        return outerCircle;
    }

    private void setInnerCircle(Circle innerCircle) {
        this.innerCircle = innerCircle;
    }

    private void setOuterCircle(Circle outerCircle) {
        this.outerCircle = outerCircle;
    }

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        if (vertices >= 3) {
            this.vertices = vertices;
            onParametersChanged();
        } else {
            throw new IllegalArgumentException("We need at least 3 vertices to a two dimensional shape");
        }
    }

    @Override
    protected void onParametersChanged() {
        setArea((getVertices() - 2) * Triangle.calculateTriangleAreaHeronFormula(
                sidelength,
                sidelength,
                sidelength)
        );
        setInnerCircle(
                new Circle(
                        Circle.calculateRadiusInnerCircle(
                                getArea(),
                                vertices)));
        setOuterCircle(
                new Circle(
                        Circle.calculateRadiusOuterCircle(
                                getArea(),
                                vertices)));
    }
}
