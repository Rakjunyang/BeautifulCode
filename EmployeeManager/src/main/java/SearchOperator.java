import java.util.ArrayList;

public class SearchOperator implements Operator {


    public SearchOperator() {
    }

    private String getMatchedString(Employee employee) {
        return "SCH,"+ employee.getValue(EmployeeColumn.ID ) + "," + employee.getValue(EmployeeColumn.NAME) + ","
            + employee.getValue(EmployeeColumn.CL) + "," + employee.getValue(EmployeeColumn.PHONENUM) + "," + employee.getValue(
            EmployeeColumn.BIRTHDAY) + "," + employee.getValue(EmployeeColumn.CERTI);
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
