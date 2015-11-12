import Game.core.Direction;
import Game.console.GameInputController;
import Game.console.GameInputControllerImpl;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/19/15.
 */
public class GameInputControllerImplTest {

    @Test
    public void testGameController() throws FileNotFoundException {
        InputStream inputDirection = new ByteArrayInputStream("86245".getBytes());
        GameInputController inputController = new GameInputControllerImpl(inputDirection);

        assertThat(inputController.getDirection(), is(Direction.UP));
        assertThat(inputController.getDirection(), is(Direction.RIGHT));
        assertThat(inputController.getDirection(), is(Direction.DOWN));
        assertThat(inputController.getDirection(), is(Direction.LEFT));
        assertThat(inputController.getDirection(), is(Direction.DOWN));
    }
}
