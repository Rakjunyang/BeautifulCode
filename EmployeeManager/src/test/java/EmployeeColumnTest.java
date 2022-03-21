import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeColumnTest {
    @Test
    void IdTest(){
        String key = "phonenum";
        Assertions.assertEquals(EmployeeColumn.getType(key), EmployeeColumn.PHONENUM);
    }
}
