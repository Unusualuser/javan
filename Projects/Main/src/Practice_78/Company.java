package Practice_78;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company {
    private double companyIncome;
    private List <Employee> TopManagers = new ArrayList<Employee>();
    private List <Employee> Managers = new ArrayList<Employee>();
    private List <Employee> Operators = new ArrayList<Employee>();
    private List <Employee> AllEmployees = new ArrayList<Employee>();

    public void hire(Employee employee) {
        if (employee.getPosition().getJobTitle().equals("Operator")) {
            Operators.add(employee);
            AllEmployees.add(employee);
            employee.setFullSalary(employee.getPosition().calcSalary(employee.getSalary()));
        }
        else if (employee.getPosition().getJobTitle().equals("Manager")) {
            Managers.add(employee);
            AllEmployees.add(employee);
            employee.setFullSalary(employee.getPosition().calcSalary(employee.getSalary()));
            companyIncome += ((employee.getFullSalary() - employee.getSalary()) * 20);
        }
        else if (employee.getPosition().getJobTitle().equals("TopManager")) {
            TopManagers.add(employee);
            AllEmployees.add(employee);
            employee.setFullSalary(employee.getPosition().calcSalary(employee.getSalary()));
        }
    }

    public void hireAll(Employee employee, Employee ... employees) {
        hire(employee);
        for(Employee value : employees)
            hire(value);
    }

    public void fire(Employee employee) {
        if (employee.getPosition().getJobTitle().equals("Operator")) {
            Operators.remove(employee);
            AllEmployees.remove(employee);
        }
        else if (employee.getPosition().getJobTitle().equals("Manager")) {
            Managers.remove(employee);
            AllEmployees.remove(employee);
            companyIncome -= ((employee.getFullSalary() - employee.getSalary()) * 20);
        }
        else if (employee.getPosition().getJobTitle().equals("TopManager")) {
            TopManagers.remove(employee);
            AllEmployees.remove(employee);
        }
    }

    public void firePercents(int percents) {
        int del = 100 / percents;

        Operators.sort(Comparator.comparing(Employee::getFullSalary));
        int fireNum = Operators.size() / del;
        for (int i = 0; i < fireNum; i++) {
            this.fire(Operators.get(0));
        }

        Managers.sort(Comparator.comparing(Employee::getFullSalary));
        fireNum = Managers.size() / del;
        for (int i = 0; i < fireNum; i++) {
            this.fire(Managers.get(0));
        }

        TopManagers.sort(Comparator.comparing(Employee::getFullSalary));
        fireNum = TopManagers.size() / del;
        for (int i = 0; i < fireNum; i++) {
            this.fire(TopManagers.get(0));
        }

        System.out.println(percents + "% сотрудников уволено ;(");
    }

    public double getIncome() {
        return companyIncome;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        if (count > 0 && count <= AllEmployees.size()) {
                AllEmployees.sort(Comparator.comparing(Employee::getFullSalary).reversed());
                return AllEmployees.subList(0, count);
        }
        else return null;
    }
    public List<Employee> getLowestSalaryStaff(int count) {
        if (count > 0 && count <= AllEmployees.size()) {
            AllEmployees.sort(Comparator.comparing(Employee::getFullSalary));
            return AllEmployees.subList(0, count);
        }
        else return null;
    }
}
