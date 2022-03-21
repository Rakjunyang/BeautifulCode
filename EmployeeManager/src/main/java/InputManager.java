import java.util.ArrayList;
import java.util.List;

public class InputManager {

    private final static String ADD = "ADD";
    private final static String DEL = "DEL";
    private final static String MOD = "MOD";
    private final static String SCH = "SCH";
    private final static String P_OPTION = "-p";
    private final static String F_OPTION = "-f";
    private final static String M_OPTION = "-m";
    private final static String L_OPTION = "-l";
    private final static String Y_OPTION = "-y";
    private final static String D_OPTION = "-d";


    public InputManagerInterface inputManagerInterface;
    private OptionSelector optionSelector;

    private List<Boolean> pOption = new ArrayList<>(3);

    public void setInputManagerInterface(List<String> data) {
        String command = data.get(0);
        if (command.equalsIgnoreCase(ADD)) {
            inputManagerInterface = new AddInputManager(data);
        } else if (command.equalsIgnoreCase(DEL)) {
            inputManagerInterface = new DelInputManager(data);
        } else if (command.equalsIgnoreCase(MOD)) {
            inputManagerInterface = new ModInputManager(data);
        } else if (command.equalsIgnoreCase(SCH)) {
            inputManagerInterface = new SchInputManager(data);
        } else {
            throw new InputManagerException(
                "[InputManagerException] Command does not matched, Data: " + data.toString());
        }
    }

    private void setOptionSelector(List<String> data) {
        String option1 = data.get(1);
        if (!option1.isEmpty()) {
            if (option1.equalsIgnoreCase(P_OPTION)) {
                pOption.set(0, true);
            }
        }

        String option2 = data.get(2);
        String key = data.get(4);
        String value = data.get(5);
        if (!option2.isEmpty()) {
            if (option2.equalsIgnoreCase(F_OPTION)) { // character 'f'
                if (key.equalsIgnoreCase("name")) {
                    optionSelector = new FirstNameOptionSelector(value);
                } else {
                    throw new InputManagerException(
                        "[InputManagerException] Option: f, Data: " + data.toString());
                }
            } else if (option2.equalsIgnoreCase(M_OPTION)) { // character 'm'
                if (key.equalsIgnoreCase("birthday")) {
                    optionSelector = new MonthBirthDayOptionSelector(value);
                } else if (key.equalsIgnoreCase("phoneNum")) {
                    optionSelector = new MidPhoneNumberOptionSelector(value);
                } else {
                    throw new InputManagerException(
                        "[InputManagerException] Option: m, Data: " + data.toString());
                }
            } else if (option2.equalsIgnoreCase(L_OPTION)) { // character 'l'
                if (key.equalsIgnoreCase("name")) {
                    optionSelector = new LastNameOptionSelector(value);
                } else if (key.equalsIgnoreCase("phoneNum")) {
                    optionSelector = new LastPhoneNumberOptionSelector(value);
                } else {
                    throw new InputManagerException(
                        "[InputManagerException] Option: l, Data: " + data.toString());
                }
            } else if (option2.equalsIgnoreCase(Y_OPTION)) { // character 'y'
                if (key.equalsIgnoreCase("birthday")) {
                    optionSelector = new YearBirthDayOptionSelector(value);
                } else {
                    throw new InputManagerException(
                        "[InputManagerException] Option: y, Data: " + data.toString());
                }
            } else if (option2.equalsIgnoreCase(D_OPTION)) { // character 'd'
                if (key.equalsIgnoreCase("birthday")) {
                    optionSelector = new DayBirthDayOptionSelector(value);
                } else {
                    throw new InputManagerException(
                        "[InputManagerException] Option: d, Data: " + data.toString());
                }
            }
        }

        if(optionSelector == null){
            optionSelector = new DefaultOptionSelector(EmployeeColumn.getType(key), value);
        }
    }

    InputManager(List<String> data) {
        setInputManagerInterface(data);
        setOptionSelector(data);
    }

    public List<Boolean> getPOption() {
        return pOption;
    }

    public Operator getOperator() {
        if (inputManagerInterface instanceof AddInputManager) {
            return new AddOperator(inputManagerInterface.getInfos().get(0),
                inputManagerInterface.getInfos().get(1), inputManagerInterface.getInfos().get(2),
                inputManagerInterface.getInfos().get(3), inputManagerInterface.getInfos().get(4),
                inputManagerInterface.getInfos().get(5));
        } else if (inputManagerInterface instanceof DelInputManager) {
            return new DeleteOperator();
        } else if (inputManagerInterface instanceof ModInputManager) {
            return new ModifyOperator(inputManagerInterface.getChgKey(),
                inputManagerInterface.getChgValue());
        } else if (inputManagerInterface instanceof SchInputManager) {
            return new SearchOperator();
        }
        return null;
    }


    public List<String> getInfos() {
        return inputManagerInterface.getInfos();
    }

    public List<String> getOptions() {
        return inputManagerInterface.getOptions();
    }

    public String getKey() {
        return inputManagerInterface.getKey();
    }

    public String getValue() {
        return inputManagerInterface.getValue();
    }

    public String getChgKey() {
        return inputManagerInterface.getChgKey();
    }

    public String getChgValue() {
        return inputManagerInterface.getChgValue();
    }

    public OptionSelector getOptionSelector() {
        return optionSelector;
    }
}
