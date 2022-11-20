
package repeaettest;


public class Cuckoo extends Bird{
    @Override
    public void sing() {
        int random_int = (int)Math.floor(Math.random()*(10)+1);
        for (int i = 0; i < random_int; i++){
            System.out.println("ку-ку");
        }
    }
}
