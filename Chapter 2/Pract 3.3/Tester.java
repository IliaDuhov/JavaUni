
package pract3_3;


public class Tester {
    public static double sum(Number...numbers){
        double result = 0.0;
        for(Number number: numbers){
            result = result + number.doubleValue();
        }
        return result;
    }
    public static void singAll(Bird... birds){
        for(Bird bird: birds){
            bird.sing();
        }
    }
    public static int callculateArea(Figure...figures){
        int resultArea = 0;
        for(Figure figure:figures){
            resultArea = resultArea + figure.area();
        }
        return resultArea;
    }
    public static void doMeow(Cat...cats){
        for(Meowable cat:cats){
            cat.doMeow();
        }
    }
    public static int calculateLength(Lengthable ...lines){
        int resLength = 0;
        for (Lengthable line : lines){
            resLength += line.length();
        }
        return resLength;
    }

    public static BrokenLine createBigBrokenLine(Brokenlineable ...figures){
        BrokenLine brokenLine = new BrokenLine();
        for (Brokenlineable figure : figures){
            brokenLine.addPoint(figure.returnBrokenLine().getPoints().toArray(new Point[0]));
        }
        return brokenLine;
    }
    
}
