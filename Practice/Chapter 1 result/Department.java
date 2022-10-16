import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private Employee head;
    private List<Employee> employees;


    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmploy(Employee employee){
        this.employees.add(employee);
    }

    public void removeEmploy(Employee employee){
        this.employees.remove(employee);
    }

    public List<Employee> getEmployees(){
        return new ArrayList<>(employees);
    }

    public Employee getHead() {
        return head;
    }

    public void setHead(Employee head) {

        if (head == null){
            this.head = head;
            return;
        }

        if (this.head == head){
            return;
        }

        if (head.getDep() == this){
            this.head = head;
        }
        else {
            Department prevDep = head.getDep();

            if (prevDep.head == head){
                prevDep.setHead(null);
            }

            this.head = head;
            head.setDep(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}