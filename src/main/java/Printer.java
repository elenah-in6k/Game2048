/**
 * Created by Алена on 19.10.2015.
 */
public class Printer {
    GameField gameField;
    ColorShema color;
    public Printer(GameField gameField) {
    this.gameField = gameField;


    }
    void printGameField(){
        int i=0;
        while (i < gameField.SIZE * (gameField.SIZE - 1) ) {
                System.out.println(" -----   -----   -----   -----  ");
            int j = 0;
            while (((i + 1) * j - 1) < ((i+1)*gameField.SIZE - 1)){
            System.out.print("|");
            System.out.printf("%s%6d%s|", color.getCellColor(2),2);//gameField.gameField.get(j).cellValue),gameField.gameField.get(j).cellValue);
                //System.out.print(" | ");
                j++;
            }
            System.out.println();
            System.out.println(" -----   -----   -----   -----  ");

            i += gameField.SIZE;
        }

    }
    void printGameFieldToString(){

    }
}
