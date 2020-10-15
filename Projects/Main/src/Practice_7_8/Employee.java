package Practice_7_8;

public class Employee {
    private String name;
    private String surname;
    private double salary;
    private double fullSalary;
    private EmployeePosition position;

    public Employee(String name, String surname, double salary, EmployeePosition position) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public void setPosition(EmployeePosition position) {
        this.position = position;
    }

    public double getFullSalary() {
        return fullSalary;
    }

    public void setFullSalary(double fullSalary) {
        this.fullSalary = fullSalary;
    }
}
