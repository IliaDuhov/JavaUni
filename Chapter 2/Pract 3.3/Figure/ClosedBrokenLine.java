
package pract3_3;

import java.util.List;

public class ClosedBrokenLine extends BrokenLine {


    public ClosedBrokenLine(Point...points){
        super(points);
    }

    public ClosedBrokenLine(List<Point> points){
        super(points);
    }

    @Override
    public int length() {

        if (getPoints().size() <= 2) {
            return super.length();
        }

        return super.length() + new Line(getPoint(0), getPoint(getSize()-1)).length();
    }
}