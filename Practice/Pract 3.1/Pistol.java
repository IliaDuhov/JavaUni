
public class Pistol {
    private final int maxAmmo;
    private int currentAmmo;
    public Pistol(){
        this(5);
    }
    public Pistol(int maxAmmo){
        this.maxAmmo = maxAmmo;
    }
    public Pistol(int currentAmmo, int maxAmmo){
        this.maxAmmo = maxAmmo;
        this.currentAmmo = currentAmmo;
        if(currentAmmo > maxAmmo) throw new IllegalArgumentException("More than maxAmmo");
    }
   
    public int reloadGun(int ammo){
        if(ammo<0) throw new IllegalArgumentException("impossible to load neagative number");
        if(ammo>maxAmmo){
            currentAmmo = maxAmmo;
            return ammo - maxAmmo;
        }
        currentAmmo += ammo;
        return 0;
    }
    public int unload(){
        int ammoToUnload = currentAmmo;
        currentAmmo = 0;
        return ammoToUnload;
    }
    
    public void shoot(){
        if(currentAmmo > 0){
            System.out.println("Bax");
            currentAmmo --;
        }else if(currentAmmo <= 0){
            System.out.println("Clack");
        }
    }
    
    public int getMaxAmmo(){
        return maxAmmo;
    }
    public int isLoadedAmmo(){
        return currentAmmo;
        
    }
    public boolean isLoadedInGeneral(){
        if(currentAmmo>0) return true;
        return false;
    }
}
