import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

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

        assertThat(inputController.getDirection(), is(Direction.up));
        assertThat(inputController.getDirection(), is(Direction.right));
        assertThat(inputController.getDirection(), is(Direction.down));
        assertThat(inputController.getDirection(), is(Direction.left));
    }
}
