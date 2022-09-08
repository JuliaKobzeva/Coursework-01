public class Employee {
    private String name;
    private int department;
    private int salary;

    private static int counter = 1;

    private int id = counter;

    public Employee(String name, int department, int salary){
        this.name = name;
        this.department = department;
        this.salary = salary;
        counter++;
    }

    public String getName(){
        return name;
    }

    public int getDepartment(){
        return department;
    }

    public int getSalary(){
        return salary;
    }

    public void setDepartment(int department){
        this.department = department;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return name + ", отдел № " + department + ", зарплата: " + salary + " руб";
    }

}
