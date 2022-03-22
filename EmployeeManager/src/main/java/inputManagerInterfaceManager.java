import java.util.List;

public class inputManagerInterfaceManager {

    private final static String ADD = "ADD";
    private final static String DEL = "DEL";
    private final static String MOD = "MOD";
    private final static String SCH = "SCH";

    private InputManagerInterface inputManagerInterface;
    private String command;

    public void setInputManagerInterface(List<String> data) {
        command = data.get(0);
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

    public InputManagerInterface getInputManagerInterface() {
        return inputManagerInterface;
    }

    public Operator getOperator() {
        if (inputManagerInterface instanceof AddInputManager) {
            List<String> infos = inputManagerInterface.getInfos();
            return new AddOperator(infos.get(0), infos.get(1), infos.get(2), infos.get(3),
                infos.get(4), infos.get(5));
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

    public String getCommand() {
        return command;
    }
}
