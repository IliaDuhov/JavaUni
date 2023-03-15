
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
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Ilia_Dukhov
 */
public class CodesJava {
    public static void main(String[] args) throws Exception{
        C c = new C();
//        System.out.println(fieldCollection(c));
        //System.out.println(collector(C.class));
        A a = new A();
        System.out.println(a);
        Human h = new Human(200, 20000);
        validate(h);
        
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
    
    
    public static void validate(Object...object) throws Exception{
        Class<?> clz = object.getClass();
        if(!clz.isAnnotationPresent(Validate.class)){
            return;
        }
        Method[] marr = clz.getDeclaredMethods();
        if(clz.isAnnotationPresent(Validate.class)){
            Validate val = clz.getDeclaredAnnotation(Validate.class);
            Class[] testClass = val.value();
            for(Method method:clz.getDeclaredMethods()){
                method.invoke(clz.newInstance(), testClass[0].getDeclaredMethod("checkAge").invoke(null));
            }
            
        }
    }
//    for(Method method: clz.getDeclaredMethods()){
//                Validate val = clz.getDeclaredAnnotation(Validate.class);
//                Class[] testClass = val.value();
//                Method[] marr = testClass[0].getDeclaredMethods();
//                for(Method meth: marr){
//                    meth.invoke(clz.newInstance(),testClass[0].getMethod("checkHeight").invoke(null), testClass[0].getMethod("checkAge").invoke(null));
//                }
//            }
    
    
    public static Map<String, Object> collector(Class clz) throws Exception{
        Map<String, Object> map = new HashMap<>();
        List<Method> methods = new ArrayList<>(Arrays.asList(clz.getDeclaredMethods()));
        for(Method method :methods){
            if(method.isAnnotationPresent(Invoke.class)){
                method.setAccessible(true);
                map.put(method.getName(), method.invoke(clz.newInstance()));
            }
        }
        return map;
    }
    
    
    public static void reset(Object someObject) throws Exception {
        List<Field> fields = new ArrayList<>();
        Class<?> defaultClass;
        Class<?> objClass = someObject.getClass();

        while (objClass.getSuperclass() != Object.class){
            objClass = objClass.getSuperclass();
            fields.addAll(Arrays.stream(objClass
                    .getDeclaredFields())
                    .filter(field -> field.isAnnotationPresent(Default.class))
                    .toList());
        }

        if (someObject.getClass().isAnnotationPresent(Default.class)){
            fields.addAll(Arrays.asList(someObject.getClass()
                    .getDeclaredFields()));
            defaultClass = someObject.getClass().getAnnotation(Default.class).value();
        } else {
            fields.addAll(Arrays.stream(someObject.getClass()
                    .getDeclaredFields())
                    .filter(field -> field.isAnnotationPresent(Default.class))
                    .toList());
            defaultClass = null;
        }

        for (Field field : fields) {
            field.setAccessible(true);
            if (defaultClass == null){
                field.set(someObject, field.getAnnotation(Default.class).value()
                     .getDeclaredField(field.getName()).get(null));
            } else {
                field.set(someObject, defaultClass.getDeclaredField(field.getName()).get(null));
            }
        }

    }
}
    
    

