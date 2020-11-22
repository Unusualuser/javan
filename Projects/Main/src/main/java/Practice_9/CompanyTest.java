package Practice_9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

class CompanyTest {

    public static void main(String[] args) {

        Company company = new Company();
        Random r = new Random(2000);

        for (int i=0; i < 60; i++) {
            company.hire(new Employee(
                    "Tor",
                    "Opera",
                    (LocalDate.of(r.nextInt(70) + 1950, r.nextInt(11) + 1, r.nextInt(28) + 1)),
                    "Moscow",
                    "88005553535",
                    ((int) (30000 + Math.random() * 10000)),
                    new Operator()));
        }

        company.HandleEmployees(new Selector() {
                                    @Override
                                    public boolean isNeedEmployee(Employee employee) {
                                        return employee.getDateOfBorn().getDayOfYear() > 180;
                                    }
                                }, new Handler() {
                                    @Override
                                    public void handleEmployee(Employee employee) {
                                        System.out.println(employee.getDateOfBorn());
                                    }
                                }
        );


        ArrayList <Employee> selected = new ArrayList<>();
        company.HandleEmployees(
                employee -> ((2020 - employee.getDateOfBorn().getYear()) < 18),
                selected::add);

        System.out.println();

        for(Employee employee: selected) {
            System.out.println((2020 - employee.getDateOfBorn().getYear()));
        }

        System.out.println();

        MonthSelector monthSelector = new MonthSelector(4);
        company.HandleEmployees(new MonthSelector(3), (employee -> System.out.println(employee.getDateOfBorn())));
    }
}