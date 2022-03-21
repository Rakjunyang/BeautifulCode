import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    void validStringTest() {
        ArrayList<String> parseResult = Parser.parse("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
        assertEquals(parseResult.get(0), "ADD");
        assertEquals(parseResult.get(1), " ");
        assertEquals(parseResult.get(2), " ");
        assertEquals(parseResult.get(3), " ");
        assertEquals(parseResult.get(4), "15123099");
        assertEquals(parseResult.get(5), "VXIHXOTH JHOP");
        assertEquals(parseResult.get(6), "CL3");
        assertEquals(parseResult.get(7), "010-3112-2609");
        assertEquals(parseResult.get(8), "19771211");
        assertEquals(parseResult.get(9), "ADV");

        parseResult = Parser.parse("SCH,-p,-d, ,birthday,04");
        assertEquals(parseResult.get(0), "SCH");
        assertEquals(parseResult.get(1), "-p");
        assertEquals(parseResult.get(2), "-d");
        assertEquals(parseResult.get(3), " ");
        assertEquals(parseResult.get(4), "birthday");
        assertEquals(parseResult.get(5), "04");

        assertNotNull(Parser.parse("DEL, , , ,employeeNum,18115040"));
        assertNotNull(Parser.parse("MOD,-p, , ,employeeNum,08123556,birthday,20110706"));
    }

    @Test
    void invalidStringTest() {
        assertNull(Parser.parse("DEL, , , ,name,홍길동"));
        assertNull(Parser.parse("DEL, , , ,employeeNum,18115040@"));
    }

    @Test
    void operationTypeTest() {
        assertNotNull(Parser.parse("DEL, , , ,employeeNum,18115040"));
        assertNull(Parser.parse("InvalidOperation, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV"));
    }

    @Test
    void dataLengthTest() {
        assertNotNull(Parser.parse("DEL, , , ,employeeNum,18115040"));
        assertNull(Parser.parse("DEL, , , ,employeeNum"));
        assertNull(Parser.parse("MOD,-p, , ,employeeNum,08123556"));
        assertNull(Parser.parse("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211"));
        assertNull(Parser.parse("SCH,-p,-d, ,birthday"));
    }

    @Test
    void optionTest() {
        assertNotNull(Parser.parse("SCH,-p,-d, ,birthday,04"));
        assertNotNull(Parser.parse("SCH, , , ,birthday,04"));

        assertNull(Parser.parse("SCH,-z, , ,birthday,04"));
        assertNull(Parser.parse("SCH, ,-x, ,birthday,04"));
        assertNull(Parser.parse("SCH, , ,-y,birthday,04"));
        assertNull(Parser.parse("SCH,, , ,birthday,04"));
    }
}
