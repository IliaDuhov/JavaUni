
package Singleton;


public class Black implements Colourable{
    private static Black black;
    public String toString(){
        return "Black";
    }
    @Override
    public Black nextColour(){
        return this;
    }
    private Black(){}
    public static Black getBlack(){
        if(black == null){
            black = new Black();
        }
        return black;
    }
   
}
