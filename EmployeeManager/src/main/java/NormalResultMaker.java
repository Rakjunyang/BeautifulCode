import java.io.IOException;
import java.util.ArrayList;

public class NormalResultMaker extends NoneExistsResultMaker {

    FileManager fileManager;

    public NormalResultMaker(FileManager fileManager) {
        super();
        this.fileManager = fileManager;
    }

    public String getCountResult(String operatorName, int count) {
        return operatorName + "," + count;
    }

    @Override
    public void setResult(ArrayList<String> matchedEmployeeList, String operatorName)
        throws IOException {

        if (matchedEmployeeList.isEmpty() || matchedEmployeeList.size() == 0) {
            fileManager.writeOutputFile(super.getNoneResult(operatorName));
            return;
        }
        fileManager.writeOutputFile(getCountResult(operatorName, matchedEmployeeList.size()));
    }
}
