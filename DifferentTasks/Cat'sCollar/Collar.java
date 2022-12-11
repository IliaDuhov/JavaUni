package MissedTasks;


public class Collar implements CanMeow{
    
    Cat cat;
    int count;

    public Collar(Cat cat){
        this.cat = cat;
    }
    
    @Override
    public void meow() {
        count++;
        cat.meow();
    } 

    @Override
    public String toString() {
        return String.format("%s: %d ", cat.name, count);
    }    
}
