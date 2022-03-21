import java.util.ArrayList;

public class DeleteOperator implements Operator {

    public DeleteOperator() {
    }

    private String getMatchedString(Employee employee) {
        return "DEL,"+ employee.getValue(EmployeeColumn.ID) + "," + employee.getValue(EmployeeColumn.NAME) + ","
            + employee.getValue(EmployeeColumn.CL) + "," + employee.getValue(EmployeeColumn.PHONENUM) + "," + employee.getValue(
            EmployeeColumn.BIRTHDAY) + "," + employee.getValue(EmployeeColumn.CERTI);
    }

    @Override
    public ArrayList<String> executeOperator(EmployeeManager employeeManager,
        OptionSelector optionSelector) {
        ArrayList<Employee> employeeList = employeeManager.getEmployees();
        ArrayList<String> deletedEmployeeList = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            if (optionSelector.match(employeeList.get(i))) {
                deletedEmployeeList.add(getMatchedString(employeeList.get(i)));
                employeeManager.del(i--);
            }
        }

        return deletedEmployeeList;
    }
}
