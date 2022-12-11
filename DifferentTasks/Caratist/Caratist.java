import java.util.ArrayList;
import java.util.Arrays;


public class Caratist {

    final String name;
    ArrayList<Able> ables = new ArrayList<>();

    public Caratist(String name){
        this.name = name;
    }
    
    public void setAbles(Able... ables){
        this.ables = new ArrayList<>(Arrays.asList(ables));
    }
    
    public void fight(){
        for(Able able : ables){
            System.out.print(name + ": ");
            able.go();
        }
    }
}

