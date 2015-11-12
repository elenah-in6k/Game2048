package Game.core;

import Game.core.Direction;

/**
 * Created by employee on 10/20/15.
 */
public interface GameField {

    final int SIZE = 4;

    void startNewGame();
    void fillEmptyCell();
    boolean hasAvailableMoves();
    boolean hasCellWith2048();
    void move(Direction direction);
    int getScore();

    int getCellValue(int index);
}
