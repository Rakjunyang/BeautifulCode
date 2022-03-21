import java.util.ArrayList;

public class DeleteOperator extends DefaultOperator {

    public DeleteOperator() {
        super();
        super.setOperatorName("DEL");
    }

    @Override
    public ArrayList<String> executeOperator(EmployeeManager employeeManager,
        OptionSelector optionSelector) {
        ArrayList<Employee> employeeList = employeeManager.getEmployees();
        ArrayList<String> deletedEmployeeList = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            if (optionSelector.match(employeeList.get(i))) {
                deletedEmployeeList.add(super.getMatchedString(employeeList.get(i)));
                employeeManager.del(i--);
            }
        }
        return deletedEmployeeList;
    }
}
