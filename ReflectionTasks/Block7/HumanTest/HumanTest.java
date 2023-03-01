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
    public void check(Human human) throws Exception{
        if(human.getAge()>130){
            throw new IllegalArgumentException("возраст слишком большой");
        }
    }
}
