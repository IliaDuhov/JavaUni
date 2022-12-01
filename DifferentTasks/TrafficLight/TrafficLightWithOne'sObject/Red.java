
package Singleton;


public class Red implements Colourable{
   private static Red red;
   public String toString(){
        return "Red";
    }
    @Override
    public Green nextColour(){
        return Green.getGreen();
    }
    private Red(){}
    public static Red getRed(){
        if(red == null){
            red = new Red();
        }
        return red;
    }
   
}
