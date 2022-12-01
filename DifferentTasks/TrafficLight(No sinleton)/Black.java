public class Black implements Colourable{
    public String toString(){
        return "Black";
    }
    @Override
    public Black nextColour(){
        return this;
    }
}
