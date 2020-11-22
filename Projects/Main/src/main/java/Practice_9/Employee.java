package Practice_9;

import java.time.LocalDate;

public class Employee {
    private final String name;
    private final String surname;
    private final LocalDate dateOfBorn;
    private String placeLive;
    private String phoneNumber;
    private double salary;
    private double fullSalary;
    private EmployeePosition position;

    public Employee(String name, String surname, LocalDate dateOfBorn, String placeLive, String phoneNumber, double salary, EmployeePosition position) {
        this.name = name;
        this.surname = surname;
        this.dateOfBorn = dateOfBorn;
        this.placeLive = placeLive;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.position = position;
    }

    public void setPlaceLive(String placeLive) {
        this.placeLive = placeLive;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
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

    public LocalDate getDateOfBorn() {
        return dateOfBorn;
    }

    public String getPlaceLive() {
        return placeLive;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getFullSalary() {
        return fullSalary;
    }

    public void setFullSalary(double fullSalary) {
        this.fullSalary = fullSalary;
    }
}
