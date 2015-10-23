package Game;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * Created by employee on 10/22/15.
 */
public class InputOutputFactory {

    public static InputStream inStream(){

        return System.in;
    }
    public static PrintStream outStream(){

        return System.out;
    }
}
