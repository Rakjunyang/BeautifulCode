package InputManager;

import java.util.Arrays;

public class ModInputManager implements InputManager {

    String[] Options;
    String Key;
    String Value;
    String ChgKey;
    String ChgValue;
    Object Operator;

    ModInputManager(String[] data) {
        Options = Arrays.copyOfRange(data, 1, 4);
        Key = data[4];
        Value = data[5];
        ChgKey = data[6];
        ChgValue = data[7];
    }

    @Override
    public void setOperator() {

    }

    @Override
    public Object getOperator() {
        return Operator;
    }

    public String[] getOptions() {
        return Options;
    }

    public String getKey() {
        return Key;
    }

    public String getValue() {
        return Value;
    }

    public String getChgKey() {
        return ChgKey;
    }

    public String getChgValue() {
        return ChgValue;
    }
}
