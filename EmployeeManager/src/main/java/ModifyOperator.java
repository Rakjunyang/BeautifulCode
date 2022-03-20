import java.util.ArrayList;

public class ModifyOperator implements Operator {

    private String changeKey;
    private String changeValue;

    private String getMatchedString(Employee employee) {
        return "MOD,"+ employee.getValue("id") + "," + employee.getValue("NAME") + ","
            + employee.getValue("CL") + "," + employee.getValue("PHONENUMBER") + "," + employee.getValue(
            "BIRTHDAY") + "," + employee.getValue("CERTI");
    }

    public ModifyOperator(String changeKey, String changeValue) {
        this.changeKey = changeKey;
        this.changeValue = changeValue;
    }

    @Override
    public ArrayList<String> executeOperator(EmployeeManager employeeManager, OptionSelector optionSelector) {

        ArrayList<Employee> employeeList = employeeManager.getEmployees();
        ArrayList<String> matchedEmployeeList = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            if (optionSelector.match(employeeList.get(i))) {
                matchedEmployeeList.add(getMatchedString(employeeList.get(i)));
                employeeList.get(i).setValue(changeKey,changeValue);
                employeeManager.getEmployees().set(i,employeeList.get(i));
            }
        }

        return matchedEmployeeList;
    }



}
