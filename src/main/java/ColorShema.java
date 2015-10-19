/**
 * Created by Алена on 19.10.2015.
 */
public class ColorShema {
     final String	BACKGROUND_BLACK	= "\u001B[40m";
     final String	BACKGROUND_RED		= "\u001B[41m";
     final String	BACKGROUND_GREEN	= "\u001B[42m";
     final String	BACKGROUND_YELLOW	= "\u001B[43m";
     final String	BACKGROUND_BLUE		= "\u001B[44m";
     final String	BACKGROUND_MAGENTA	= "\u001B[45m";
     final String	BACKGROUND_CYAN		= "\u001B[46m";
     final String	BACKGROUND_WHITE	= "\u001B[47m";

    ColorShema(){

    }

    String getCellColor(int cellValue){
        String color ="";
//        switch  (cellValue){
//            case 2:
//                color = BACKGROUND_MAGENTA;
//            case 4:
//                color = BACKGROUND_BLUE;
//            case 8:
//                color = BACKGROUND_CYAN;
//            case 16:
//                color = BACKGROUND_GREEN;
//            case 32:
//                color = BACKGROUND_YELLOW;
//            case 64:
//                color = BACKGROUND_MAGENTA;
//            case 128:
//                color = BACKGROUND_BLUE;
//            case 256:
//                color = BACKGROUND_CYAN;
//            case 512:
//            color = BACKGROUND_GREEN;
//            case 1024:
//            color = BACKGROUND_YELLOW;
//            case 2048:
//            color = BACKGROUND_RED;
//        }
        color = BACKGROUND_WHITE;
        if (cellValue == 2)
                color = BACKGROUND_MAGENTA;
            if (cellValue ==  4)
                color = BACKGROUND_BLUE;
            if (cellValue ==  8)
                color = BACKGROUND_CYAN;
            if (cellValue ==  16)
                color = BACKGROUND_GREEN;
            if (cellValue ==  32)
                color = BACKGROUND_YELLOW;
            if (cellValue ==  64)
                color = BACKGROUND_MAGENTA;
            if (cellValue ==  128)
                color = BACKGROUND_BLUE;
            if (cellValue ==  256)
                color = BACKGROUND_CYAN;
            if (cellValue ==  512)
                color = BACKGROUND_GREEN;
            if (cellValue ==  1024)
                color = BACKGROUND_YELLOW;
            if (cellValue ==  2048)
                color = BACKGROUND_RED;

        return color;
    }
}
