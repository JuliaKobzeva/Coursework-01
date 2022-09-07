public class Employee {
    private String name;
    private int department;
    private int salary;

    public Employee(String name, int department, int salary){
        this.name = name;
        this.department = department;
        this.salary = salary;
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

    @Override
    public String toString(){
        return name + ", отдел № " + department + ", зарплата: " + salary + " руб";
    }

}
