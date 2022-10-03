
package pract1_3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pract1_3 {

    public static void main(String[] args) {
       Student s1 = new Student("Vasek", 3,4,5);
       Student s2 = new Student("Pete", List.copyOf(s1.marks));
       s2.setMark(0, 5);
       Student s3 = new Student("Andrey", List.copyOf(s1.marks));
       s1.setMark(0, 5);
       
       Point p1 = new Point(1, 5);
       Point p2 = new Point(2, 8);
       Point p3 = new Point(5, 3);
       BrokenLine bl = new BrokenLine(p1,p2,p3);
       System.out.println(bl);
       Point p4 = new Point(2, -5);
       Point p5 = new Point(4, -8);
       BrokenLine bl2 = new BrokenLine(p1,p4,p5,p3);
       System.out.println(bl2);
       p1.x = 2;
       p1.y = 6;
       System.out.println(bl2);
    }
    
}
