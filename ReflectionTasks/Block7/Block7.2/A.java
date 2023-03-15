/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codesjava;

import java.util.List;

/**
 *
 * @author Ilia_Dukhov
 */
@ToString(YesOrNo.Yes)
public class A extends Entity{
    @ToString(YesOrNo.Yes)
    private String s = "hello,there";
    @ToString(YesOrNo.No)
    private int aa = 11;
    @Invoke
    public void testAnnoA(){
        System.out.println("lucky A");
    }
    
}
