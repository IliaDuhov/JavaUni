/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reflection;

import FirstJavaSemestrTasks.Line;
import FirstJavaSemestrTasks.Point;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Ilia_Dukhov
 */
public class Block7_Methods {
     
//    C c = new C();
//    fieldCollection(c);
//    Line l1 = new Line(new Point(2,3), new Point(10, 7));
//    Line l2 = new Line(new Point(2,3), new Point(10, 7));
//    System.out.println(l1.equals(l2));
    public static List<Field> fieldCollection(Object obj){
        Class<?> classObj = obj.getClass();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(classObj.getDeclaredFields()));
        while(classObj.getSuperclass() != Object.class){
            classObj = classObj.getSuperclass();
            fieldList.addAll(Arrays.asList(classObj.getDeclaredFields()));
        }
        return fieldList;    
    }
    
    public static void lineConnector(Line line1, Line line2) throws Exception{
        Field endField = Line.class.getDeclaredField("end");
        endField.setAccessible(true);
        Point endPoint = (Point) endField.get(line1);
        Field startField = Line.class.getDeclaredField("start");
        startField.setAccessible(true);
        startField.set(line2, endPoint);
    }
}
