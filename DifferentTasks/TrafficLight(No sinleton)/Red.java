/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleton;


public class Red implements Colourable{
    public String toString(){
        return "Red";
    }
    @Override
    public Green nextColour(){
        return new Green();
    }
}
