import org.junit.Test;

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

        assertThat(gameField.toString(), is("0 0 0 0 " + "\n" +
                "0 0 0 0 " + "\n" +
                "0 0 0 0 " + "\n" +
                "0 0 0 0 " + "\n"));
    }

//    @Test
//    public void testFillEmptyCell() {
//        gameField.fillEmptyCell();
//        assertThat(gameField.toString(), containsString("2"));
//        gameField.fillEmptyCell();
//        assertThat(gameField.toString(), containsString("4"));
//
//    }

//    @Test
//    public void testIsEmptyCell() {
//        gameField.fillEmptyCell();
//        assertThat(gameField.IsEmptyCell(2, 1), is(false));
//        assertThat(gameField.IsEmptyCell(3, 1), is(true));
//    }
//
//    @Test
//    public void testFilledCellRandom() {
//        gameField.fillEmptyCell();
//        assertThat(gameField.toString(), containsString("2"));
//
//    }


}
