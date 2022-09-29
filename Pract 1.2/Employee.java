
package pract_1_2;


public class Employee {
    String name;
    Department dep;
    public Employee(String name, Department dep) {
        this.name = name;
        this.dep = dep;
    }
    public Department getDep() {
        return dep;
    }

    public String toString() {

        if (this == dep.getBoss()){
            return String.format("%s начальник отдела - %s", name, dep.getName());
        }
        return String.format("%s работает в отделе %s, начальник которого - %s", name, dep.getName(), dep.getBoss().name);
    }
}
