
package pract1_3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrokenLine {
    List<Point> points;

    public BrokenLine() {
        this.points = new ArrayList<>();
    }
    public BrokenLine(Point ...points) {
        this.points = new ArrayList<>(Arrays.asList(points));
    }

    public Point getPoint(int index) {
        return this.points.get(index);
    }

    public void setPoint(int index, Point point) {
        this.points.set(index, point);
    }

    public String toString() {
        return String.format("Линия: %s", points);
    }

    
}
