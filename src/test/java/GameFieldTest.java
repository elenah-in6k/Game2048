import Game.Cell;
import Game.Direction;
import Game.GameField;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/16/15.
 */
public class GameFieldTest {

    private GameField gameField = new GameField();

    @Test
    public void testCreateEmptyField() {
        assertThat(gameField.toString(), is(
                "0 0 0 0 " +
                        "0 0 0 0 " +
                        "0 0 0 0 " +
                        "0 0 0 0 "));
    }

    @Test
    public void testFillEmptyCell() {
        fillGameField();
        assertThat(gameField.toString(), is(
                "2 2 2 2 " +
                        "2 2 2 2 " +
                        "2 2 2 2 " +
                        "2 2 2 2 "));

    }

    private void fillGameField() {
        for (int i = 0; i < 16; i++) {
            gameField.fillEmptyCell();
        }
    }

    @Test
    public void testMoveRowRight() {
        fillGameField();
        assertThat(gameField.toString(), is(
                "2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 "));
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
        gameField = new GameField();
        fillGameField();
        assertThat(gameField.toString(), is("2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 "));
        gameField.move(Direction.LEFT);
        assertThat(gameField.toString(), is("4 4 0 0 " +
                "4 4 0 0 " +
                "4 4 0 0 " +
                "4 4 0 0 "));
        gameField.move(Direction.LEFT);
        assertThat(gameField.toString(), is("8 0 0 0 " +
                "8 0 0 0 " +
                "8 0 0 0 " +
                "8 0 0 0 "));

    }


    @Test
    public void testMoveUp() {
        gameField = new GameField();
        fillGameField();
        assertThat(gameField.toString(), is("2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 "));
        gameField.move(Direction.UP);
        assertThat(gameField.toString(), is("4 4 4 4 " +
                "4 4 4 4 " +
                "0 0 0 0 " +
                "0 0 0 0 "));

    }

    @Test
    public void testMoveDown() {
        gameField = new GameField();
        fillGameField();
        assertThat(gameField.toString(), is("2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 "));
        gameField.move(Direction.DOWN);
        assertThat(gameField.toString(), is("0 0 0 0 " +
                "0 0 0 0 " +
                "4 4 4 4 " +
                "4 4 4 4 "));
    }

    @Test
    public void testHasCellWith2048() {
        gameField = new GameField();
        fillGameField();
        assertThat(gameField.toString(), is("2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 "));
        assertThat(gameField.hasCellWith2048(), is(false));
        gameField.gameField.set(5, new Cell(2048));
        assertThat(gameField.hasCellWith2048(), is(true));
    }

    @Test
    public void testGetScore() {
        gameField = new GameField();
        fillGameField();
        assertThat(gameField.toString(), is("2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 "));
        gameField.move(Direction.RIGHT);

        assertThat(gameField.getScore(), is(32));
        gameField.move(Direction.RIGHT);
        assertThat(gameField.getScore(), is(64));
    }

    @Test
    public void testHasAvailableMoves() {
        gameField = new GameField();
        fillGameField();
        assertThat(gameField.toString(), is("2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 "));
        assertThat(gameField.hasAvailableMoves(), is(true));
    }

}
