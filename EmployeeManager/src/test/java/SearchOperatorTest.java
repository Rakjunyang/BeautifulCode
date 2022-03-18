import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

public class SearchOperatorTest {
    @Test
    public void searchExecuteOperatorTest() {
        Operator searchOperator = new SearchOperator(mock(InputManager.class),
            mock(OptionSelector.class));
        searchOperator.executeOperator();
        Selector selector = new Selector();
        assertNull(selector.selectEmployees(mock(OptionSelector.class), anyString(), anyString()));
    }
}
