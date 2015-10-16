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

        assertThat(gameField.toString(), is("0 0 0 0 " + "\n" +
                "0 0 0 0 " + "\n" +
                "0 0 0 0 " + "\n" +
                "0 0 0 0 " + "\n"));
    }

    @Test
    public void testFillEmptyCell() {
        gameField.fillEmptyCell();
        assertThat(gameField.toString(), containsString("2"));
      
        for (int i = 0; i < 16; i++) {
            gameField.fillEmptyCell();
        }
        assertThat(gameField.toString(), is("2 2 2 2 " + "\n" +
                "2 2 2 2 " + "\n" +
                "2 2 2 2 " + "\n" +
                "2 2 2 2 " + "\n"));

    }

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
