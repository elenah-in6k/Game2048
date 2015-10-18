import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 10/16/15.
 */
public class GameField {
    List<Cell> gameField = new ArrayList<>();
    String gameFieldValue ;
    private CellValueGenerator cellValue = new StaticCellValueGenerator(2);
   private CellPlaceGenerator cellPlace ;
    final int SIZE = 4;
    int cellRow;
    int cellColumn;
    int gameScore = 0;


    public GameField() {
        for( int i = 0; i < SIZE * SIZE; i++){
            gameField.add(Cell.createEmptyCell(i));
        }
    }

    public void fillEmptyCell() {
        cellPlace = new RandomCellPlaceGenerator(gameField);
        int cellNumber = cellPlace.getCellNumber();
        Cell cell = gameField.get(cellNumber);
        cell.cellValue = cellValue.getCellValue();
        gameField.set(cellNumber, cell);
    }


    public void move(Direction direction){
        int i = 0;
        while (i < SIZE){
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
        int initialValue = i ;
        int finalValue = (SIZE * (SIZE - 1)) + i;
        i = finalValue;
        downOffset(initialValue, finalValue);
        while ((initialValue < i) ) {
            getSummEqualCellsAfterDownOffset(i);
            i -= SIZE;
        }
        downOffset(initialValue, finalValue);

    }

    private void getSummEqualCellsAfterDownOffset(int i) {
        Cell cellUpperOld = gameField.get(i-SIZE);
        Cell cellLowerOld = gameField.get(i);
        if((!cellLowerOld.IsEmptyCell())&&(cellLowerOld.isEqualsCellValue(cellUpperOld))){
            gameScore += cellLowerOld.cellValue*2;
            gameField.set(i, new Cell(i, cellUpperOld.cellValue*2));
            gameField.set(i-SIZE,Cell.createEmptyCell(i-SIZE));
        }
    }

    private void downOffset(int initialValue, int finalValue) {
        int i = finalValue;
        int j = i;
        while (initialValue < j){
            while ((initialValue  < i) ){
                Cell cellUpperOld = gameField.get(i-SIZE);
                Cell cellLowerOld = gameField.get(i);
                if(cellLowerOld.IsEmptyCell()&& !cellUpperOld.IsEmptyCell()){
                    gameField.set(i, new Cell(i, cellUpperOld.cellValue));
                    gameField.set(i-SIZE, Cell.createEmptyCell(i-SIZE));
                }
                i -= SIZE;
            }
            j -= SIZE;
        }
    }

    private void moveColumnUp(int i) {
        int initialValue = i ;
        int finalValue = (SIZE * 2) + i;
        i = initialValue;
        upOffset(initialValue, finalValue);
        while ((finalValue >= i) ) {
            getSummEqualCellsAfterUpOffset(i);
            i += SIZE;
        }
        upOffset(initialValue, finalValue);
    }

    private void upOffset(int initialValue, int finalValue) {
        int i = initialValue;
        int j = i;
        while (finalValue >= j){
            while ((finalValue >= i) ){
                Cell cellUpperOld = gameField.get(i );
                Cell cellLowerOld = gameField.get(i+SIZE);
                if(!cellLowerOld.IsEmptyCell()&& cellUpperOld.IsEmptyCell()){
                    gameField.set(i, new Cell(i, cellLowerOld.cellValue));
                    gameField.set(i+SIZE, Cell.createEmptyCell(i+SIZE));
                }
                i += SIZE;
            }
            j += SIZE;
        }
    }

    private void getSummEqualCellsAfterUpOffset(int i) {
        Cell cellUpperOld = gameField.get(i);
        Cell cellLowerOld = gameField.get(i+SIZE);
        if((!cellUpperOld.IsEmptyCell())&&(cellUpperOld.isEqualsCellValue(cellLowerOld))){
            gameScore += cellLowerOld.cellValue*2;
            gameField.set(i, new Cell(i, cellLowerOld.cellValue*2));
            gameField.set(i+SIZE,Cell.createEmptyCell(i+SIZE));
        }
    }



    private void moveRowLeft(int i) {
        int initialValue = i * SIZE;
        int finalValue = ((i+1) * SIZE) - 1;
        i = initialValue;
        leftOffset(initialValue, finalValue);
        while ((finalValue > i) ) {
            getSummEqualCellsAfterLeftOffset(i);
            i++;
        }
        leftOffset(initialValue, finalValue);

    }

    private void getSummEqualCellsAfterLeftOffset(int i) {
        Cell cellLeftOld = gameField.get(i);
        Cell cellRightOld = gameField.get(i+1);
        if((!cellLeftOld.IsEmptyCell())&&(cellLeftOld.isEqualsCellValue(cellRightOld))){
             gameScore += cellRightOld.cellValue*2;
            gameField.set(i, new Cell(i, cellRightOld.cellValue*2));
            gameField.set(i+1,Cell.createEmptyCell(i));
        }
    }

    private void leftOffset(int initialValue, int finalValue) {
        int i = initialValue;
        int j = i;
        while (finalValue > j){
            while ((finalValue > i) ){
                Cell cellLeftOld = gameField.get(i );
                Cell cellRightOld = gameField.get(i+1);
                if(!cellRightOld.IsEmptyCell()&& cellLeftOld.IsEmptyCell()){
                    gameField.set(i, new Cell(i, cellRightOld.cellValue));
                    gameField.set(i+1, Cell.createEmptyCell(i));
                }
                i++;
            }
            j++;
        }
    }

    private void moveRowRight(int i) {
        int initialValue = i * SIZE;
        int finalValue = ((i+1) * SIZE) - 1;
        i = finalValue;
        offsetRight(initialValue, finalValue);
        while ((initialValue < i) ) {
            getSummEqualCellsAfterRightOffset(i);
            i--;
        }
        offsetRight(initialValue, finalValue);
    }

    private void offsetRight(int initialValue, int finalValue) {
        int i = finalValue;
        int j = i;
        while (initialValue < j){
        while ((initialValue < i) ){
            Cell cellLeftOld = gameField.get(i - 1);
            Cell cellRightOld = gameField.get(i);
            if((cellRightOld.IsEmptyCell())&& (!cellLeftOld.IsEmptyCell())){
                gameField.set(i, new Cell(i, cellLeftOld.cellValue));
                gameField.set(i-1, Cell.createEmptyCell(i-1));
            }
            i--;
        }
            j--;
        }
    }

    private void getSummEqualCellsAfterRightOffset(int i) {
        Cell cellLeftOld = gameField.get(i - 1);
        Cell cellRightOld = gameField.get(i);
        Cell cellLeftNew = cellLeftOld;
        Cell cellRightNew = cellRightOld;
        if((!cellRightOld.IsEmptyCell())&&(cellRightOld.isEqualsCellValue(cellLeftOld))){
                cellRightNew = new Cell(i, cellRightOld.cellValue*2);
                 gameScore += cellRightOld.cellValue*2;
                 cellLeftNew = Cell.createEmptyCell(i-1);
        }
        gameField.set(i-1,cellLeftNew);
        gameField.set(i,cellRightNew);
    }

    public String toString(){
        gameFieldValue = "";
        for(Cell cell :gameField){
                gameFieldValue += cell.cellValue + " ";

        }
        return gameFieldValue;
    }



}
