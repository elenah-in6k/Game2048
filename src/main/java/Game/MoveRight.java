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
                Pair pair = getCellPair(i);
                pair.pull();
                i--;
            }
            j--;
        }
    }

    @Override
    void getSumEqualCellsAfterOffset(int initialValue, int finalValue) {
       int i = finalValue;
        while ((initialValue < i)) {
            Pair pair = getCellPair(i);
            gameScore += pair.merge();
            i--;
        }
    }
    private Pair getCellPair(int posInLine) {
        return new Pair(gameField.get(posInLine), gameField.get(posInLine - 1 ));
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
