
package pract3_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class BrokenLine {
     private List<Point> points;

    public BrokenLine() {
        this(new ArrayList<>());
    }

    public BrokenLine(Point ...points) {
        this(Arrays.asList(points));
    }

    public BrokenLine(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public int length(){

        if (points.size() < 2){
            return 0;
        }

        int finalLength = 0;
        Point prevPoint = points.get(0);

        for (int i = 1; i < points.size(); i++){
            finalLength += new Line(prevPoint, points.get(i)).length();
            prevPoint = points.get(i);
        }

        return finalLength;
    }

    public void addPoint(Point ... points){
        this.points.addAll(Arrays.asList(points));
    }

    public void addPoint(ArrayList<Point> points){
        this.points.addAll(points);
    }

    public Point getPoint(int index) {
        return new Point(points.get(index));
    }

    public void setPoints(Point point) {
        this.points = new ArrayList<>(points);
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public void setPoint(int index, Point point) {
        points.set(index, new Point(point));
    }

    public int getSize(){
        return points.size();
    }

    public String toString() {
        return String.format("Линия: %s", points);
    }

}
