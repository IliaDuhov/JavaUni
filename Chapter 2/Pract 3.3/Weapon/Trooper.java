
package pract3_3;

/**
 *
 * @author Ilia_Dukhov
 */
public class Trooper {
    private String name;
    private Weapon weapon;
    
    public Trooper(String name){
        this.name = name;
    }
    public void shoot(){
        if(weapon == null){
            System.out.println("I couldn't shoot");
            return;
        }
        weapon.shoot();
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Weapon getWeapon(){
        System.out.println(weapon);
        return weapon;
    }
    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }
}
