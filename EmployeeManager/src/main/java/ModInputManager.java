import java.util.List;

public class ModInputManager implements InputManagerInterface {

    List<String> options;
    String key;
    String value;
    String chgKey;
    String chgValue;

    ModInputManager(List<String> data) {
        options = data.subList(1, 4);
        key = data.get(4);
        value = data.get(5);
        chgKey = data.get(6);
        chgValue = data.get(7);

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
        return chgKey;
    }

    @Override
    public String getChgValue() {
        return chgValue;
    }
}
