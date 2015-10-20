package Game;

import java.util.List;

/**
 * Created by Алена on 20.10.2015.
 */
public abstract class Move {
    int gameScore;
    List<Cell> gameField;
    final int SIZE = GameFieldImpl.SIZE;

    class Pair {
        Cell current;
        Cell next;

        public Pair(Cell current, Cell next) {
            this.current = current;
            this.next = next;
        }

        int merge() {
            int score = 0;
            if ((!current.isEmpty()) && (current.isEquals(next))) {
                current.setValue(next.cellValue * 2);
                next.setValue(0);
                score = current.getCellValue();
            }
            return score;
        }

        void pull() {
            if (!next.isEmpty() && current.isEmpty()) {
                current.setValue(next.getCellValue());
                next.setValue(0);
            }
        }
    }

    abstract void offset(int initialValue, int finalValue);
    abstract void getSumEqualCellsAfterOffset(int initialValue, int finalValue);
    abstract int getInitialValue(int lineIndex);
    abstract int getFinalValue(int lineIndex);

    Move(List<Cell> gameField){
        this.gameField = gameField;
    }

    public int move(int lineIndex){
        int initialValue = getInitialValue(lineIndex);
        int finalValue = getFinalValue(lineIndex);

        offset(initialValue, finalValue);
        getSumEqualCellsAfterOffset(initialValue, finalValue);
        offset(initialValue, finalValue);

        return gameScore;
    }

}
