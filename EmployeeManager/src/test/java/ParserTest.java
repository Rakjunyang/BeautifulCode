import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

        parseResult = Parser.parse("DEL, , , ,employeeNum,18115040");
        assertEquals(parseResult.get(0), "DEL");
        assertEquals(parseResult.get(1), " ");
        assertEquals(parseResult.get(2), " ");
        assertEquals(parseResult.get(3), " ");
        assertEquals(parseResult.get(4), "employeeNum");
        assertEquals(parseResult.get(5), "18115040");

        parseResult = Parser.parse("MOD,-p, , ,employeeNum,08123556,birthday,20110706");
        assertEquals(parseResult.get(0), "MOD");
        assertEquals(parseResult.get(1), "-p");
        assertEquals(parseResult.get(2), " ");
        assertEquals(parseResult.get(3), " ");
        assertEquals(parseResult.get(4), "employeeNum");
        assertEquals(parseResult.get(5), "08123556");
        assertEquals(parseResult.get(6), "birthday");
        assertEquals(parseResult.get(7), "20110706");
    }

    @Test
    void invalidStringTest() {
        assertThrows(IllegalArgumentException.class, () -> Parser.parse("DEL, , , ,name,홍길동"));
        assertThrows(IllegalArgumentException.class, () -> Parser.parse("DEL, , , ,employeeNum,18115040@"));
    }

    @Test
    void operationTypeTest() {
        assertDoesNotThrow(() -> Parser.parse("DEL, , , ,employeeNum,18115040"));

        assertThrows(IllegalArgumentException.class, () -> Parser.parse("InvalidOperation, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV"));
    }

    @Test
    void dataLengthTest() {
        assertDoesNotThrow(() -> Parser.parse("DEL, , , ,employeeNum,18115040"));

        assertThrows(IllegalArgumentException.class, () -> Parser.parse("DEL, , , ,employeeNum"));
        assertThrows(IllegalArgumentException.class, () -> Parser.parse("MOD,-p, , ,employeeNum,08123556"));
        assertThrows(IllegalArgumentException.class, () -> Parser.parse("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211"));
        assertThrows(IllegalArgumentException.class, () -> Parser.parse("SCH,-p,-d, ,birthday"));
    }

    @Test
    void optionTest() {
        assertDoesNotThrow(() -> Parser.parse("SCH,-p,-d, ,birthday,04"));
        assertDoesNotThrow(() -> Parser.parse("SCH, , , ,birthday,04"));

        assertThrows(IllegalArgumentException.class, () -> Parser.parse("SCH,-z, , ,birthday,04"));
        assertThrows(IllegalArgumentException.class, () -> Parser.parse("SCH, ,-x, ,birthday,04"));
        assertThrows(IllegalArgumentException.class, () -> Parser.parse("SCH, , ,-y,birthday,04"));
        assertThrows(IllegalArgumentException.class, () -> Parser.parse("SCH,, , ,birthday,04"));
    }
}
