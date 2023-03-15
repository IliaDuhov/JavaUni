/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codesjava;

/**
 *
 * @author Ilia_Dukhov
 */
@Validate({HumanTest.class})
public class Human {
    private int age;
    private int height;

    public Human(int age, int height) {
        this.age = age;
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }
    
    
}
