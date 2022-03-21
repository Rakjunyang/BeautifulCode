import java.util.ArrayList;

public class ModifyOperator extends DefaultOperator {

    private String changeKey;
    private String changeValue;

    public ModifyOperator(String changeKey, String changeValue) {
        super();
        super.setOperatorName("MOD");

        this.changeKey = changeKey;
        this.changeValue = changeValue;
    }

    @Override
    public ArrayList<String> executeOperator(EmployeeManager employeeManager,
        OptionSelector optionSelector) {

        ArrayList<Employee> employeeList = employeeManager.getEmployees();
        ArrayList<String> matchedEmployeeList = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            if (optionSelector.match(employeeList.get(i))) {
                matchedEmployeeList.add(super.getMatchedString(employeeList.get(i)));
                employeeList.get(i).setValue(EmployeeColumn.getType(changeKey), changeValue);
            }
        }

        return matchedEmployeeList;
    }


}