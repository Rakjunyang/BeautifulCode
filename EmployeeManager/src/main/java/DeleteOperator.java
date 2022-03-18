public class DeleteOperator implements Operator{

    InputManager inputManager;
    OptionSelector optionSelector;
    public DeleteOperator(InputManager inputManager, OptionSelector optionSelector){
        this.inputManager = inputManager;
        this.optionSelector = optionSelector;
    }

    @Override
    public String executeOperator() {
        return null;
    }
}
