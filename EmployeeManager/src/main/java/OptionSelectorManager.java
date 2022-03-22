import java.util.List;

public class OptionSelectorManager {

    private final static String F_OPTION = "-f";
    private final static String M_OPTION = "-m";
    private final static String L_OPTION = "-l";
    private final static String Y_OPTION = "-y";
    private final static String D_OPTION = "-d";

    private final static String MESSAGE_FORMAT = "[InputManagerException] Option: %s, Data: %s";
    private OptionSelector optionSelector;

    public void setOptionSelector(List<String> data) {
        String option2 = data.get(2);
        String key = data.get(4);
        String value = data.get(5);
        if (!option2.isEmpty() && !option2.equalsIgnoreCase(" ")) {
            if (option2.equalsIgnoreCase(F_OPTION)) { // character 'f'
                if (key.equalsIgnoreCase("name")) {
                    optionSelector = new FirstNameOptionSelector(value);
                } else {
                    throw new InputManagerException(
                        String.format(MESSAGE_FORMAT, F_OPTION, data.toString()));
                }
            } else if (option2.equalsIgnoreCase(M_OPTION)) { // character 'm'
                if (key.equalsIgnoreCase("birthday")) {
                    optionSelector = new MonthBirthDayOptionSelector(value);
                } else if (key.equalsIgnoreCase("phoneNum")) {
                    optionSelector = new MidPhoneNumberOptionSelector(value);
                } else {
                    throw new InputManagerException(
                        String.format(MESSAGE_FORMAT, M_OPTION, data.toString()));
                }
            } else if (option2.equalsIgnoreCase(L_OPTION)) { // character 'l'
                if (key.equalsIgnoreCase("name")) {
                    optionSelector = new LastNameOptionSelector(value);
                } else if (key.equalsIgnoreCase("phoneNum")) {
                    optionSelector = new LastPhoneNumberOptionSelector(value);
                } else {
                    throw new InputManagerException(
                        String.format(MESSAGE_FORMAT, L_OPTION, data.toString()));
                }
            } else if (option2.equalsIgnoreCase(Y_OPTION)) { // character 'y'
                if (key.equalsIgnoreCase("birthday")) {
                    optionSelector = new YearBirthDayOptionSelector(value);
                } else {
                    throw new InputManagerException(
                        String.format(MESSAGE_FORMAT, Y_OPTION, data.toString()));
                }
            } else if (option2.equalsIgnoreCase(D_OPTION)) { // character 'd'
                if (key.equalsIgnoreCase("birthday")) {
                    optionSelector = new DayBirthDayOptionSelector(value);
                } else {
                    throw new InputManagerException(
                        String.format(MESSAGE_FORMAT, Y_OPTION, data.toString()));
                }
            }
        }

        if (optionSelector == null) {
            optionSelector = new DefaultOptionSelector(EmployeeColumn.getType(key), value);
        }
    }

    public OptionSelector getOptionSelector() {
        return optionSelector;
    }
}
