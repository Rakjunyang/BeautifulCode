import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class OperatorTest {

    static Employee employee;
    static Employee employee2;
    static OptionSelector optionSelector;

    @BeforeAll
    static void setEmployee() {
        employee = new Employee("08117441", "BMU MPOSXU", "CL3", "010-2703-3153", "20010215",
            "ADV");
        employee2 = new Employee("96548512", "ASER ZCDEU", "CL2", "010-2124-5333", "19780721",
            "ADV");
        optionSelector = mock(OptionSelector.class);
        when(optionSelector.match(employee)).thenReturn(true);
        when(optionSelector.match(employee2)).thenReturn(true);
    }

    @Test
    void addExecuteOperatorTest() {
        EmployeeManager employeeManager = new EmployeeManager();
        Operator addOperator = new AddOperator("08117441", "BMU MPOSXU", "CL3", "010-2703-3153",
            "20010215", "ADV");
        addOperator.executeOperator(employeeManager, optionSelector);
        assertEquals(employeeManager.getEmployees().size(),1);
        addOperator.executeOperator(employeeManager, optionSelector);
        assertEquals(employeeManager.getEmployees().size(),1);
    }

    @Test
    void deleteExecuteOperatorTest() {
        EmployeeManager employeeManager = new EmployeeManager();

        ArrayList<String> matchedStrList = new ArrayList<>();
        matchedStrList.add("DEL," + employee.getValue(EmployeeColumn.EMPLOYEENUM) + "," + employee.getValue(EmployeeColumn.NAME) + ","
            + employee.getValue(EmployeeColumn.CL) + "," + employee.getValue(EmployeeColumn.PHONENUM) + ","
            + employee.getValue(
            EmployeeColumn.BIRTHDAY) + "," + employee.getValue(EmployeeColumn.CERTI));
        matchedStrList.add(
            "DEL," + employee2.getValue(EmployeeColumn.EMPLOYEENUM) + "," + employee2.getValue(EmployeeColumn.NAME) + ","
                + employee2.getValue(EmployeeColumn.CL) + "," + employee2.getValue(EmployeeColumn.PHONENUM) + ","
                + employee2.getValue(
                EmployeeColumn.BIRTHDAY) + "," + employee2.getValue(EmployeeColumn.CERTI));

        employeeManager.add(employee);
        employeeManager.add(employee2);
        Operator deleteOperator = new DeleteOperator();

        assertEquals(deleteOperator.executeOperator(employeeManager, optionSelector),
            matchedStrList);
    }

    @Test
    void modifyExecuteOperatorTest() {
        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.add(employee);
        Operator modifyOperator = new ModifyOperator("PhoneNum", "010-3458-5111");

        ArrayList<String> matchedStrList = new ArrayList<>();
        matchedStrList.add("MOD," + employee.getValue(EmployeeColumn.EMPLOYEENUM) + "," + employee.getValue(EmployeeColumn.NAME) + ","
            + employee.getValue(EmployeeColumn.CL) + "," + employee.getValue(EmployeeColumn.PHONENUM) + ","
            + employee.getValue(
            EmployeeColumn.BIRTHDAY) + "," + employee.getValue(EmployeeColumn.CERTI));

        assertEquals(modifyOperator.executeOperator(employeeManager, optionSelector),
            matchedStrList);
        assertEquals(employeeManager.getEmployees().get(0).getValue(EmployeeColumn.PHONENUM),
            "010-3458-5111");
    }

    @Test
    void searchExecuteOperatorTest() {
        EmployeeManager employeeManager = new EmployeeManager();
        Operator searchOperator = new SearchOperator();

        employeeManager.add(employee);

        ArrayList<String> matchedStrList = new ArrayList<>();
        matchedStrList.add("SCH," + employee.getValue(EmployeeColumn.EMPLOYEENUM) + "," + employee.getValue(EmployeeColumn.NAME) + ","
            + employee.getValue(EmployeeColumn.CL) + "," + employee.getValue(EmployeeColumn.PHONENUM) + ","
            + employee.getValue(
            EmployeeColumn.BIRTHDAY) + "," + employee.getValue(EmployeeColumn.CERTI));
        assertEquals(searchOperator.executeOperator(employeeManager, optionSelector),
            matchedStrList);
    }
}