public class LastPhoneNumberOptionSelector implements OptionSelector{
    EmployeeColumn key;
    String value;

    public LastPhoneNumberOptionSelector(String value){
        this.key = EmployeeColumn.PHONENUM;
        this.value = value;
    }

    public LastPhoneNumberOptionSelector(EmployeeColumn key, String value){
        this.key = EmployeeColumn.PHONENUM;
        this.value = value;
    }

    @Override
    public boolean match(Employee employee) {
        if(employee.getValue(key).split("-")[2].equals(value))
            return true;
        return false;
    }
}
