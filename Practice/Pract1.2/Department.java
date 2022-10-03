
package pract_1_2;


public class Department {
    String name;
    Employee boss;
    
     public Department(String name) {
        this.name = name;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }

    public Employee getBoss() {
        return boss;
    }

    public String getName() {
        return name;
    }
}
