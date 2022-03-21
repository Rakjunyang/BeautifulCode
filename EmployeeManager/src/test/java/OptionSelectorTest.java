import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OptionSelectorTest {
    EmployeeManager employeeManager;
    ArrayList<Employee> employees;

    @BeforeEach
    void setUp(){
        employeeManager = new EmployeeManager();
        employeeManager.add(new Employee("12345600", "first last",  "cl2", "010-1234-5678", "19920312", "PRO"));
        employeeManager.add(new Employee("12345601", "abc def",  "cl3", "010-1234-2222", "20220318", "ADV"));
        employeeManager.add(new Employee("00111234", "one man",  "cl4", "010-2222-2222", "19700018", "ADV"));
        employeeManager.sort();
        employees = employeeManager.getEmployees();
    }

    @Test
    void idDefaultTest(){
        OptionSelector optionSelector = new DefaultOptionSelector(EmployeeColumn.ID, "12345601");
        ArrayList<Employee> matchedEmployees = new ArrayList<>();

        for(Employee employee : employees){
            if(optionSelector.match(employee))
                matchedEmployees.add(employee);
        }

        Assertions.assertEquals(matchedEmployees.size(), 1);
        Assertions.assertEquals(matchedEmployees.get(0).getValue(EmployeeColumn.ID), "12345601");
    }

    @Test
    void clDefaultTest(){
        OptionSelector optionSelector = new DefaultOptionSelector(EmployeeColumn.CL, "cl4");
        ArrayList<Employee> matchedEmployees = new ArrayList<>();

        for(Employee employee : employees){
            if(optionSelector.match(employee))
                matchedEmployees.add(employee);
        }

        Assertions.assertEquals(matchedEmployees.size(), 1);
        Assertions.assertEquals(matchedEmployees.get(0).getValue(EmployeeColumn.CL), "cl4");
    }

    @Test
    void firstNameTest(){
        OptionSelector optionSelector = new FirstNameOptionSelector("first last");
        ArrayList<Employee> matchedEmployees = new ArrayList<>();

        for(Employee employee : employees){
            if(optionSelector.match(employee))
                matchedEmployees.add(employee);
        }

        Assertions.assertEquals(matchedEmployees.size(), 1);
        Assertions.assertEquals(matchedEmployees.get(0).getValue(EmployeeColumn.NAME).split(" ")[0], "first");
    }

    @Test
    void lastNameTest(){
        OptionSelector optionSelector = new LastNameOptionSelector("first last");
        ArrayList<Employee> matchedEmployees = new ArrayList<>();

        for(Employee employee : employees){
            if(optionSelector.match(employee))
                matchedEmployees.add(employee);
        }

        Assertions.assertEquals(matchedEmployees.size(), 1);
        Assertions.assertEquals(matchedEmployees.get(0).getValue(EmployeeColumn.NAME).split(" ")[1], "last");
    }

    @Test
    void midPhoneNumberTest(){
        OptionSelector optionSelector = new MidPhoneNumberOptionSelector("010-1234-5678");
        ArrayList<Employee> matchedEmployees = new ArrayList<>();

        for(Employee employee : employees){
            if(optionSelector.match(employee))
                matchedEmployees.add(employee);
        }

        Assertions.assertEquals(matchedEmployees.size(), 2);
        Assertions.assertEquals(matchedEmployees.get(1).getValue(EmployeeColumn.PHONENUM).split("-")[1], "1234");
    }

    @Test
    void lastPhoneNumberTest(){
        OptionSelector optionSelector = new LastPhoneNumberOptionSelector("010-2222-2222");
        ArrayList<Employee> matchedEmployees = new ArrayList<>();

        for(Employee employee : employees){
            if(optionSelector.match(employee))
                matchedEmployees.add(employee);
        }

        Assertions.assertEquals(matchedEmployees.size(), 2);
        Assertions.assertEquals(matchedEmployees.get(0).getValue(EmployeeColumn.PHONENUM).split("-")[2], "2222");
    }

    @Test
    void YearBirthDayTest(){
        OptionSelector optionSelector = new YearBirthDayOptionSelector("20220318");
        ArrayList<Employee> matchedEmployees = new ArrayList<>();

        for(Employee employee : employees){
            if(optionSelector.match(employee))
                matchedEmployees.add(employee);
        }

        Assertions.assertEquals(matchedEmployees.size(), 1);
        Assertions.assertEquals(matchedEmployees.get(0).getValue(EmployeeColumn.BIRTHDAY), "20220318");
    }

    @Test
    void MonthBirthDayTest(){
        OptionSelector optionSelector = new MonthBirthDayOptionSelector("20220318");
        ArrayList<Employee> matchedEmployees = new ArrayList<>();

        for(Employee employee : employees){
            if(optionSelector.match(employee))
                matchedEmployees.add(employee);
        }

        Assertions.assertEquals(matchedEmployees.size(), 2);
        Assertions.assertEquals(matchedEmployees.get(1).getValue(EmployeeColumn.BIRTHDAY), "20220318");
    }

    @Test
    void DayBirthDayTest(){
        OptionSelector optionSelector = new DayBirthDayOptionSelector("20220318");
        ArrayList<Employee> matchedEmployees = new ArrayList<>();

        for(Employee employee : employees){
            if(optionSelector.match(employee))
                matchedEmployees.add(employee);
        }

        Assertions.assertEquals(matchedEmployees.size(), 2);
        Assertions.assertEquals(matchedEmployees.get(0).getValue(EmployeeColumn.BIRTHDAY), "20220318");
    }
}
