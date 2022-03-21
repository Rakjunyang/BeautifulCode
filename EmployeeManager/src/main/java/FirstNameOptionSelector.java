public class FirstNameOptionSelector implements OptionSelector{
    EmployeeColumn key;
    String value;

    public FirstNameOptionSelector(String value){
        this.key = EmployeeColumn.NAME;
        this.value = value;
    }

    public FirstNameOptionSelector(EmployeeColumn key, String value){
        this.key = EmployeeColumn.NAME;
        this.value = value;
    }

    @Override
    public boolean match(Employee employee) {
        if(employee.getValue(key).substring(0, employee.getValue(key).indexOf(" ")).equals(value))
            return true;
        return false;
    }
}
