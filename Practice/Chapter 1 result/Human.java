
package pract1_6;


public class Human {
    private Name name;
    private int height;
    private final Human parent;

    public Human(Human human){
        this(human.name, human.height, human.parent);
    }

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

        if (height < 0 || height > 500){
            throw new IllegalArgumentException("Such height is impossible");
        }

        this.name = name;
        this.height = height;
        this.parent = parent;
        checkParentSetSecondname();
    }

    private void checkParentSetSecondname() {

        if (this.parent == null){
            return;
        }
        if (this.name.getSurname().isEmpty() && !(this.parent.name.getSurname().isEmpty())) {
            this.name.setSurname(parent.name.getSurname());
        }
        if (this.name.getSecondname().isEmpty() && !(this.parent.name.getName().isEmpty())) {
            this.name.setSecondname(parent.name.getName() + "ович");
        }
    }

    public String toString() {
        return String.format("%s, рост: %d", name, height);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height < 0 || height > 500){
            throw new IllegalArgumentException("Such height is impossible");
        }
        this.height = height;
    }

    public Human getParent() {
        return new Human(parent);
    }

    public Name getName() {
        return name;
    }
}
