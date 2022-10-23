
package pract3_3;

public class Pistol extends Weapon{
    private final int maxAmmo;
    
    public Pistol(int maxAmmo) {
        this(0, maxAmmo);
    }

    public Pistol(int ammo, int maxAmmo){
        super(ammo);
        if (maxAmmo < 0) throw new IllegalArgumentException();
        this.maxAmmo = maxAmmo;
    }
    @Override
    public void shoot(){
        if(ammo()>0){
            System.out.println("Bax");
            getAmmo();
        }else{
            System.out.println("Clack");
        }
    }
    @Override
    public void load(int ammo) {
        if (ammo() + ammo > maxAmmo) {
            super.load(maxAmmo - ammo());
        } else {
            super.load(ammo);
        }
    }
    public int unload(){
        int ammoToUnload = ammo();
        for (int i = 0; i < ammoToUnload; i++){
            getAmmo();
        }
        return ammoToUnload;
    }
    public int getMaxAmmo(){
        return maxAmmo;
    }
    public boolean isCharged(){
        if(ammo()>0) return true;
        return false;
    }
}