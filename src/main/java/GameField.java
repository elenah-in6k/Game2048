import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by employee on 10/16/15.
 */
public class GameField {
    static final int SIZE = 4;
    List<Cell> gameField = new ArrayList<>(SIZE * SIZE);
    int gameScore = 0;
    private CellFiller cellValue = new StaticCellFiller(2);
    private CellSelector cellSelector = new RandomCellSelector();

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
        Move move;
        int i = 0;
        while (i < SIZE) {
            switch (direction) {
                case right:
                    move = new MoveRight(gameField);
                    gameScore += move.move(i);
                    break;
                case left:
                    move = new MoveLeft(gameField);
                    gameScore += move.move(i);
                    break;
                case up:
                    move = new MoveUp(gameField);
                    gameScore += move.move(i);
                    break;
                case down:
                    move = new MoveDown(gameField);
                    gameScore += move.move(i);
                    break;
            }
            i++;
        }
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
