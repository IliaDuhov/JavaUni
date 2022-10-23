
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
    
}
