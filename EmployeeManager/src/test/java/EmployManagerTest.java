import static org.mockito.Mockito.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class EmployManagerTest {
/*
    EmployeeManager employeeManager;
    OptionSelector optionSelector;

    @BeforeEach
    void setUp() {
        optionSelector = mock(OptionSelector.class);
        when(optionSelector.match(any(Employee.class))).thenReturn(true);

        employeeManager = new EmployeeManager();
        employeeManager.add("12345600", "first last",  "cl2", "010-1234-5678", "19920312", "PRO");
        employeeManager.add("12345601", "abc def",  "cl3", "010-1111-2222", "20120101", "ADV");
        employeeManager.add("00111234", "one man",  "cl4", "010-2222-3333", "19700000", "ADV");
    }

    @Test
    void addTest(){
        int size = employeeManager.employees.size();
        employeeManager.add("00111235", "one man",  "cl4", "010-2222-3333", "19700000", "ADV");
        Assertions.assertEquals(employeeManager.employees.size(), size + 1);
    }

    @Test
    void delTest(){
        Assertions.assertEquals(employeeManager.del(optionSelector).size(), 3);
        Assertions.assertEquals(employeeManager.employees.size(), 0);
    }

    @Test
    void modTest(){
        ArrayList<Employee> list = employeeManager.mod(optionSelector, "certi", "ADV");
        Assertions.assertEquals(list.size(), 3);
        Assertions.assertEquals(list.get(0).getValue("certi"), "PRO");
        Assertions.assertEquals(list.get(0).getValue("id"), "12345600");
        Assertions.assertEquals(employeeManager.employees.get(0).getValue("certi"), "ADV");
    }

    @Test
    void schTest(){
        ArrayList<Employee> list = employeeManager.sch(optionSelector);
        Assertions.assertEquals(list.size(), 3);
    }

 */

}
