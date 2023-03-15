/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codesjava;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Ilia_Dukhov
 */
public class Entity {
    @Override
    public String toString() {
        String resStr = "{";
        Class<?> obj = this.getClass();
        List<Field> fieldList = new ArrayList<>(Arrays.asList());
        if(obj.isAnnotationPresent(ToString.class)){
            fieldList.addAll(Arrays.asList(obj.getDeclaredFields()));
        }else{
            for(Field field: obj.getDeclaredFields()){
                if(field.isAnnotationPresent(ToString.class)){
                    ToString anno = field.getDeclaredAnnotation(ToString.class);
                    Enum testValue = anno.value();
                    if(testValue != YesOrNo.No){
                        fieldList.add(field);
                    }
                }       
            }
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
                resStr += ";";
            } catch (IllegalArgumentException ex) {
                throw new RuntimeException();
            } catch (IllegalAccessException ex) {
                throw new RuntimeException();
            }
        }
        resStr += "}";
        return resStr;
    }

}
