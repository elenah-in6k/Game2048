import Game.ANSIPrinter;
import Game.GameField;
import Game.GameFieldImpl;
import Game.Printer;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Алена on 19.10.2015.
 */
public class ANSIPrinterTest {
    @Test
    public void testPrintGameField(){
        GameField gf = new GameFieldImpl();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        Printer printer = new ANSIPrinter(ps, gf);
        printer.printGameField();
        String output =
                        "\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                        "Score: 0" +
                        "\n ------- ------- ------- -------\n" +
                        "|[0m\t0\t[0m||[0m\t0\t[0m||[0m\t0\t[0m||[0m\t0\t[0m|" +
                        "\n ------- ------- ------- -------\n" +
                        " ------- ------- ------- -------\n" +
                        "|[0m\t0\t[0m||[0m\t0\t[0m||[0m\t0\t[0m||[0m\t0\t[0m|" +
                        "\n ------- ------- ------- -------\n" +
                        " ------- ------- ------- -------\n" +
                        "|[0m\t0\t[0m||[0m\t0\t[0m||[0m\t0\t[0m||[0m\t0\t[0m|\n" +
                        " ------- ------- ------- -------\n" +
                        " ------- ------- ------- -------\n" +
                        "|[0m\t0\t[0m||[0m\t0\t[0m||[0m\t0\t[0m||[0m\t0\t[0m|\n" +
                        " ------- ------- ------- -------\n";
        String content = baos.toString();
        assertThat(content, is(output));
    }
}
