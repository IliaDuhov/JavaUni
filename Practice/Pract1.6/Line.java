
//package pract1_6;
//
//public class Line {
//    private Point start;
//    private Point end;
//
//    public Line(Point start, Point end) {
//        this(start.getX(), start.getY(), end.getX(), end.getY());
//    }
//
//    public Line(int x1, int y1, int x2, int y2) {
//        this.start = new Point(x1, y1);
//        this.end = new Point(x2, y2);;
//    }
//
//    public double getLength(){
//        Point p1,p2;
//        int length,res1,res2;
//        p1 = start;
//        p2 = end;
//        res1 = (p2.getX()*p2.getX() - 2*p2.getX()*p1.getX()+p1.getX()*p1.getX());
//        res2 = (p2.getY()*p2.getY() - 2*p2.getY()*p1.getY()+p1.getY()*p1.getY());
//        res1 = res1 + res2;
//        double result = Double.valueOf(res1);
//        result = Math.sqrt(result);
//        result = (int)result;
//        System.out.println(result);
//        return result;
//    }
//
//    public Point getEnd() {
//        return end;
//    }
//
//    public Point getStart() {
//        return start;
//    }
//
//    public String toString() {
//        return String.format("Линия от %s до %s", start, end);
//    } 
//}
