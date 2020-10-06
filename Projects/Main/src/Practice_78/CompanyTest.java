package Practice_78;

class CompanyTest {

    public static void main(String[] args) {

        Company company = new Company();

        for (int i=0; i < 180; i++) {
            company.hire(new Employee("Tor", "Opera", ((int) (30000 + Math.random() * 10000)), new Operator()));
            if (i<80) {
                company.hire(new Employee("Ger", "Mana", ((int) (50000 + Math.random() * 20000)), new Manager()));
            }
        }

        for (int i=0; i < 10; i++) {
            company.hire(new Employee("Manager", "Top", ((int) (50000 + Math.random() * 20000)), new TopManager(company)));
        }

        System.out.println(company.getIncome());

        System.out.println("The highest salaries: ");
        for (Employee employee : company.getTopSalaryStaff(13)) {
            System.out.println((int) employee.getFullSalary());
        }

        System.out.println("\n The lowest salaries: ");
        for (Employee employee : company.getLowestSalaryStaff(30)) {
            System.out.println((int) employee.getFullSalary());
        }

        System.out.println();
        company.firePercents(50);

        System.out.println("\nThe highest salaries: ");
        for (Employee employee : company.getTopSalaryStaff(13)) {
            System.out.println((int) employee.getFullSalary());
        }

        System.out.println("\nThe lowest salaries: ");
        for (Employee employee : company.getLowestSalaryStaff(30)) {
            System.out.println((int) employee.getFullSalary());
        }


        System.out.println(company.getIncome());
    }
}