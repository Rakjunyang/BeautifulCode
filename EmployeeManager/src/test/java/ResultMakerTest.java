import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class ResultMakerTest {

    @Test
    void POptionResultMakerTest() {
        ArrayList<Boolean> POption = new ArrayList<>();
        ArrayList<String> matchedEmployeeList = new ArrayList<>();
        POption.add(true);
        ResultMaker resultMaker = new ResultMakerFactory().getResultMaker(POption);
        assertNull(resultMaker.getResult(matchedEmployeeList, "MOD"));
    }

    @Test
    void NormalResultMakerZeroTest() {
        ArrayList<Boolean> POption = new ArrayList<>();
        ArrayList<String> matchedEmployeeList = new ArrayList<>();
        POption.add(false);
        ResultMaker resultMaker = new ResultMakerFactory().getResultMaker(POption);
        assertEquals(resultMaker.getResult(matchedEmployeeList, "MOD"),"MOD,NONE");
    }

    @Test
    void NormalResultMakerNotZeroTest() {
        ArrayList<Boolean> POption = new ArrayList<>();
        ArrayList<String> matchedEmployeeList = new ArrayList<>();
        matchedEmployeeList.add(anyString());
        matchedEmployeeList.add(anyString());
        matchedEmployeeList.add(anyString());
        POption.add(false);
        ResultMaker resultMaker = new ResultMakerFactory().getResultMaker(POption);
        assertEquals(resultMaker.getResult(matchedEmployeeList, "MOD"),"MOD,3");
    }

}
