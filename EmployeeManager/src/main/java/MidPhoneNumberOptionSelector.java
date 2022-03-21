public class MidPhoneNumberOptionSelector implements OptionSelector{
    EmployeeColumn key;
    String value;

    public MidPhoneNumberOptionSelector(String value){
        this.key = EmployeeColumn.PHONENUM;
        this.value = value;
    }

    public MidPhoneNumberOptionSelector(EmployeeColumn key, String value){
        this.key = EmployeeColumn.PHONENUM;
        this.value = value;
    }

    @Override
    public boolean match(Employee employee) {
        if(employee.getValue(key).split("-")[1].equals(value))
            return true;
        return false;
    }
}
