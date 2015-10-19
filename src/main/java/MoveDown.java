import java.util.List;

/**
 * Created by Алена on 20.10.2015.
 */
public class MoveDown extends Move {
    @Override
    void offset(int initialValue, int finalValue) {
        int j = finalValue;
        while (initialValue < j) {
            int i = finalValue;
            while ((initialValue < i)) {
                Cell cellUpperOld = gameField.get(i - SIZE);
                Cell cellLowerOld = gameField.get(i);
                if (cellLowerOld.isEmpty() && !cellUpperOld.isEmpty()) {
                    gameField.set(i, new Cell(cellUpperOld.cellValue));
                    gameField.set(i - SIZE, Cell.createEmptyCell());
                }
                i -= SIZE;
            }
            j -= SIZE;
        }
    }

    @Override
    void getSumEqualCellsAfterOffset(int initialValue, int finalValue) {
        int i = finalValue;
        while ((initialValue < i)) {
            Cell cellUpperOld = gameField.get(i - SIZE);
            Cell cellLowerOld = gameField.get(i);
            if ((!cellLowerOld.isEmpty()) && (cellLowerOld.isEquals(cellUpperOld))) {
                gameScore += cellLowerOld.cellValue * 2;
                gameField.set(i, new Cell(cellUpperOld.cellValue * 2));
                gameField.set(i - SIZE, Cell.createEmptyCell());
            }
            i -= SIZE;
        }
    }

    @Override
    int getInitialValue(int i) {
        return i;
    }

    @Override
    int getFinalValue(int i) {
        return (SIZE * (SIZE - 1)) + i;
    }

    public MoveDown(List<Cell> gameField) {
        super(gameField);
    }
}
