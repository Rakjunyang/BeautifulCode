import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DeleteOperatorTest {

    @Test
    public void deleteExecuteOperatorTest() {
        Operator deleteOperator = new DeleteOperator(mock(InputManager.class), mock(OptionSelector.class));
        assertNull(deleteOperator.executeOperator());
        Selector selector = new Selector();
        assertNull(selector.selectEmployees(mock(OptionSelector.class), anyString(), anyString()));
    }
}
