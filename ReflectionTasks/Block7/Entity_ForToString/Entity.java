
package codesjava;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.jshell.spi.ExecutionControl;

/**
 *
 * @author Ilia_Dukhov
 */
public class Entity {

    @Override
    public String toString() {
        String resStr = "{";
        Class<?> obj = this.getClass();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(obj.getDeclaredFields()));
        while(obj.getSuperclass() != Object.class){
            obj = obj.getSuperclass();
            fieldList.addAll(Arrays.asList(obj.getDeclaredFields()));
        }
        if(fieldList.isEmpty()){
            return "{}";
        }
        for(Field field: fieldList){
            field.setAccessible(true);
            try {
                resStr += field.getName().toString();//name of field
                resStr += "=";
                resStr += field.get(this).toString();//value of field
                resStr += " ";
                //READ ABOUT STRINGBUILDER AND RETURN LATER
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Entity.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Entity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        resStr += "}";
        return resStr;
    }
    
}
