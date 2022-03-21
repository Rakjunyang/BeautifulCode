import java.util.ArrayList;

public class DeleteOperator implements Operator {

    public DeleteOperator() {
    }

    private String getMatchedString(Employee employee) {
        return "DEL,"+ employee.getValue("id") + "," + employee.getValue("NAME") + ","
            + employee.getValue("CL") + "," + employee.getValue("PHONENUMBER") + "," + employee.getValue(
            "BIRTHDAY") + "," + employee.getValue("CERTI");
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
