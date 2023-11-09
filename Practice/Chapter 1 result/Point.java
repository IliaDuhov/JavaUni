
public class Point {
    private int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
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
    @Override
    public boolean equals(Object o) {
        if (this == null) return false;
        if (this == o) return true;
        if (o.getClass() != Point.class) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }
}
