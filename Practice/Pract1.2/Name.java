
package pract_1_2;


public class Name {
    String name = "";
    String surname = ""; 
    String secondname = "";

    public Name(String name){
        this.name = name;
    }
    public Name(String name, String surname){
        this(name);
        this.surname = surname;
    }
    public Name(String name, String surname, String secondname){
        this(name, surname);//вызываем конструктор только с name и surName
        this.secondname = secondname;
    }
    public String toString(){
        return String.format("%s %s %s", name, surname, secondname);
    }
}
