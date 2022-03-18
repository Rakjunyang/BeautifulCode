public class DayBirthDayOptionSelector implements OptionSelector{
    String key;
    String value;

    public DayBirthDayOptionSelector(String value){
        this.key = "birthDay";
        this.value = value.substring(6, 8);
    }

    public DayBirthDayOptionSelector(String key, String value){
        this.key = "birthDay";
        this.value = value.substring(6, 8);
    }

    @Override
    public boolean match(Employee employee) {
        if(employee.getValue(key).substring(6, 8).equals(value))
            return true;
        return false;
    }

}
