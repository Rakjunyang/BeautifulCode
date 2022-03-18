import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

public class ModifyOperatorTest {

    @Test
    public void modifyExecuteOperatorTest() {
        Operator modifyOperator = new ModifyOperator(mock(InputManager.class),
            mock(OptionSelector.class));
        modifyOperator.executeOperator();
        Selector selector = new Selector();
        assertNull(selector.selectEmployees(mock(OptionSelector.class), anyString(), anyString()));
    }
}
