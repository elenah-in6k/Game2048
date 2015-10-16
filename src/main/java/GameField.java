/**
 * Created by employee on 10/16/15.
 */
public class GameField {
    int[][] gameField = new int[4][4];
    String gameFieldValue = "";

    public GameField() {
        for( int i = 0; i < gameField.length; i++){
            for( int j = 0; j < gameField.length; j++){
                gameField[i][j] = 0;
            }
        }
    }

    public void fillEmptyCell() {


    }
    public String toString(){
        for( int i = 0; i < gameField.length; i++){
            for( int j = 0; j < gameField.length; j++){
                gameFieldValue += gameField[i][j]+" ";

            }
            gameFieldValue += "\n";
        }
        return gameFieldValue;
    }

    public boolean IsEmptyCell(int i, int j) {
        if (gameField[i][j] == 0){
            return true;
        }
        return false;
    }

}
