import java.io.IOException;
import java.util.ArrayList;

interface ResultMaker {

    void setResult(ArrayList<String> matchedEmployeeList, String operatorName) throws IOException;

}
