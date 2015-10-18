import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Created by employee on 10/16/15.
 */
public class GameFieldTest {

    private GameField gameField = new GameField();

    @Test
    public void testCreateEmptyField() {

        assertThat(gameField.toString(), is("0 0 0 0 "  +
                "0 0 0 0 " +
                "0 0 0 0 " +
                "0 0 0 0 " ));
    }

    @Test
    public void testFillEmptyCell() {
        for (int i = 0; i < 16; i++) {
            gameField.fillEmptyCell();
        }
        assertThat(gameField.toString(), is("2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 "  ));

    }


    @Test
    public void testMoveRowRight() {
        for (int i = 0; i < 16; i++) {
            gameField.fillEmptyCell();
        }
        assertThat(gameField.toString(), is("2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 "  ));
        gameField.move(Direction.right);
        assertThat(gameField.toString(), is("0 0 4 4 " +
                "0 0 4 4 " +
                "0 0 4 4 " +
                "0 0 4 4 " ));
    }



}
