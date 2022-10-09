
package pract1_5;

/**
 *
 * @author Ilia_Dukhov
 */
public class Point {
    int x,y;
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
}
