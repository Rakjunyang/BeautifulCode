import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class OperatorTest {

    static Employee employee;
    static OptionSelector optionSelector;
    @BeforeAll
    static void setEmployee(){
        employee = new Employee("08117441","BMU MPOSXU","CL3","010-2703-3153","20010215","ADV");
        optionSelector = mock(OptionSelector.class);
        when(optionSelector.match(employee)).thenReturn(true);
    }

    @Test
    void addExecuteOperatorTest (){
        Operator addOperator = new AddOperator("08117441","BMU MPOSXU","CL3","010-2703-3153","20010215","ADV");
        addOperator.executeOperator(mock(EmployeeManager.class),mock(OptionSelector.class));
    }

    @Test
    void deleteExecuteOperatorTest() {
        EmployeeManager employeeManager = new EmployeeManager();

        ArrayList<String> matchedStrList = new ArrayList<>();
        matchedStrList.add("MOD,"+ employee.getValue("id") + "," + employee.getValue("NAME") + ","
            + employee.getValue("CL") + "," + employee.getValue("PHONENUMBER") + "," + employee.getValue(
            "BIRTHDAY") + "," + employee.getValue("CERTI"));

        employeeManager.add(employee);
        Operator deleteOperator = new DeleteOperator();

        assertEquals(deleteOperator.executeOperator(employeeManager,optionSelector),matchedStrList);
    }

    @Test
    void modifyExecuteOperatorTest() {
        Operator modifyOperator = new ModifyOperator();
        modifyOperator.executeOperator(mock(EmployeeManager.class),mock(OptionSelector.class));
    }

    @Test
    void searchExecuteOperatorTest() {
        EmployeeManager employeeManager = new EmployeeManager();
        Operator searchOperator = new SearchOperator();
        searchOperator.executeOperator(mock(EmployeeManager.class),mock(OptionSelector.class));

        ArrayList<String> matchedStrList = new ArrayList<>();
        matchedStrList.add("MOD,"+ employee.getValue("id") + "," + employee.getValue("NAME") + ","
            + employee.getValue("CL") + "," + employee.getValue("PHONENUMBER") + "," + employee.getValue(
            "BIRTHDAY") + "," + employee.getValue("CERTI"));

        employeeManager.add(employee);

        assertEquals(searchOperator.executeOperator(employeeManager,optionSelector),matchedStrList);
    }
}
