/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 * @author Melancholia312
 */
public class Entity {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
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
            String name = field.getName();
            String value = "";
            try{
                value = field.get(this).toString();
            }catch(IllegalArgumentException e){
                throw new RuntimeException(e);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Entity.class.getName()).log(Level.SEVERE, null, ex);
            }
            sb.append(String.format("%s = %s", name, value));
        }
        sb.insert(0, "{");
        sb.replace(sb.length()-2, sb.length(), "}");
        
        return sb.toString();
    }
    
}
