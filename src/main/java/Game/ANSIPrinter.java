package Game;

import java.io.PrintStream;

/**
 * Created by Алена on 19.10.2015.
 */
public class ANSIPrinter implements Printer {
    PrintStream printStream;
    GameField gameField;

    public ANSIPrinter(PrintStream printStream, GameField gameFieldImpl) {
            this.gameField = gameFieldImpl;
            this.printStream = printStream;
    }

    public void printGameField(){
        String printString = "";
        printString +="\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
        printString +="Score: "+ gameField.getScore()+"\n";
        int i=0;
        int j = 0;
        while (i < GameField.SIZE  ) {
            printString += " ------- ------- ------- -------\n";
            int k = 0;
            while ((k < GameField.SIZE ) ){
                printString += "|";
                printString += getCellColor(gameField.getCellValue(j));
                printString += "\t";
                printString += gameField.getCellValue(j);
                printString +="\t"+getCellColor(0)+"|";
                j++; k++;
            }
            printString +="\n ------- ------- ------- -------\n";
            i ++;
        }
        printStream.print(printString);

    }
    String getCellColor(int cellValue){
        ColorShema colorShema = new ColorShema();

        String color = colorShema.RESET;
//case or enum
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
}
