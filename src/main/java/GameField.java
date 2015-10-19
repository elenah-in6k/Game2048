import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by employee on 10/16/15.
 */
public class GameField {
    final int SIZE = 4;
    List<Cell> gameField = new ArrayList<>(SIZE * SIZE);
    int gameScore = 0;
    private CellValueGenerator cellValue = new StaticCellValueGenerator(2);
    private CellPlaceGenerator cellSelector = new RandomCellPlaceGenerator();

    public GameField() {
        for (int i = 0; i < SIZE * SIZE; i++) {
            gameField.add(Cell.createEmptyCell());
        }
    }

    public void startNewGame() {
        fillEmptyCell();
        fillEmptyCell();
    }

    public void fillEmptyCell() {
        Cell cell = cellSelector.selectCell(getEmptyCells());
        cell.cellValue = cellValue.getCellValue();
    }

    public boolean hasCellWith2048() {
        for (Cell cell : gameField) {
            if (cell.isCellWith2048()) {
                return true;
            }
        }
        return false;
    }

    public int getScore() {

        return gameScore;
    }

    public boolean hasAvailableMoves() {
        return !isFieldFilled() || hasEqualsNearbyCells();
    }

    private boolean hasEqualsNearbyCells() {
        for (int i = 0; i < SIZE * (SIZE - 1); i += SIZE) {
            for (int j = 0; j + i < SIZE - 1; j++) {
                Cell cell = gameField.get(j);
                if (cell.isEquals(gameField.get(j + 1)) ||
                        cell.isEquals(gameField.get(i + SIZE))) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isFieldFilled() {
        return getEmptyCells().isEmpty();
    }

    public void move(Direction direction) {
        int i = 0;
        while (i < SIZE) {
            switch (direction) {
                case right:
                    moveRowRight(i);
                    break;
                case left:
                    moveRowLeft(i);
                    break;
                case up:
                    moveColumnUp(i);
                    break;
                case down:
                    moveColumnDown(i);
                    break;
            }
            i++;
        }
    }

    private void moveColumnDown(int i) {
        int initialValue = i;
        int finalValue = (SIZE * (SIZE - 1)) + i;
        i = finalValue;
        downOffset(initialValue, finalValue);
        while ((initialValue < i)) {
            getSummEqualCellsAfterDownOffset(i);
            i -= SIZE;
        }
        downOffset(initialValue, finalValue);

    }

    private void downOffset(int initialValue, int finalValue) {
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

    private void getSummEqualCellsAfterDownOffset(int i) {
        Cell cellUpperOld = gameField.get(i - SIZE);
        Cell cellLowerOld = gameField.get(i);
        if ((!cellLowerOld.isEmpty()) && (cellLowerOld.isEquals(cellUpperOld))) {
            gameScore += cellLowerOld.cellValue * 2;
            gameField.set(i, new Cell(cellUpperOld.cellValue * 2));
            gameField.set(i - SIZE, Cell.createEmptyCell());
        }
    }

    private void moveColumnUp(int i) {
        int initialValue = i;
        int finalValue = (SIZE * 2) + i;
        i = initialValue;
        upOffset(initialValue, finalValue);
        while ((finalValue >= i)) {
            getSummEqualCellsAfterUpOffset(i);
            i += SIZE;
        }
        upOffset(initialValue, finalValue);
    }

    private void upOffset(int initialValue, int finalValue) {
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

    private void getSummEqualCellsAfterUpOffset(int i) {
        Cell cellUpperOld = gameField.get(i);
        Cell cellLowerOld = gameField.get(i + SIZE);
        if ((!cellUpperOld.isEmpty()) && (cellUpperOld.isEquals(cellLowerOld))) {
            gameScore += cellLowerOld.cellValue * 2;
            gameField.set(i, new Cell(cellLowerOld.cellValue * 2));
            gameField.set(i + SIZE, Cell.createEmptyCell());
        }
    }

    private void moveRowLeft(int i) {
        int initialValue = i * SIZE;
        int finalValue = ((i + 1) * SIZE) - 1;
        i = initialValue;
        leftOffset(initialValue, finalValue);
        while ((finalValue > i)) {
            getSummEqualCellsAfterLeftOffset(i);
            i++;
        }
        leftOffset(initialValue, finalValue);

    }

    private void getSummEqualCellsAfterLeftOffset(int i) {
        Cell cellLeftOld = gameField.get(i);
        Cell cellRightOld = gameField.get(i + 1);
        if ((!cellLeftOld.isEmpty()) && (cellLeftOld.isEquals(cellRightOld))) {
            gameScore += cellRightOld.cellValue * 2;
            gameField.set(i, new Cell(cellRightOld.cellValue * 2));
            gameField.set(i + 1, Cell.createEmptyCell());
        }
    }

    private void leftOffset(int initialValue, int finalValue) {
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

    private void moveRowRight(int i) {
        int initialValue = i * SIZE;
        int finalValue = ((i + 1) * SIZE) - 1;
        i = finalValue;
        offsetRight(initialValue, finalValue);
        while ((initialValue < i)) {
            getSumEqualCellsAfterRightOffset(i);
            i--;
        }
        offsetRight(initialValue, finalValue);
    }

    private void offsetRight(int initialValue, int finalValue) {

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

    private void getSumEqualCellsAfterRightOffset(int i) {
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
    }

    public String toString() {
        String gameFieldValue = "";
        for (Cell cell : gameField) {
            gameFieldValue += cell.cellValue + " ";
        }

        return gameFieldValue;
    }

    public List<Cell> getEmptyCells() {
        return gameField
                .stream()
                .filter(Cell::isEmpty)
                .collect(Collectors.toList());
    }
}
