package Game;

import java.util.List;

/**
 * Created by Алена on 20.10.2015.
 */
public class MoveLeft extends Move {

    public MoveLeft(List<Cell> gameField) {
        super(gameField);
    }
    @Override
    void offset(int initialValue, int finalValue) {
        int j = 0;
        while (finalValue >= j) {
            int i = initialValue;
            while ((finalValue > i)) {
                Cell cellLeftOld = gameField.get(i);
                Cell cellRightOld = gameField.get(i + 1);
                if (!cellRightOld.isEmpty() && cellLeftOld.isEmpty()) {
                    gameField.set(i, new Cell(cellRightOld.cellValue));
                    gameField.set(i + 1, Cell.createEmptyCell());

                }
                i++;
            }
            j++;
            ;
        }
    }

    @Override
    void getSumEqualCellsAfterOffset(int initialValue, int finalValue) {
        int i = initialValue;
        while ((finalValue > i)) {
            Cell cellLeftOld = gameField.get(i);
            Cell cellRightOld = gameField.get(i + 1);
            if ((!cellLeftOld.isEmpty()) && (cellLeftOld.isEquals(cellRightOld))) {
                gameScore += cellRightOld.cellValue * 2;
                gameField.set(i, new Cell(cellRightOld.cellValue * 2));
                gameField.set(i + 1, Cell.createEmptyCell());
            }
            i++;
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
