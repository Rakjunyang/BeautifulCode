import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AddOperatorTest {

    @Test
    public void addExecuteOperatorTest (){
        Operator addOperator = new AddOperator(mock(InputManager.class));
        addOperator.executeOperator();
        Selector selector = new Selector();
        assertNull(selector.selectEmployees(mock(OptionSelector.class), anyString(), anyString()));
    }
}
