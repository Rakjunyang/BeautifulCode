import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

public class OperatorTest {
    @Test
    public void addExecuteOperatorTest (){
        Operator addOperator = new AddOperator(anyString(),anyString(),anyString(),anyString(),anyString(),anyString());
        addOperator.executeOperator(mock(EmployeeManager.class),mock(OptionSelector.class));

    }

    @Test
    public void deleteExecuteOperatorTest() {
        Operator deleteOperator = new DeleteOperator();
        assertNull(deleteOperator.executeOperator(mock(EmployeeManager.class),mock(OptionSelector.class)));
    }

    @Test
    public void modifyExecuteOperatorTest() {
        Operator modifyOperator = new ModifyOperator(mock(InputManager.class),
            mock(OptionSelector.class));
        modifyOperator.executeOperator(mock(EmployeeManager.class),mock(OptionSelector.class));
    }

    @Test
    public void searchExecuteOperatorTest() {
        Operator searchOperator = new SearchOperator(mock(InputManager.class),
            mock(OptionSelector.class));
        searchOperator.executeOperator(mock(EmployeeManager.class),mock(OptionSelector.class));
    }
}
