import Game.Direction;
import Game.GameInputController;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/19/15.
 */
public class GameInputControllerTest {

    @Test
    public void testGameController() throws FileNotFoundException {
        InputStream inputDirection = new ByteArrayInputStream("8624".getBytes());
        GameInputController inputController = new GameInputController(inputDirection);

        assertThat(inputController.getDirection(), is(Direction.UP));
        assertThat(inputController.getDirection(), is(Direction.RIGHT));
        assertThat(inputController.getDirection(), is(Direction.DOWN));
        assertThat(inputController.getDirection(), is(Direction.LEFT));
    }
}
