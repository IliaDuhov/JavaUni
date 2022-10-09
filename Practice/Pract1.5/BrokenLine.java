package pract1_5;

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
    
    public void addPoint(Point ... points){
        this.points.addAll(Arrays.asList(points));
    }

    public void addPoint(ArrayList<Point> points){
        this.points.addAll(points);
    }
    
    public void setPoint(int index, Point point){
        this.points.set(index, point);
    }
    
    public Point getPoints(int index){
       return this.points.get(index);
    }
    
    public int length(){

        if (points.size() < 2){
            return 0;
        }

        int finalLength = 0;
        Point prevPoint = points.get(0);

        for (int i = 1; i < points.size(); i++){
            finalLength += new Line(prevPoint, points.get(i)).length;
            prevPoint = points.get(i);

        }

        return finalLength;
    }
}
