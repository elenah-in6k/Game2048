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

    }

    private void moveColumnUp(int i) {

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
        Cell cellLeftNew = cellLeftOld;
        Cell cellRightNew = cellRightOld;
        if((!cellLeftOld.IsEmptyCell())&&(cellLeftOld.isEqualsCellValue(cellRightOld))){
             gameScore += cellRightOld.cellValue*2;
            cellLeftNew = new Cell(i, cellRightOld.cellValue*2);
            cellRightNew = Cell.createEmptyCell(i);
        }
        gameField.set(i,cellLeftNew);
        gameField.set(i+1,cellRightNew);

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

    void setSomeCellsValue( int i, Cell cellLeft, Cell cellRight){

    }

    public String toString(){
        gameFieldValue = "";
        for(Cell cell :gameField){
                gameFieldValue += cell.cellValue + " ";

        }
        return gameFieldValue;
    }



}
