package core;

import Filler.CellFiller;
import Filler.CellSelector;
import Filler.RandomCellSelector;
import Filler.StaticCellFiller;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by employee on 10/16/15.
 */

public class GameFieldImpl implements GameField{
    int gameScore = 0;
    private CellFiller cellValue = new StaticCellFiller(2);
    private CellSelector cellSelector = new RandomCellSelector();
    private List<Cell> gameField = new ArrayList<>(SIZE * SIZE);

    public GameFieldImpl() {
        gameField.clear();
        for (int i = 0; i < SIZE * SIZE; i++) {
            gameField.add(Cell.createEmptyCell());
        }
        startNewGame();
    }

    public void startNewGame() {
        fillEmptyCell();
        fillEmptyCell();
    }
    public boolean isGameEnd() {
        return !hasAvailableMoves() || hasCellWith2048();
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

    @Override
    public int getCellValue(int index) {
        return gameField.get(index).getCellValue();
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
                case RIGHT:
                    move = new MoveRight(gameField);
                    gameScore += move.move(i);
                    break;
                case LEFT:
                    move = new MoveLeft(gameField);
                    gameScore += move.move(i);
                    break;
                case UP:
                    move = new MoveUp(gameField);
                    gameScore += move.move(i);
                    break;
                case DOWN:
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
