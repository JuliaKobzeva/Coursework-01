public class Employee {
    private String name;

    private String name2;

    private String surname;
    private int department;
    private int salary;

    private static int counter = 1;

    private int id = counter;

    public Employee(String name, String name2, String surname, int department, int salary){
        this.name = name;
        this.name2 = name2;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
        counter++;
    }

    public String getName(){
        return name;
    }

    public String getName2(){
        return name2;
    }

    public String getSurname(){
        return surname;
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
        return name + " " + name2 + " " + surname + ", отдел № " + department + ", зарплата: " + salary + " руб";
    }

}
