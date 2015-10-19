import org.junit.Test;

/**
 * Created by Алена on 19.10.2015.
 */
public class PrinterTest {
    @Test
    public void testPrintGameField(){
        GameField gf = new GameField();
        Printer printer = new Printer(gf);
        printer.printGameField();
        String output = "-----   -----   -----   -----\n"+
                "|   0 | |   0 | |   0 | |   0 |"+"\n"+
                "-----   -----   -----   -----"+"\n"+
                        "-----   -----   -----   -----"+"\n"+
                "|   0 | |   0 | |   0 | |   0 |"+"\n"+
                "-----   -----   -----   -----"+"\n"+
                        "-----   -----   -----   -----"+"\n"+
                "|   0 | |   0 | |   0 | |   0 |"+"\n"+
                "-----   -----   -----   -----"+"\n";
    }
}
