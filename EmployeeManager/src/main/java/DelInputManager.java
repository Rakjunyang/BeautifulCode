import java.util.List;

public class DelInputManager implements InputManagerInterface {

    List<String> options;
    String key;
    String value;

    DelInputManager(List<String> data) {
        options = data.subList(1, 4);
        key = data.get(4);
        value = data.get(5);
    }

    @Override
    public List<String> getOptions() {
        return options;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }
}
