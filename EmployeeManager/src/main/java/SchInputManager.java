import java.util.List;

public class SchInputManager implements InputManagerInterface {
    List<String> Options;
    String Key;
    String Value;

    public SchInputManager(List<String> data) {
        Options = data.subList(1, 4);
        Key = data.get(4);
        Value = data.get(5);
    }

    @Override
    public Operator getOperator(OptionSelector optionSelector) {
        return new SearchOpeartor(optionSelector);
    }
}
