import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @Test
    void idTest(){
        Employee employee = new Employee("12345678", "first last", "first", "last", "cl2", "010-1234-5678", "010", "1234", "5678", "19920312", "PRO");
        Assertions.assertEquals(employee.getValue("id"), "12345678");
    }

    @Test
    void nameTest(){
        Employee employee = new Employee("12345678", "first last", "first", "last", "cl2", "010-1234-5678", "010", "1234", "5678", "19920312", "PRO");
        Assertions.assertEquals(employee.getValue("name"), "first last");
    }

    @Test
    void clTest(){
        Employee employee = new Employee("12345678", "first last", "first", "last", "cl2", "010-1234-5678", "010", "1234", "5678", "19920312", "PRO");
        Assertions.assertEquals(employee.getValue("cl"), "cl2");
    }

    @Test
    void phoneNumberTest(){
        Employee employee = new Employee("12345678", "first last", "first", "last", "cl2", "010-1234-5678", "010", "1234", "5678", "19920312", "PRO");
        Assertions.assertEquals(employee.getValue("phoneNumber"), "010-1234-5678");
    }

    @Test
    void birthDayTest(){
        Employee employee = new Employee("12345678", "first last", "first", "last", "cl2", "010-1234-5678", "010", "1234", "5678", "19920312", "PRO");
        Assertions.assertEquals(employee.getValue("birthDay"), "19920312");
    }

    @Test
    void certiTest(){
        Employee employee = new Employee("12345678", "first last", "first", "last", "cl2", "010-1234-5678", "010", "1234", "5678", "19920312", "PRO");
        Assertions.assertEquals(employee.getValue("certi"), "PRO");
    }
}
