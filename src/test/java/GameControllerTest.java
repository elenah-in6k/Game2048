import Game.Direction;
import Game.GameField;
import Game.GameInputController;
import Game.Printer;
import org.junit.Test;

/**
 * Created by employee on 10/20/15.
 */
public class GameControllerTest implements GameInputController, GameField, Printer {
    @Override
    public void startNewGame() {

    }

    @Override
    public void fillEmptyCell() {

    }

    @Override
    public boolean hasAvailableMoves() {
        return false;
    }

    @Override
    public boolean hasCellWith2048() {
        return false;
    }

    @Override
    public void move(Direction direction) {

    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public int getCellValue(int index) {
        return 0;
    }

    @Override
    public Direction getDirection() {
        return null;
    }

    @Override
    public void printGameField() {

    }

   // @Test

}
