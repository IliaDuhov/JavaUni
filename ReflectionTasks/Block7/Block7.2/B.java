/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codesjava;

import java.lang.annotation.Inherited;

/**
 *
 * @author Ilia_Dukhov
 */

public class B extends A{
    private int b = 2;
    private int bb = 11;
    @Invoke
    public void testAnnoB(){
        return;
    }
    
    public String testAnnoB3(){
        return "lucky B2";
    }
}
