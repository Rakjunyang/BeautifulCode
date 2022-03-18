import java.util.ArrayList;

public class AddOperator implements Operator {

    String employeeNum;
    String name;
    String cl;
    String phoneNum;
    String birthday;
    String certi;

    public AddOperator(String employeeNum, String name, String cl, String phoneNum, String birthday,
        String certi) {
        this.employeeNum = employeeNum;
        this.name = name;
        this.cl = cl;
        this.phoneNum = phoneNum;
        this.birthday = birthday;
        this.certi = certi;
    }

    @Override
    public ArrayList<String> executeOperator(EmployeeManager employeeManager, OptionSelector optionSelector) {

        Employee employee = new Employee(employeeNum, name, cl, phoneNum, birthday, certi);
        employeeManager.add(employee);

        return null;
    }
}
