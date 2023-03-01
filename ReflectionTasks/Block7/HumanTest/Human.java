/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codesjava;

/**
 *
 * @author Ilia_Dukhov
 */
public class Human {
    private int age;

    public Human(int age) {
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public String toString(){
        return String.format("Human age is %d", age);
    }
}
