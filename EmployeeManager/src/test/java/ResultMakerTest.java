import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ResultMakerTest {

    static ArrayList<String> emptyEmployeeList = new ArrayList<>();
    static ArrayList<String> notNoneEmployeeList = new ArrayList<>();
    @BeforeAll
    static void SetTest(){
        notNoneEmployeeList.add("MOD,07112609,FB NTAWR,CL4,010-5645-6122,20050520,PRO");
        notNoneEmployeeList.add("MOD,08123556,WN XV,CL1,010-7986-5047,20100614,PRO");
        notNoneEmployeeList.add("MOD,08145552,AB EV,CL2,010-3456-1237,20100513,PRO");
        notNoneEmployeeList.add("MOD,12004147,EREW SDF,CL3,010-1235-4567,20120530,PRO");
        notNoneEmployeeList.add("MOD,12304417,JKLJ DSF,CL2,010-2344-6788,20100413,PRO");
        notNoneEmployeeList.add("MOD,13287114,kO EWF,CL2,010-6786-4456,20101213,PRO");
    }

    @Test
    void POptionResultMakerZeroTest() throws IOException {
        ArrayList<Boolean> POption = new ArrayList<>();
        POption.add(true);
        ResultMaker resultMaker = new ResultMakerFactory().getResultMaker(POption, mock(FileManager.class));
        resultMaker.setResult(emptyEmployeeList, "MOD");

        POptionResultMaker pOptionResultMaker = new POptionResultMaker(mock(FileManager.class));

        assertEquals(pOptionResultMaker.getHead5Results(emptyEmployeeList).size(), 0);
        assertEquals(pOptionResultMaker.getNoneResult("MOD"),"MOD,NONE");
    }

    @Test
    void POptionResultMakerNotZeroTest() throws IOException {
        ArrayList<Boolean> POption = new ArrayList<>();
        POption.add(true);
        ResultMaker resultMaker = new ResultMakerFactory().getResultMaker(POption, mock(FileManager.class));
        resultMaker.setResult(notNoneEmployeeList, "MOD");

        POptionResultMaker pOptionResultMaker = new POptionResultMaker(mock(FileManager.class));

        assertEquals(pOptionResultMaker.getHead5Results(notNoneEmployeeList).size(), 5);
        assertEquals(pOptionResultMaker.getHead5Results(notNoneEmployeeList).get(0), "MOD,07112609,FB NTAWR,CL4,010-5645-6122,20050520,PRO");
        assertEquals(pOptionResultMaker.getHead5Results(notNoneEmployeeList).get(1), "MOD,08123556,WN XV,CL1,010-7986-5047,20100614,PRO");
        assertEquals(pOptionResultMaker.getHead5Results(notNoneEmployeeList).get(2), "MOD,08145552,AB EV,CL2,010-3456-1237,20100513,PRO");
        assertEquals(pOptionResultMaker.getHead5Results(notNoneEmployeeList).get(3), "MOD,12004147,EREW SDF,CL3,010-1235-4567,20120530,PRO");
        assertEquals(pOptionResultMaker.getHead5Results(notNoneEmployeeList).get(4), "MOD,12304417,JKLJ DSF,CL2,010-2344-6788,20100413,PRO");
    }

    @Test
    void NormalResultMakerZeroTest() throws IOException {
        ArrayList<Boolean> POption = new ArrayList<>();
        FileManager fileManager = mock(FileManager.class);
        POption.add(false);
        ResultMaker resultMaker = new ResultMakerFactory().getResultMaker(POption, fileManager);
        resultMaker.setResult(emptyEmployeeList, "MOD");

        NormalResultMaker normalResultMaker = new NormalResultMaker(mock(FileManager.class));
        assertEquals(normalResultMaker.getNoneResult("MOD"),"MOD,NONE");
    }

    @Test
    void NormalResultMakerNotZeroTest() throws IOException {
        ArrayList<Boolean> POption = new ArrayList<>();
        POption.add(false);
        ResultMaker resultMaker = new ResultMakerFactory().getResultMaker(POption, mock(FileManager.class));
        resultMaker.setResult(notNoneEmployeeList, "MOD");

        NormalResultMaker normalResultMaker = new NormalResultMaker(mock(FileManager.class));

        assertEquals(normalResultMaker.getCountResult("MOD", notNoneEmployeeList.size()),"MOD,6");
    }

}
