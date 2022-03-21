public class LastNameOptionSelector implements OptionSelector{
    EmployeeColumn key;
    String value;

    public LastNameOptionSelector(String value){
        this.key = EmployeeColumn.NAME;
        this.value = value;
    }

    public LastNameOptionSelector(EmployeeColumn key, String value){
        this.key = EmployeeColumn.NAME;
        this.value = value;
    }

    @Override
    public boolean match(Employee employee) {
        if(employee.getValue(key).substring(employee.getValue(key).indexOf(" ")+1).equals(value))
            return true;
        return false;
    }
}
