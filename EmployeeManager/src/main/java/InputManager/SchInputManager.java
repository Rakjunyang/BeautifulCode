package InputManager;

import java.util.Arrays;

public class SchInputManager implements InputManager {

    String[] Options;
    String Key;
    String Value;
    Object Operator;

    SchInputManager(String[] data) {
        Options = Arrays.copyOfRange(data, 1, 4);
        Key = data[4];
        Value = data[5];
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
}
