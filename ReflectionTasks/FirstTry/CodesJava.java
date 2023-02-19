
package codesjava;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Ilia_Dukhov
 */
public class CodesJava {
    public static void main(String[] args) throws Exception{
        List<Moo> zoo = new ArrayList<>();
        while(true){
            System.out.println("1. Add new animal\n" +
                    "2. Walk through the zoo\n" +
                    "3. Exit");
            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();
            if(choose == 3) System.exit(0);
            else if(choose == 1){
                addMoo(zoo);
            }else if(choose == 2){
                for(Moo m:zoo) m.moo();
            }
        }  
    }
    public static void addMoo(List<Moo> zoo) throws Exception{
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Class cl = Class.forName("codesjava."+name);
        zoo.add((Moo)cl.newInstance());
    }
}
    
    

