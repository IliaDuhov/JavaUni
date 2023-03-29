/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Artem;


public class Song {
    private String name;
    private String author;
    private Album album;

    public Song(String name, String author, Album album) {
        this.name = name;
        this.author = author;
        this.album = album;
    }

    public Song(String name, String author) {
        this.name = name;
        this.author = author;
    }
    

    public String getName(){
        return name;
    }
    
    @Override
    public String toString(){
        return String.format("name: %s, author: %s, album: %s", name, author, album);
    }
}
