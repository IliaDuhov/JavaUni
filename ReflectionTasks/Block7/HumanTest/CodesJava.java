
package codesjava;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import Reflection.*;
import java.lang.reflect.Array;


/**
 *
 * @author Ilia_Dukhov
 */
public class CodesJava {
    public static void main(String[] args) throws Exception{
        C c = new C();
        System.out.println(fieldCollection(c));
        System.out.println(c.toString());
        Human h1 = new Human(150);
        validate(h1, HumanTest.class);
        
    }
    public static List fieldCollection(Object object){
        Class obj = object.getClass();
        List<Field> lst = new ArrayList<>(Arrays.asList(obj.getDeclaredFields()));
        while(obj.getSuperclass()!=Object.class){
            obj = obj.getSuperclass();
            lst.addAll(Arrays.asList(obj.getDeclaredFields()));
        }
        return lst;
    }
    public static void validate(Object ob, Class test)throws Exception{
        Class obj = ob.getClass();
        for(Method method:test.getDeclaredMethods()){
            method.invoke(null, obj);
        }
    }
    
}
    
    

