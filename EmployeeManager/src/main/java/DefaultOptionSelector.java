public class DefaultOptionSelector implements OptionSelector {

    String key;
    String value;

    public DefaultOptionSelector(String key, String value) {
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
