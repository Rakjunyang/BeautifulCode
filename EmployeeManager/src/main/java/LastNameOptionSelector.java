public class LastNameOptionSelector implements OptionSelector{
    String key;
    String value;

    public LastNameOptionSelector(String value){
        this.key = "name";
        this.value = value.substring(value.indexOf(" ")+1);
    }

    public LastNameOptionSelector(String key, String value){
        this.key = "name";
        this.value = value.substring(value.indexOf(" ")+1);
    }

    @Override
    public boolean match(Employee employee) {
        if(employee.getValue(key).substring(employee.getValue(key).indexOf(" ")+1).equals(value))
            return true;
        return false;
    }
}
