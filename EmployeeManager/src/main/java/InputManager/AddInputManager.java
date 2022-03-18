package InputManager;

import java.util.Arrays;

public class AddInputManager implements InputManager {

    String[] Infos = new String[6];
    Object Operator;

    AddInputManager(String[] data) {
        Infos = Arrays.copyOfRange(data, 4, 10);
    }

    @Override
    public void setOperator() {

    }

    @Override
    public Object getOperator() {
        return Operator;
    }

    public String[] getInfos() {
        return Infos;
    }
}
