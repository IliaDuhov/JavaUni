public class Green implements Colourable{
    public String toString(){
        return "Red";
    }
    @Override
    public Red nextColour(){
        return new Red();
    }
}
