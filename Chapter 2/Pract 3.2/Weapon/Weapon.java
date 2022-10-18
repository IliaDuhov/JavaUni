
package pract3_2;


abstract public class Weapon {
    private int ammo;
    
    public Weapon(int ammo){
        if (ammo == 0) throw new RuntimeException();
        this.ammo = ammo;
    }
    abstract void shoot();
    
    public int ammo(){
        return ammo;
    }
    
    public boolean getAmmo(){
        if(ammo==0) return false;
        ammo--;
        return true;
    }
    public void load(int ammo){
        if(ammo<0) throw new RuntimeException();
        this.ammo += ammo;
    }
}
