package Game.core;

import java.util.List;

/**
 * Created by Алена on 20.10.2015.
 */
public class MoveDown extends Move {
    @Override
    void offset(int initialValue, int finalValue) {
        int j = initialValue;
        while ( finalValue < j) {
            int i = initialValue;
            while ((finalValue  < i)) {
                Pair pair = getCellPair(i);
                pair.pull();
                i -= SIZE;
            }
            j -= SIZE;
        }
    }

    @Override
    void getSumEqualCellsAfterOffset(int initialValue, int finalValue) {
        int i = initialValue;
        while ((finalValue < i)) {
            Pair pair = getCellPair(i);
            gameScore += pair.merge();
            i -= SIZE;
        }
    }

    private Pair getCellPair(int posInLine) {
        return new Pair(gameField.get(posInLine), gameField.get(posInLine - SIZE));
    }

    @Override
    int getInitialValue(int i) {
        return (SIZE * (SIZE - 1)) + i;
    }

    @Override
    int getFinalValue(int i) {return i;

    }

    public MoveDown(List<Cell> gameField) {
        super(gameField);
    }
}
