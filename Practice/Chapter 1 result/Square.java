public class Square {

    private Point startPoint;
    private int sideLength;

    public Square(Point startPoint, int sideLength){
        this(startPoint.getX(), startPoint.getY(), sideLength);
    }

    public Square(int x, int y, int sideLength){
        if (sideLength <= 0){
            throw new IllegalArgumentException();
        }
        this.sideLength = sideLength;
        this.startPoint = new Point(x, y);

    }

    public BrokenLine returnBrokenLine(){
        return new BrokenLine(startPoint,
                new Point(startPoint.getX() + sideLength, startPoint.getY()),
                new Point(startPoint.getX() + sideLength, startPoint.getY() - sideLength),
                new Point(startPoint.getX(), startPoint.getY() - sideLength));
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        if (sideLength <= 0){
            throw new IllegalArgumentException();
        }
        this.sideLength = sideLength;
    }

    public Point getStartPoint() {
        return new Point(startPoint);
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = new Point(startPoint);
    }

    public String toString() {
        return String.format("Квадрат в точке %s со стороной %d", startPoint, sideLength);
    }
}