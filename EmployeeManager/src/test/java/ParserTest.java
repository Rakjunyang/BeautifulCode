import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    void validStringTest() {
        assertNotNull(new Parser().parse("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV"));
        assertNotNull(new Parser().parse("SCH,-p,-d, ,birthday,04"));
        assertNotNull(new Parser().parse("DEL, , , ,employeeNum,18115040"));
        assertNotNull(new Parser().parse("MOD,-p, , ,employeeNum,08123556,birthday,20110706"));

        assertNull(new Parser().parse("DEL, , , ,name,홍길동"));
        assertNull(new Parser().parse("DEL, , , ,employeeNum,18115040@"));
    }
}
