/**
 * Created by Алена on 19.10.2015.
 */
public class Printer {
    GameField gameField;
    public Printer(GameField gameField) {
    this.gameField = gameField;

    }
    void printGameField(){
        int i=0;
        while (i < gameField.SIZE * (gameField.SIZE - 1) ) {
                System.out.println("--------------------------------");
            int j = 0;
            while (j*i < i* gameField.SIZE){
            System.out.print("|");
            System.out.printf("%4d", gameField.gameField.get(i).cellValue);
            i++;
            System.out.print("|");
                j++;
            } System.out.println("--------------------------------");

            i += gameField.SIZE;
        }

    }
    void printGameFieldToString(){

    }
}
