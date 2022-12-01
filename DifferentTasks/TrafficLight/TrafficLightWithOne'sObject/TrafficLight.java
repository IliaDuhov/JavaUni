
package Singleton;


public class TrafficLight {
    Colourable curColor = Black.getBlack();
    public void on(){
        curColor = Green.getGreen();
    }
    public void off(){
        curColor = Black.getBlack();
    }
    public String nextColor(){
        curColor = curColor.nextColour();
        return curColor.toString();
    }
}
