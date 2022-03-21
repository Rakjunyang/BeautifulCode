public class LastPhoneNumberOptionSelector implements OptionSelector{
    String key;
    String value;

    public LastPhoneNumberOptionSelector(String value){
        this.key = "phoneNumber";
        this.value = value.split("-")[2];
    }

    public LastPhoneNumberOptionSelector(String key, String value){
        this.key = "phoneNumber";
        this.value = value.split("-")[2];
    }

    @Override
    public boolean match(Employee employee) {
        if(employee.getValue(key).split("-")[2].equals(value))
            return true;
        return false;
    }
}
