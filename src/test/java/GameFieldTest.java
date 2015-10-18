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

    @Test
    public void testMoveRowLeft(){
        gameField = new GameField();
        for (int i = 0; i < 16; i++) {
            gameField.fillEmptyCell();
        }
        assertThat(gameField.toString(), is("2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 "  ));
        gameField.move(Direction.left);
        assertThat(gameField.toString(), is("4 4 0 0 " +
                "4 4 0 0 " +
                "4 4 0 0 " +
                "4 4 0 0 " ));
        gameField.move(Direction.left);
        assertThat(gameField.toString(), is("8 0 0 0 " +
                "8 0 0 0 " +
                "8 0 0 0 " +
                "8 0 0 0 " ));

    }

    @Test
    public void testMoveUp(){
        gameField = new GameField();
        for (int i = 0; i < 16; i++) {
            gameField.fillEmptyCell();
        }
        assertThat(gameField.toString(), is("2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 "  ));
        gameField.move(Direction.up);
        assertThat(gameField.toString(), is("4 4 4 4 " +
                "4 4 4 4 " +
                "0 0 0 0 " +
                "0 0 0 0 " ));
        
    }

    @Test
    public void testMoveDown(){
        gameField = new GameField();
        for (int i = 0; i < 16; i++) {
            gameField.fillEmptyCell();
        }
        assertThat(gameField.toString(), is("2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 "  ));
        gameField.move(Direction.down);
        assertThat(gameField.toString(), is("0 0 0 0 " +
                        "0 0 0 0 " +
                        "4 4 4 4 " +
                        "4 4 4 4 " ));
    }

    @Test
    public void testHasCellWith2048(){
        gameField = new GameField();
        for (int i = 0; i < 16; i++) {
            gameField.fillEmptyCell();
        }
        assertThat(gameField.toString(), is("2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 "  ));
        assertThat(gameField.hasCellWith2048(),is(false));
        gameField.gameField.set(5,new Cell(5,2048));
        assertThat(gameField.hasCellWith2048(),is(true));
    }

    @Test
    public void testGetScore(){
        gameField = new GameField();
        for (int i = 0; i < 16; i++) {
            gameField.fillEmptyCell();
        }
        assertThat(gameField.toString(), is("2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 "  ));
        gameField.move(Direction.right);

        assertThat(gameField.getScore(), is(32));
        gameField.move(Direction.right);
        assertThat(gameField.getScore(), is(64));
    }

    @Test
    public void testHasAvaibleMoves(){
        gameField = new GameField();
        for (int i = 0; i < 16; i++) {
            gameField.fillEmptyCell();
        }
        assertThat(gameField.toString(), is("2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 " +
                "2 2 2 2 "  ));
        assertThat(gameField.hasAvaibleMoves(), is(true));
    }

}
