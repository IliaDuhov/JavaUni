
package pract3_2;


public class Rectangle extends Figure{
    private int length1;
    private int length2;

    public Rectangle(Point startPoint, int length1, int length2){
        super(startPoint);
        if (length1 < 0 || length2 < 0) throw new IllegalArgumentException();
        this.length1 = length1;
        this.length2 = length2;
    }

    public int getlLength1() {
        return length1;
    }

    public void setlLength1(int length1) {
        if (length1 < 0) throw new IllegalArgumentException();
        this.length1 = length1;
    }

    public int getlLength2() {
        return length2;
    }

    public void setlLength2(int length2) {
        if (length2 < 0) throw new IllegalArgumentException();
        this.length2 = length2;
    }

    @Override
    public int area() {
        return length1 * length2;
    }
}
