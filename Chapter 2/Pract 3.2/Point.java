
package pract3_2;


public class Point {
    private int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Point(Point point){
        this(point.getX(), point.getY());
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public String toString(){
        return String.format("{%d : %d}", x,y);
    }
}
