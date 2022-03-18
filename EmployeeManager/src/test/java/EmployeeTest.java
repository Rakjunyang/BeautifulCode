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
        Assertions.assertEquals(employee.getValue("id"), "12345678");
    }

    @Test
    void nameTest(){
        Assertions.assertEquals(employee.getValue("name"), "first last");
    }

    @Test
    void clTest(){
        Assertions.assertEquals(employee.getValue("cl"), "cl2");
    }

    @Test
    void phoneNumberTest(){
        Assertions.assertEquals(employee.getValue("phoneNumber"), "010-1234-5678");
    }

    @Test
    void birthDayTest(){
        Assertions.assertEquals(employee.getValue("birthDay"), "19920312");
    }

    @Test
    void certiTest(){
        Assertions.assertEquals(employee.getValue("certi"), "PRO");
    }

    @Test
    void wrongKeyTest(){
        Assertions.assertEquals(employee.getValue("NOKEY"), null);
    }

    @Test
    void setNameTest(){
        employee.setValue("name", "abc def");
        Assertions.assertEquals(employee.getValue("name"), "abc def");
    }

    @Test
    void setClTest(){
        employee.setValue("cl", "CL3");
        Assertions.assertEquals(employee.getValue("CL"), "CL3");
    }

    @Test
    void setBirthDayTest(){
        employee.setValue("birthday", "20220318");
        Assertions.assertEquals(employee.getValue("BirthDay"), "20220318");
    }

    @Test
    void setCertiTest(){
        employee.setValue("certi", "ADV");
        Assertions.assertEquals(employee.getValue("certi"), "ADV");
    }
}
