public class MidPhoneNumberOptionSelector implements OptionSelector{
    String key;
    String value;

    public MidPhoneNumberOptionSelector(String value){
        this.key = "phoneNumber";
        this.value = value.split("-")[1];
    }

    public MidPhoneNumberOptionSelector(String key, String value){
        this.key = "phoneNumber";
        this.value = value.split("-")[1];
    }

    @Override
    public boolean match(Employee employee) {
        if(employee.getValue(key).split("-")[1].equals(value))
            return true;
        return false;
    }
}
