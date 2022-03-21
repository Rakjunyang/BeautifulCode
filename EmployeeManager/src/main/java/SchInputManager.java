import java.util.List;

public class SchInputManager implements InputManagerInterface {

    List<String> options;
    String key;
    String value;

    public SchInputManager(List<String> data) {
        options = data.subList(1, 4);
        key = data.get(4);
        value = data.get(5);
    }

    @Override
    public List<String> getInfos() {
        return null;
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

    @Override
    public String getChgKey() {
        return null;
    }

    @Override
    public String getChgValue() {
        return null;
    }
}
