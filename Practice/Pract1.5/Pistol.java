
package pract1_5;

public class Pistol {
    int bullet;
    public Pistol(){
        this(5);
    }
    public Pistol(int bullet){
        this.bullet = bullet;
    }
    public void shoot(){
        if(bullet > 0){
            System.out.println("Bax");
            bullet --;
        }else if(bullet <= 0){
            System.out.println("Clack");
        }
    }
    
}

