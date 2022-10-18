
package pract3_2;

public class Rifle extends Pistol{
    private final int ammoPerSec;
    public Rifle(){
        this(30,30);
    }
    public Rifle(int maxAmmo, int ammoPerSec){
        super(maxAmmo);
        if(ammoPerSec < 0) throw new IllegalArgumentException(ammoPerSec + " is not possible rate of fire");
        this.ammoPerSec = ammoPerSec;
    }
    @Override
    public void shoot(){
        for(int i = 0; i<ammoPerSec; i++){
            super.shoot();
        }
    }
    public void shoot(int secs){
        for (int i = 0; i < ammoPerSec * secs; i++){
            super.shoot();
        }
    }
    
}
