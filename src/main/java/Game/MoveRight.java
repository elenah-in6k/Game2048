package Game;

import java.util.List;

/**
 * Created by Алена on 20.10.2015.
 */
public class MoveRight extends Move {
    MoveRight(List<Cell> gameField) {
        super(gameField);
    }

    @Override
    void offset(int initialValue, int finalValue) {
        int j = finalValue;
        while (initialValue < j) {
            int i = finalValue;
            while ((initialValue < i)) {
                Cell cellLeftOld = gameField.get(i - 1);
                Cell cellRightOld = gameField.get(i);
                if ((cellRightOld.isEmpty()) && (!cellLeftOld.isEmpty())) {
                    gameField.set(i, new Cell(cellLeftOld.cellValue));
                    gameField.set(i - 1, Cell.createEmptyCell());
                }
                i--;
            }
            j--;
        }
    }

    @Override
    void getSumEqualCellsAfterOffset(int initialValue, int finalValue) {
       int i = finalValue;
        while ((initialValue < i)) {
            Cell cellLeftOld = gameField.get(i - 1);
            Cell cellRightOld = gameField.get(i);
            Cell cellLeftNew = cellLeftOld;
            Cell cellRightNew = cellRightOld;
            if ((!cellRightOld.isEmpty()) && (cellRightOld.isEquals(cellLeftOld))) {
                cellRightNew = new Cell(cellRightOld.cellValue * 2);
                gameScore += cellRightOld.cellValue * 2;
                cellLeftNew = Cell.createEmptyCell();
            }
            gameField.set(i - 1, cellLeftNew);
            gameField.set(i, cellRightNew);
            i--;
        }
    }

    @Override
    int getInitialValue(int i) {

        return i * SIZE;
    }

    @Override
    int getFinalValue(int i) {

        return ((i + 1) * SIZE) - 1;
    }
}
