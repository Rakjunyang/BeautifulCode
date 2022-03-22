import java.util.ArrayList;
import java.util.List;

public class InputManager {
    private final static int P_OPTION_INDEX = 1;

    private InputManagerInterfaceManager inputManagerInterfaceManager = new InputManagerInterfaceManager();
    private POptionManager pOptionManager = new POptionManager();
    private OptionSelectorManager optionSelectorManager = new OptionSelectorManager();

    InputManager(List<String> data) {
        setInputManagerInterface(data);
        setpOption(data);
        setOptionSelector(data);
    }

    public void setInputManagerInterface(List<String> data) {
        inputManagerInterfaceManager.setInputManagerInterface(data);
    }

    public InputManagerInterface getInputManagerInterface() {
        return inputManagerInterfaceManager.getInputManagerInterface();
    }

    public void setpOption(List<String> data) {
        pOptionManager.setpOption(data.get(P_OPTION_INDEX));
    }

    public ArrayList<Boolean> getPOption() {
        return pOptionManager.getPOption();
    }

    public void setOptionSelector(List<String> data) {
        optionSelectorManager.setOptionSelector(data);
    }

    public OptionSelector getOptionSelector() {
        return optionSelectorManager.getOptionSelector();
    }

    public Operator getOperator() {
        return inputManagerInterfaceManager.getOperator();
    }

    public List<String> getInfos() {
        return inputManagerInterfaceManager.getInfos();
    }

    public List<String> getOptions() {
        return inputManagerInterfaceManager.getOptions();
    }

    public String getKey() {
        return inputManagerInterfaceManager.getKey();
    }

    public String getValue() {
        return inputManagerInterfaceManager.getValue();
    }

    public String getChgKey() {
        return inputManagerInterfaceManager.getChgKey();
    }

    public String getChgValue() {
        return inputManagerInterfaceManager.getChgValue();
    }

    public String getCommand(){
        return inputManagerInterfaceManager.getCommand();
    }
}
