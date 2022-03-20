import java.util.List;

public class DelInputManager implements InputManagerInterface {

    List<String> Options;
    String Key;
    String Value;

    DelInputManager(List<String> data) {
        Options = data.subList(1, 4);
        Key = data.get(4);
        Value = data.get(5);
    }

    @Override
    public List<String> getInfos() {
        return null;
    }

    @Override
    public List<String> getOptions() {
        return Options;
    }

    @Override
    public String getKey() {
        return Key;
    }

    @Override
    public String getValue() {
        return Value;
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
