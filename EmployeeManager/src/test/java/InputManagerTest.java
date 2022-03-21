import static org.mockito.Mockito.*;

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

        Assertions.assertArrayEquals(inputManager.getOptions().toArray(), testData.subList(1, 4).toArray());

        Assertions.assertEquals(inputManager.getKey(), testData.get(5));
        Assertions.assertEquals(inputManager.getValue(), testData.get(6));
    }

    @Test
    public void schInputTest() throws Exception {
        List<String> testData = Arrays.asList(
            "SCH, , , ,name,KYUMOK KIM".split(","));
        InputManager inputManager = new InputManager(testData);


        Assertions.assertArrayEquals(inputManager.getOptions().toArray(), testData.subList(1, 4).toArray());
        Assertions.assertEquals(inputManager.getKey(), testData.get(5));
        Assertions.assertEquals(inputManager.getValue(), testData.get(6));
    }

    @Test
    public void modInputTest() throws Exception {
        List<String> testData = Arrays.asList(
            "MOD, , , ,name,KYUMOK KIM,name,KYUMOK LEE".split(","));
        InputManager inputManager = new InputManager(testData);

        Assertions.assertArrayEquals(inputManager.getOptions().toArray(), testData.subList(1, 4).toArray());
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
        Assertions.assertEquals(inputManager.getOperator(), new AddOperator(null));
        Assertions.assertEquals(inputManager.getOperator(), new DeleteOperator(null, null));
    }
}
