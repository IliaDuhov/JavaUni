/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codesjava;

import java.awt.Point;
import java.lang.annotation.Inherited;

/**
 *
 * @author Ilia_Dukhov
 */

public class C extends B{
    private int c;
    private int cc;
    private String str;
    
    @Invoke
    public int testAnnoC3(){
        return 42;
    }
    @Invoke
    public String testAnnoC2(){
        return "lucky C2";
    }
}
