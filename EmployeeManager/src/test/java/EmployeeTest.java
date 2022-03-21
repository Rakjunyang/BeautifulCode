import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
    Employee employee;
    @BeforeEach
    void setUp(){
        employee = new Employee("12345678", "first last",  "cl2", "010-1234-5678", "19920312", "PRO");
    }

    @Test
    void idTest(){
        Assertions.assertEquals(employee.getValue(EmployeeColumn.ID), "12345678");
    }

    @Test
    void nameTest(){
        Assertions.assertEquals(employee.getValue(EmployeeColumn.NAME), "first last");
    }

    @Test
    void clTest(){
        Assertions.assertEquals(employee.getValue(EmployeeColumn.CL), "cl2");
    }

    @Test
    void phoneNumberTest(){
        Assertions.assertEquals(employee.getValue(EmployeeColumn.PHONENUM), "010-1234-5678");
    }

    @Test
    void birthDayTest(){
        Assertions.assertEquals(employee.getValue(EmployeeColumn.BIRTHDAY), "19920312");
    }

    @Test
    void certiTest(){
        Assertions.assertEquals(employee.getValue(EmployeeColumn.CERTI), "PRO");
    }


    @Test
    void setNameTest(){
        employee.setValue(EmployeeColumn.NAME, "abc def");
        Assertions.assertEquals(employee.getValue(EmployeeColumn.NAME), "abc def");
    }

    @Test
    void setClTest(){
        employee.setValue(EmployeeColumn.CL, "CL3");
        Assertions.assertEquals(employee.getValue(EmployeeColumn.CL), "CL3");
    }

    @Test
    void setBirthDayTest(){
        employee.setValue(EmployeeColumn.BIRTHDAY, "20220318");
        Assertions.assertEquals(employee.getValue(EmployeeColumn.BIRTHDAY), "20220318");
    }

    @Test
    void setCertiTest(){
        employee.setValue(EmployeeColumn.CERTI, "ADV");
        Assertions.assertEquals(employee.getValue(EmployeeColumn.CERTI), "ADV");
    }
}
