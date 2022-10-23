
package pract3_3;


public class Rectangle extends Figure implements BrokenLineable {

    private int sideLength1;
    private int sideLength2;

    public Rectangle(Point startPoint, int sideLength1, int sideLength2){
        super(startPoint);
        if (sideLength1 < 0 || sideLength2 < 0) throw new IllegalArgumentException();
        this.sideLength1 = sideLength1;
        this.sideLength2 = sideLength2;
    }

    public boolean isSquare(){
        return sideLength1 == sideLength2;
    }

    public BrokenLine returnBrokenLine(){
        return new ClosedBrokenLine(getStartPoint(),
                new Point(getStartPoint().getX() + sideLength1, getStartPoint().getY()),
                new Point(getStartPoint().getX() + sideLength1, getStartPoint().getY() - sideLength2),
                new Point(getStartPoint().getX(), getStartPoint().getY() - sideLength2));
    }

    public int getSideLength1() {
        return sideLength1;
    }

    public void setSideLength1(int sideLength1) {
        if (sideLength1 < 0) throw new IllegalArgumentException();
        this.sideLength1 = sideLength1;
    }

    public int getSideLength2() {
        return sideLength2;
    }

    public void setSideLength2(int sideLength2) {
        if (sideLength2 < 0) throw new IllegalArgumentException();
        this.sideLength2 = sideLength2;
    }

    @Override
    public int area() {
        return sideLength1 * sideLength2;
    }
}