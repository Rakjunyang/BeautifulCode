import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class POptionManager {

    private final static String P_OPTION = "-p";

    private ArrayList<Boolean> pOption = new ArrayList<>(Arrays.asList(new Boolean[3]));

    public void setpOption(List<String> data) {
        String option1 = data.get(1);
        if (!option1.isEmpty() && option1.equalsIgnoreCase(P_OPTION)) {
            pOption.set(0, true);
        } else {
            pOption.set(0, false);
        }
    }

    public ArrayList<Boolean> getPOption() {
        return pOption;
    }
}
