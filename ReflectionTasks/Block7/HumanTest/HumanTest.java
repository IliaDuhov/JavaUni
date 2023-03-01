package codesjava;

/**
 *
 * @author Ilia_Dukhov
 */
public class HumanTest {
    public void check(Human human) throws Exception{
        if(human.getAge()>130){
            throw new IllegalArgumentException("возраст слишком большой");
        }
    }
}
