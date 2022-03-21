import java.util.ArrayList;

public class SearchOperator implements Operator {


    public SearchOperator() {
    }

    private String getMatchedString(Employee employee) {
        return "SCH,"+ employee.getValue("id") + "," + employee.getValue("NAME") + ","
            + employee.getValue("CL") + "," + employee.getValue("PHONENUMBER") + "," + employee.getValue(
            "BIRTHDAY") + "," + employee.getValue("CERTI");
    }

    @Override
    public ArrayList<String> executeOperator(EmployeeManager employeeManager, OptionSelector optionSelector) {
        ArrayList<Employee> employeeList = employeeManager.getEmployees();
        ArrayList<String> matchedEmployeeList = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            if (optionSelector.match(employeeList.get(i))) {
                matchedEmployeeList.add(getMatchedString(employeeList.get(i)));
            }
        }

        return matchedEmployeeList;

    }
}
