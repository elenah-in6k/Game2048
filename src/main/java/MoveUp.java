import java.util.List;

/**
 * Created by Алена on 20.10.2015.
 */
public class MoveUp extends Move {
    public MoveUp(List<Cell> gameField) {
        super(gameField);
    }

    @Override
    void offset(int initialValue, int finalValue) {
        int j = initialValue;
        while (finalValue >= j) {
            int i = initialValue;
            while ((finalValue >= i)) {
                Cell cellUpperOld = gameField.get(i);
                Cell cellLowerOld = gameField.get(i + SIZE);
                if (!cellLowerOld.isEmpty() && cellUpperOld.isEmpty()) {
                    gameField.set(i, new Cell(cellLowerOld.cellValue));
                    gameField.set(i + SIZE, Cell.createEmptyCell());
                }
                i += SIZE;
            }
            j += SIZE;
        }
    }

    @Override
    void getSumEqualCellsAfterOffset(int initialValue, int finalValue) {
        int i = initialValue;
        while ((finalValue >= i)) {
            Cell cellUpperOld = gameField.get(i);
            Cell cellLowerOld = gameField.get(i + SIZE);
            if ((!cellUpperOld.isEmpty()) && (cellUpperOld.isEquals(cellLowerOld))) {
                gameScore += cellLowerOld.cellValue * 2;
                gameField.set(i, new Cell(cellLowerOld.cellValue * 2));
                gameField.set(i + SIZE, Cell.createEmptyCell());
            }

            i += SIZE;
        }
    }

    @Override
    int getInitialValue(int i) {
        return i;
    }

    @Override
    int getFinalValue(int i) {
        return (SIZE * 2) + i;
    }

}
