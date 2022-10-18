
package pract3_2;

public class Circule extends Figure{
    private int radius;

    public Circule(Point startPoint, int raadius){
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
    
    public int area() {
        return (int) (Math.PI * radius * radius);
    }
}
