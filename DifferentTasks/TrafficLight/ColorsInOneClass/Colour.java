public class Colour implements Colourable{
    private String color;
    private Colourable next;
    public static final Colour BLACK = new Colour("Black");
    public static final Colour RED = new Colour("Red");
    public static final Colour GREEN = new Colour("Green");
    static{
        BLACK.next=BLACK;
        RED.next=GREEN;
        GREEN.next=RED;
    }
    private Colour(){}
    
    public Colour(String color){
        this.color = color;
    }
    public String toString(){
        return color;
    }
    @Override
    public Colourable next(){
        return next;
    }
}
