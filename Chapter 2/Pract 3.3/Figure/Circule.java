
package pract3_3;

public class Circule extends Figure {

    private int radius;

    public Circule(Point startPoint, int radius){
        super(startPoint);
        if (radius < 0) throw new IllegalArgumentException();
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius < 0) throw new IllegalArgumentException();
        this.radius = radius;
    }

    @Override
    public int area() {
        return (int) (Math.PI * radius * radius);
    }
}