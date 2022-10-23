
package pract3_3;

/**
 *
 * @author Ilia_Dukhov
 */
public interface Meowable {
    default void doMeow(){
        System.out.println("Meow");
    }
}
