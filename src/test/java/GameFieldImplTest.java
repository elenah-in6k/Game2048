import Game.Cell;
import Game.Direction;
import Game.GameField;
import Game.GameFieldImpl;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/16/15.
 */
public class GameFieldImplTest {

    private GameField gameField = new GameFieldImpl();;
    String emptyGameField = "0 0 0 0 " +
                            "0 0 0 0 " +
                            "0 0 0 0 " +
                            "0 0 0 0 ";
    String gameFieldWith2 = "2 2 2 2 " +
                            "2 2 2 2 " +
                            "2 2 2 2 " +
                            "2 2 2 2 ";

    @Test
    public void testCreateEmptyField() {

        assertThat(gameField.toString(), is(emptyGameField));
    }

    @Test
    public void testFillEmptyCell() {
        fillGameField();
        assertThat(gameField.toString(), is(gameFieldWith2));

    }

    private void fillGameField() {
        for (int i = 0; i < 16; i++) {
            gameField.fillEmptyCell();
        }
    }

    @Test
    public void testMoveRowRight() {
        fillGameField();
        assertThat(gameField.toString(), is(gameFieldWith2));
        gameField.move(Direction.RIGHT);
        assertThat(gameField.toString(), is(
                "0 0 4 4 " +
                "0 0 4 4 " +
                "0 0 4 4 " +
                "0 0 4 4 "));
        gameField.move(Direction.RIGHT);
        gameField.move(Direction.LEFT);
        assertThat(gameField.toString(), is(
                "8 0 0 0 " +
                "8 0 0 0 " +
                "8 0 0 0 " +
                "8 0 0 0 "));
    }

    @Test
    public void testMoveRowLeft() {
        fillGameField();
        assertThat(gameField.toString(), is(gameFieldWith2));
        gameField.move(Direction.LEFT);
        assertThat(gameField.toString(), is(
                "4 4 0 0 " +
                "4 4 0 0 " +
                "4 4 0 0 " +
                "4 4 0 0 "));
        gameField.move(Direction.LEFT);
        assertThat(gameField.toString(), is(
                "8 0 0 0 " +
                "8 0 0 0 " +
                "8 0 0 0 " +
                "8 0 0 0 "));
    }

    @Test
    public void testMoveUp() {
        fillGameField();
        assertThat(gameField.toString(), is(gameFieldWith2));
        gameField.move(Direction.UP);
        assertThat(gameField.toString(), is(
                "4 4 4 4 " +
                "4 4 4 4 " +
                "0 0 0 0 " +
                "0 0 0 0 "));

    }

    @Test
    public void testMoveDown() {
        fillGameField();
        assertThat(gameField.toString(), is(gameFieldWith2));
        gameField.move(Direction.DOWN);
        assertThat(gameField.toString(), is(
                "0 0 0 0 " +
                "0 0 0 0 " +
                "4 4 4 4 " +
                "4 4 4 4 "));
    }

    @Test
    @Ignore
    public void testHasCellWith2048() {
        fillGameField();
        assertThat(gameField.toString(), is(gameFieldWith2));
        assertThat(gameField.hasCellWith2048(), is(false));
//        gameField.gameField.set(5, new Cell(2048));
        assertThat(gameField.hasCellWith2048(), is(true));
    }

    @Test
    public void testGetScore() {
        fillGameField();
        assertThat(gameField.toString(), is(gameFieldWith2));
        gameField.move(Direction.RIGHT);

        assertThat(gameField.getScore(), is(32));
        gameField.move(Direction.RIGHT);
        assertThat(gameField.getScore(), is(64));
    }

    @Test
    public void testHasAvailableMoves() {
        fillGameField();
        assertThat(gameField.toString(), is(gameFieldWith2));
        assertThat(gameField.hasAvailableMoves(), is(true));
    }

}
