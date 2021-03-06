public class MonthBirthDayOptionSelector implements OptionSelector{
    EmployeeColumn key;
    String value;

    public MonthBirthDayOptionSelector(String value){
        this.key = EmployeeColumn.BIRTHDAY;
        this.value = value;
    }

    public MonthBirthDayOptionSelector(EmployeeColumn key, String value){
        this.key = EmployeeColumn.BIRTHDAY;
        this.value = value;
    }

    @Override
    public boolean match(Employee employee) {
        if(employee.getValue(key).substring(4, 6).equals(value))
            return true;
        return false;
    }
}
