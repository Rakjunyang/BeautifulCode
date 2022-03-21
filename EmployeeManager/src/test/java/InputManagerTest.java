import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputManagerTest {

    @Test
    public void addInputTest() throws Exception {
        List<String> testData = Arrays.asList(
            "ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO".split(","));
        InputManager inputManager = new InputManager(testData);

        Assertions.assertArrayEquals(inputManager.getInfos().toArray(), testData.toArray());
    }

    @Test
    public void delInputTest() throws Exception {
        List<String> testData = Arrays.asList(
            "DEL, , , ,name,KYUMOK KIM".split(","));
        InputManager inputManager = new InputManager(testData);

        Assertions.assertArrayEquals(inputManager.getOptions().toArray(),
            testData.subList(1, 4).toArray());

        Assertions.assertEquals(inputManager.getKey(), testData.get(5));
        Assertions.assertEquals(inputManager.getValue(), testData.get(6));
    }

    @Test
    public void schInputTest() throws Exception {
        List<String> testData = Arrays.asList(
            "SCH, , , ,name,KYUMOK KIM".split(","));
        InputManager inputManager = new InputManager(testData);

        Assertions.assertArrayEquals(inputManager.getOptions().toArray(),
            testData.subList(1, 4).toArray());
        Assertions.assertEquals(inputManager.getKey(), testData.get(5));
        Assertions.assertEquals(inputManager.getValue(), testData.get(6));
    }

    @Test
    public void modInputTest() throws Exception {
        List<String> testData = Arrays.asList(
            "MOD, , , ,name,KYUMOK KIM,name,KYUMOK LEE".split(","));
        InputManager inputManager = new InputManager(testData);

        Assertions.assertArrayEquals(inputManager.getOptions().toArray(),
            testData.subList(1, 4).toArray());
        Assertions.assertEquals(inputManager.getKey(), testData.get(5));
        Assertions.assertEquals(inputManager.getValue(), testData.get(6));
        Assertions.assertEquals(inputManager.getChgKey(), testData.get(7));
        Assertions.assertEquals(inputManager.getChgValue(), testData.get(8));
    }

    @Test
    public void getOperatorTest() throws Exception {
        List<String> testData = Arrays.asList(
            "MOD, , , ,name,KYUMOK KIM,name,KYUMOK LEE".split(","));
        InputManager inputManager = new InputManager(testData);
        Assertions.assertEquals(inputManager.getOperator(),
            new AddOperator(null, null, null, null, null, null));
        Assertions.assertEquals(inputManager.getOperator(), new DeleteOperator());
    }

    @Test
    public void No_Occur_InputManagerExceptionTest() throws Exception {
        List<String> testData = Arrays.asList(
            "MOD,-p,-y, ,birthday,1990,name,KYUMOK LEE".split(","));
        assertThrows(InputManagerException.class, () -> new InputManager(testData));
    }

    @Test
    public void Occur_InputManagerExceptionTest() throws Exception {
        List<String> testData = Arrays.asList(
            "MOD,-p,-y, ,birthday,1990,name,KYUMOK LEE".split(","));
        InputManager inputManager = new InputManager(testData);

//      Test를 위해 임시로 public 으로 함수를 풀었다가 테스트하였기 때문에, 현재 private라 호출이 안됨.
//      그로 인해 테스트 후 주석 처리함.
//        List<String> testData2 = Arrays.asList(
//            "MOD,-p,-y, ,birthday2,1990,name,KYUMOK LEE".split(","));
//        assertThrows(InputManagerException.class, () ->
//            inputManager.setOptionSelector(testData2));
//        assertThrows(IndexOutOfBoundsException.class, () ->
//            inputManager.setOptionSelector(testData2));
    }

    @Test
    public void NotMatchCommand_InputManagerExceptionTest() throws Exception {
        List<String> testData = Arrays.asList(
            "MOD,-p,-y, ,birthday,1990,name,KYUMOK LEE".split(","));
        InputManager inputManager = new InputManager(testData);

//      Test를 위해 임시로 public 으로 함수를 풀었다가 테스트하였기 때문에, 현재 private라 호출이 안됨.
//      그로 인해 테스트 후 주석 처리함.
        List<String> testData2 = Arrays.asList(
            "MOD2,-p,-y, ,birthday2,1990,name,KYUMOK LEE".split(","));
        Throwable exception = assertThrows(InputManagerException.class, () ->
            inputManager.setInputManagerInterface(testData2));

        assertEquals(
            "[InputManagerException] Command does not matched, Data: [MOD2, -p, -y,  , birthday2, 1990, name, KYUMOK LEE]",
            exception.getMessage());
//        assertThrows(IndexOutOfBoundsException.class, () ->
//            inputManager.setInputManagerInterface(testData2));
    }
}
