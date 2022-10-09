public class Department {
    private String name;
    private Employee head;
    ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void addEmploy(Employee employee){
        this.employees.add(employee);
    }

    public void removeEmploy(Employee employee){
        this.employees.remove(employee);
    }

    public ArrayList<Employee> getEmployees(){
        return this.employees;
    }
}
