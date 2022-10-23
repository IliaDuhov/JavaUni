
package pract3_3;

public class Triangle extends Figure implements BrokenLineable{

    private Point secondPoint;
    private Point thirdPoint;

    public Triangle(Point startPoint, Point secondPoint, Point thirdPoint){
        super(startPoint);
        this.secondPoint = new Point(secondPoint);
        this.thirdPoint = new Point(thirdPoint);
    }

    public Point getSecondPoint() {
        return new Point(secondPoint);
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = new Point(secondPoint);
    }

    public Point getThirdPoint() {
        return new Point(thirdPoint);
    }

    public void setThirdPoint(Point thirdPoint) {
        this.thirdPoint = new Point(thirdPoint);
    }

    @Override
    public int area() {
        return (int) (0.5 * Math.abs(
                (secondPoint.getX()-getStartPoint().getX()) * (thirdPoint.getY()-getStartPoint().getY()) -
                        (thirdPoint.getX()-getStartPoint().getX()) * (secondPoint.getY()-getStartPoint().getY())));
    }
    @Override
    public BrokenLine returnBrokenLine() {
        return new ClosedBrokenLine(getStartPoint(), secondPoint, thirdPoint);
    }
}
