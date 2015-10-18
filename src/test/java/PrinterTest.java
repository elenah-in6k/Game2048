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
    }
}
