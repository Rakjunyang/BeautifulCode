import java.util.ArrayList;

public class SearchOperator extends DefaultOperator {


    public SearchOperator() {
        super();
        super.setOperatorName("SCH");
    }

    @Override
    public ArrayList<String> executeOperator(EmployeeManager employeeManager,
        OptionSelector optionSelector) {
        ArrayList<Employee> employeeList = employeeManager.getEmployees();
        ArrayList<String> matchedEmployeeList = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            if (optionSelector.match(employeeList.get(i))) {
                matchedEmployeeList.add(super.getMatchedString(employeeList.get(i)));
            }
        }

        return matchedEmployeeList;

    }
}