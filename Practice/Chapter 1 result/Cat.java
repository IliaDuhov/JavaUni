
import java.util.ArrayList;
import java.util.List;

public class Cat {
    String name;
    public Cat(String name){
        this.name = name;
    }
    public void doMeow(){
        System.out.println(name + ": meow");
    }
    public void doMeow(int x){
        ArrayList<String> meow = new ArrayList<>();
        while(x!=0){
            meow.add("meow");
            x--;
        }
        System.out.printf("%s: %s!", name,String.join("-", meow));
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return String.format("Cat: %s", name);
    }

}

