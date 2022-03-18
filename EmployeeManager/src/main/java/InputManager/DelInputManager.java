package InputManager;

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
    public Operator getOperator(OptionSelector optionSelector) {
        return new DelOperator(optionSelector);
    }
}
