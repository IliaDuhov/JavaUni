
package pract1_4;

/**
 *
 * @author Ilia_Dukhov
 */
public class Human {
    private Name name;
    private int height;
    private Human parent;

    public Human(String name, int height) {
        this(new Name(name), height, null);
    }

    public Human(String name, int height, Human parent) {
        this(new Name(name), height, parent);
    }
    
    public Human(Name name, int height) {
        this(name, height, null);
    }

    public Human(Name name, int height, Human parent) {
        this.name = name;
        this.height = height;
        this.parent = parent;
        checkParentSecondname();
    }

    private void checkParentSecondname() {
        if (this.name.secondname == null && !(this.parent.name.name == null)) {
            this.name.secondname = parent.name.name + "ович";
        }
    }

    public String toString() {
        return String.format("%s, рост: %d", name, height);
    }

    public void setParent(Human parent) {
        this.parent = parent;
        checkParentSecondname();
    }
}
