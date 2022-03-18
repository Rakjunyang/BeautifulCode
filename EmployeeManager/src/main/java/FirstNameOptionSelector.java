public class FirstNameOptionSelector implements OptionSelector{
    String key;
    String value;

    public FirstNameOptionSelector(String value){
        this.key = "name";
        this.value = value.substring(0, value.indexOf((" ")));
    }

    public FirstNameOptionSelector(String key, String value){
        this.key = "name";
        this.value = value.substring(0, value.indexOf((" ")));
    }

    @Override
    public boolean match(Employee employee) {
        if(employee.getValue(key).substring(0, employee.getValue(key).indexOf(" ")).equals(value))
            return true;
        return false;
    }
}
