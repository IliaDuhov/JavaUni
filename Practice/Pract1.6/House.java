
package pract1_6;

/**
 *
 * @author Ilia_Dukhov
 */
public class House {
    private final int floor;

    public House(int floor) {
        if(floor<0){
            throw new IllegalArgumentException("Not possible to enetr less, than 1 floor");
        }
        this.floor = floor;
    }

    public String toString() {
        if(floor % 10 == 1){
            return String.format("Дом с %d этажом", floor);
        }else{
            return String.format("Дом с %d этажами", floor);
        }
    }
}
