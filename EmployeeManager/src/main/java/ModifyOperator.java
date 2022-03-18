public class ModifyOperator implements Operator {

    InputManager inputManager;
    OptionSelector optionSelector;

    public ModifyOperator(InputManager inputManager, OptionSelector optionSelector) {
        this.inputManager = inputManager;
        this.optionSelector = optionSelector;
    }

    @Override
    public String executeOperator() {
        return null;
    }
}
