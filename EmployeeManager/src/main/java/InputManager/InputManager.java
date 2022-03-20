package InputManager;

import java.util.List;

public class InputManager {
    public InputManagerInterface inputManagerInterface;
    private OptionSelector optionSelector;

    private boolean pOption = false;

    private void setInputManagerInterface(List<String> data) {
        String command = data.get(0);
        if (command.equalsIgnoreCase("ADD")) {
            inputManagerInterface = new AddInputManager(data);
        } else if (command.equalsIgnoreCase("DEL")) {
            inputManagerInterface = new DelInputManager(data);
        } else if (command.equalsIgnoreCase("MOD")) {
            inputManagerInterface = new ModInputManager(data);
        } else if (command.equalsIgnoreCase("SCH")) {
            inputManagerInterface = new SchInputManager(data);
        }
    }

    private void setOptionSelector(List<String> data) {
        String option1 = data.get(1);
        if (!option1.isEmpty()) {
            if (option1.equalsIgnoreCase("-p")) {
                pOption = true;
            }
        }

        String option2 = data.get(2);
        if (!option2.isEmpty()) {
            String key = data.get(4);
            if (option2.equalsIgnoreCase("-f")) { // character 'f'
                if (key.equalsIgnoreCase("name")) {
                    optionSelector = new FirstNameOptionSelector();
                } else {
                    //[TBD] error
                }
            } else if (option2.equalsIgnoreCase("-m")) { // character 'm'
                if (key.equalsIgnoreCase("birthday")) {
                    optionSelector = new MonthBirthdayOptionSelector();
                } else if (key.equalsIgnoreCase("phoneNum")) {
                    optionSelector = new MidPhoneNumberOptionSelector();
                } else {
                    //[TBD] error
                }
            } else if (option2.equalsIgnoreCase("-l")) { // character 'l'
                if (key.equalsIgnoreCase("name")) {
                    optionSelector = new LastNameOptionSelector();
                } else if (key.equalsIgnoreCase("phoneNum")) {
                    optionSelector = new LastPhoneNumberOptionSelector();
                } else {
                    //[TBD] error
                }
            } else if (option2.equalsIgnoreCase("-y")) { // character 'l'
                if (key.equalsIgnoreCase("birthday")) {
                    optionSelector = new YearBirthdayOptionSelector();
                } else {
                    //[TBD] error
                }
            } else if (option2.equalsIgnoreCase("-d")) { // character 'd'
                if (key.equalsIgnoreCase("birthday")) {
                    optionSelector = new DayBirthdayOptionSelector();
                } else {
                    //[TBD] error
                }
            }
        }
    }

    InputManager(List<String> data) {
        setInputManagerInterface(data);
        setOptionSelector(data);
    }

    public boolean getPOption() {
        return pOption;
    }

    public Operator getOperator() {
        return inputManagerInterface.getOperator(optionSelector);
    }
}
