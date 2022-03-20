import java.util.List;

public class AddInputManager implements InputManagerInterface {
    List<String> infos;

    public AddInputManager(List<String> data) {
        infos = data.subList(4, 10);
    }

    @Override
    public Operator getOperator(OptionSelector optionSelector) {
        return new AddOperator(optionSelector);
    }
}
