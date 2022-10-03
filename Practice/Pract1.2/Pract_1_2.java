
package pract_1_2;


public class Pract_1_2 {

    public static void main(String[] args) {
        Name n1 = new Name("Иван", "Чудов");
        Name n2 = new Name("Пётр", "Чудов");
        Name n3 = new Name("Борис");
        Human h1 = new Human(n1,0);
        Human h2 = new Human(n2,0,h1);
        Human h3 = new Human(n3,0,h2);
        System.out.println(h2);
        System.out.println(h3);
    }
  
}