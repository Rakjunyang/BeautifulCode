import java.util.ArrayList;
import java.util.List;

public class NormalResultMaker implements ResultMaker {

    public NormalResultMaker() {

    }


    @Override
    public String getResult(ArrayList<String> matchedEmployeeList, String operatorName) {

        if (matchedEmployeeList.isEmpty() || matchedEmployeeList.size() == 0) {
            return operatorName + "," + "NONE";
        }
        return operatorName + "," + matchedEmployeeList.size();
    }
}
