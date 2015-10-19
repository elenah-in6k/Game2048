/**
 * Created by Алена on 19.10.2015.
 */
public class Printer {
    GameField gameField;
    ColorShema color;
    String output = "";
    public Printer(GameField gameField) {
    this.gameField = gameField;


    }
    void printGameField(){
        int i=0;
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Score: "+gameField.gameScore);
        int j = 0;
        while (i < gameField.SIZE  ) {
                System.out.println(" ------  ------  ------  ------ ");
            output += " ------  ------  ------  ------ \n";
            int k = 0;
            while ((k < gameField.SIZE ) ){
            System.out.print("|");
                output += "|";
               System.out.print(getCellColor(gameField.gameField.get(j).cellValue));
                output += gameField.gameField.get(j).cellValue;
                System.out.printf("%6s", gameField.gameField.get(j).cellValue);
                System.out.print(getCellColor(0)+"|");
                output += "|";
                j++; k++;
            }
            System.out.println();
            System.out.println(" ------  ------  ------  ------ ");
            output +="\n ------  ------  ------  ------ \n";

            i ++;
        }

    }
    String getCellColor(int cellValue){
        ColorShema colorShema = new ColorShema();

        String color = colorShema.RESET;

        if (cellValue == 0)
            color = colorShema.RESET;
        if (cellValue == 2)
            color = colorShema.BACKGROUND_MAGENTA;
        if (cellValue ==  4)
            color = colorShema.BACKGROUND_CYAN;
        if (cellValue ==  8)
            color = colorShema.BACKGROUND_BLUE;
        if (cellValue ==  16)
            color = colorShema.BACKGROUND_GREEN;
        if (cellValue ==  32)
            color = colorShema.BACKGROUND_YELLOW;
        if (cellValue ==  64)
            color = colorShema.BACKGROUND_MAGENTA;
        if (cellValue ==  128)
            color = colorShema.BACKGROUND_BLUE;
        if (cellValue ==  256)
            color = colorShema.BACKGROUND_CYAN;
        if (cellValue ==  512)
            color = colorShema.BACKGROUND_GREEN;
        if (cellValue ==  1024)
            color = colorShema.BACKGROUND_YELLOW;
        if (cellValue ==  2048)
            color = colorShema.BACKGROUND_RED;

        return color;
    }
    String getOutput(){
            return output;
    }
}
