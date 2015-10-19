import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/19/15.
 */
public class GameInputControllerTest {
    @Test
    public void testGameController(){
        GameInputController inputController = new GameInputController(System.in);

        assertThat(inputController.getDirection(), is(Direction.up));

    }
}
