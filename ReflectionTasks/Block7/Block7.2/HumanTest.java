/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codesjava;

/**
 *
 * @author Ilia_Dukhov
 */
public class HumanTest {
    public void checkAge(Human human)throws Exception{
        if(human.getAge()>120){
            throw new IllegalArgumentException("TOO OLD");
        }
    }
    public void checkHeight(Human human){
        if(human.getHeight()>270){
            throw new IllegalArgumentException("TOO HIGH");
        }
    }
}
