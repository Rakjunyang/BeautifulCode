public class YearBirthDayOptionSelector implements OptionSelector {
    EmployeeColumn key;
    String value;

    public YearBirthDayOptionSelector(String value){
        this.key = EmployeeColumn.BIRTHDAY;
        this.value = value;
    }

    public YearBirthDayOptionSelector(EmployeeColumn key, String value){
        this.key = EmployeeColumn.BIRTHDAY;
        this.value = value;
    }

    @Override
    public boolean match(Employee employee) {
        if(employee.getValue(key).substring(0, 4).equals(value))
            return true;
        return false;
    }
}
