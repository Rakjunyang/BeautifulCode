public class YearBirthDayOptionSelector implements OptionSelector {
    EmployeeColumn key;
    String value;

    public YearBirthDayOptionSelector(String value){
        this.key = EmployeeColumn.BIRTHDAY;
        this.value = value.substring(0, 4);
    }

    public YearBirthDayOptionSelector(EmployeeColumn key, String value){
        this.key = EmployeeColumn.BIRTHDAY;
        this.value = value.substring(0, 4);
    }

    @Override
    public boolean match(Employee employee) {
        if(employee.getValue(key).substring(0, 4).equals(value))
            return true;
        return false;
    }
}
