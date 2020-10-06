package Practice_9;

public class MonthSelector implements Selector{

    private int month;

    public MonthSelector(int month) {
        this.month = month;
    }

    @Override
    public boolean isNeedEmployee(Employee employee) {
        return employee.getDateOfBorn().getMonthValue() < month;
    }
}
