
package pract_1_2;


public class Human {
    Name name;
    int height;
    Human parent;
    
    public Human(Name name, int height) {
        this.name = name;
        this.height = height;
    }
    public Human(Name name, int height, Human parent){
        this(name,height);
        this.parent = parent;
        checkParentSecondname();
    }
    private void checkParentSecondname(){
        if (this.name.surname == null && !(this.parent.name.surname == null)) {
            this.name.surname = parent.name.surname;
        }

        if (this.name.secondname == null && !(this.parent.name.name == null)) {
            this.name.secondname = parent.name.name + "ович";
        }
    }
    
    public String toString(){
        return String.format("%s ,рост: %d", name, height);
    }
    public void setParent(Human parent) {
        this.parent = parent;
        checkParentSecondname();
    }
}
