public class TrafficLight {
    Colourable curColor = new Black();
    public void on(){
        curColor = new Green();
    }
    public void off(){
        curColor = new Black();
    }
    public String nextColor(){
        curColor = curColor.nextColour();
        return curColor.toString();
    }
}
