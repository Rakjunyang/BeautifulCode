import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class POptionResultMaker extends NoneExistsResultMaker {

    FileManager fileManager;

    public POptionResultMaker(FileManager fileManager) {
        super();
        this.fileManager = fileManager;
    }

    public List<String> getHead5Results(ArrayList<String> matchedEmployeeList) {
        return matchedEmployeeList.stream().limit(5).collect(
            Collectors.toList());
    }

    @Override
    public void setResult(ArrayList<String> matchedEmployeeList, String operatorName)
        throws IOException {
        if (matchedEmployeeList.isEmpty() || matchedEmployeeList.size() == 0) {
            fileManager.writeOutputFile(super.getNoneResult(operatorName));
        }

        for (String result : getHead5Results(matchedEmployeeList)) {
            fileManager.writeOutputFile(result);
        }
    }
}
