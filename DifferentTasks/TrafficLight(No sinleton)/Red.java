public class Red implements Colourable{
    public String toString(){
        return "Red";
    }
    @Override
    public Green nextColour(){
        return new Green();
    }
}
