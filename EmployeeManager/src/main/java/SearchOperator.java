public class SearchOperator implements Operator {

    InputManager inputManager;
    OptionSelector optionSelector;

    public SearchOperator(InputManager inputManager, OptionSelector optionSelector) {
        this.inputManager = inputManager;
        this.optionSelector = optionSelector;
    }

    @Override
    public String executeOperator() {
        return null;
    }
}
