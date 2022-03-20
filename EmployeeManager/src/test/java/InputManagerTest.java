import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputManagerTest {

    @Test
    public void addInputTest() throws Exception {
        AddInputManager addInputManager = new AddInputManager("ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO".split(","));

        Assertions.assertArrayEquals(addInputManager.getInfos(), "ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO".split(","));
    }

    @Test
    public void delInputTest() throws Exception {
        DelInputManager delInputManager = new DelInputManager("DEL, , , ,name,KYUMOK KIM".split(","));
        Assertions.assertArrayEquals(delInputManager.getOptions(), " , , ".split(","));
        Assertions.assertEquals(delInputManager.getKey(), "name");
        Assertions.assertEquals(delInputManager.getValue(), "KYUMOK KIM");
    }

    @Test
    public void schInputTest() throws Exception {
        SchInputManager schInputManager = new SchInputManager("SCH, , , ,name,KYUMOK KIM".split(","));
        Assertions.assertArrayEquals(schInputManager.getOptions(), " , , ".split(","));
        Assertions.assertEquals(schInputManager.getKey(), "name");
        Assertions.assertEquals(schInputManager.getValue(), "KYUMOK KIM");
    }

    @Test
    public void modInputTest() throws Exception {
        ModInputManager modInputManager = new ModInputManager("MOD, , , ,name,KYUMOK KIM,name,KYUMOK LEE".split(","));
        Assertions.assertArrayEquals(modInputManager.getOptions(), " , , ".split(","));
        Assertions.assertEquals(modInputManager.getKey(), "name");
        Assertions.assertEquals(modInputManager.getValue(), "KYUMOK KIM");
        Assertions.assertEquals(modInputManager.getChgKey(), "name");
        Assertions.assertEquals(modInputManager.getChgValue(), "KYUMOK LEE");

    }
}
