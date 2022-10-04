
package pract1_4;

/**
 *
 * @author Ilia_Dukhov
 */
public class House {
    final int stages;

    public House(int stages) {
        this.stages = stages;
    }

    public String toString() {
        if(stages % 10 == 1){
            return String.format("Дом с %d этажом", stages);
        }else{
            return String.format("Дом с %d этажами", stages);
        }
    }
}
