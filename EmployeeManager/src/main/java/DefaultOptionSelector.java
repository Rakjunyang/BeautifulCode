public class DefaultOptionSelector implements OptionSelector {

    EmployeeColumn key;
    String value;

    public DefaultOptionSelector(EmployeeColumn key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean match(Employee employee) {
        if (employee.getValue(key).equals(value)) {
            return true;
        }
        return false;
    }
}
