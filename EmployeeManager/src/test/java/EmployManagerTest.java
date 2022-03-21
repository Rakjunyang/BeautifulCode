
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployManagerTest {

    EmployeeManager employeeManager;
    OptionSelector optionSelector;

    @BeforeEach
    void setUp() {

        employeeManager = new EmployeeManager();
        Employee employee1 = new Employee("12345600", "first last",  "cl2", "010-1234-5678", "19920312", "PRO");
        Employee employee2 = new Employee("12345601", "abc def",  "cl3", "010-1111-2222", "20120101", "ADV");
        Employee employee3 = new Employee("00111234", "one man",  "cl4", "010-2222-3333", "19700000", "ADV");
        employeeManager.add(employee1);
        employeeManager.add(employee2);
        employeeManager.add(employee3);
    }

    @Test
    void getEmployeeTest(){
        ArrayList<Employee> employees = employeeManager.getEmployees();
        Assertions.assertNotNull(employees);
    }
    
    @Test
    void addTest(){
        int size = employeeManager.getEmployees().size();
        Employee employee = new Employee("00111235", "one man",  "cl4", "010-2222-3333", "19700000", "ADV");
        employeeManager.add(employee);
        Assertions.assertEquals(employeeManager.getEmployees().size(), size + 1);
    }

    @Test
    void delTest(){
        ArrayList<Employee> employees = employeeManager.getEmployees();
        int size = employees.size();
        String id = employees.get(0).getValue(EmployeeColumn.ID);
        employeeManager.del(0);
        Assertions.assertEquals(employees.size(), size -1);
        
        
        for(Employee employee : employees)
        {
            Assertions.assertNotEquals(employee.getValue(EmployeeColumn.ID), id);
        }
    }

    @Test
    void sortTest(){
        ArrayList<Employee> employees = employeeManager.getEmployees();
        employeeManager.sort();
        int firstId = Integer.parseInt(employees.get(0).getValue(EmployeeColumn.ID));
        int firstSortId = firstId < 30000000 ? 2000000000 + firstId : 1900000000 + firstId;
        int secondId = Integer.parseInt(employees.get(1).getValue(EmployeeColumn.ID));
        int secondSortId = secondId < 30000000 ? 2000000000 + secondId : 1900000000 + secondId;
        
        Assertions.assertTrue(firstSortId < secondSortId);
    } 

}
