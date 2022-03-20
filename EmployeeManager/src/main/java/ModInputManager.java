import java.util.List;

public class ModInputManager implements InputManagerInterface {

    List<String> Options;
    String Key;
    String Value;
    String ChgKey;
    String ChgValue;

    ModInputManager(List<String> data) {
        Options = data.subList(1, 4);
        Key = data.get(4);
        Value = data.get(5);
        ChgKey = data.get(6);
        ChgValue = data.get(7);

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
        return ChgKey;
    }

    @Override
    public String getChgValue() {
        return ChgValue;
    }
}
