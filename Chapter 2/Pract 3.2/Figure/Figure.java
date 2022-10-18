
package pract3_2;


abstract public class Figure {
    private Point startPoint;

    public Figure(Point startPoint){
        this.startPoint = new Point(startPoint);
    }

    abstract public int area();

    public Point getStartPoint() {
        return new Point(startPoint);
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = new Point(startPoint);
    }
}
