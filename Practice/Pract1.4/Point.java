
package pract1_4;


public class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format("{%d;%d}", x, y);
    }
}

