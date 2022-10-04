
package pract1_4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrokenLine {
    private List<Point> points;
    
    public BrokenLine(){
        this.points = new ArrayList<>();
    }
    public BrokenLine(Point ...points){
        this.points = new ArrayList<>(Arrays.asList(points));
    }
    public BrokenLine(ArrayList<Point> points){
        this.points = new ArrayList<>(points);
    }
    public void setPoint(int index, Point point){
        this.points.set(index, point);
    }
    public Point getPoints(int index){
       return this.points.get(index);
    }
}
