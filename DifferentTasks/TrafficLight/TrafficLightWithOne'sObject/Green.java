
package Singleton;


public class Green implements Colourable{
    private static Green green;
    public String toString(){
        return "Green";
    }
    @Override
    public Red nextColour(){
        return Red.getRed();
    }
    private Green(){}
    public static Green getGreen(){
        if(green == null){
            green = new Green();
        }
        return green;
    }
    
}
