import java.io.IOException;
import java.io.InputStream;

/**
 * Created by employee on 10/19/15.
 */
public class GameInputController {

    InputStream input;
    private byte[] inputChar = new byte[1];

    public GameInputController(InputStream inputStream) {
        input = inputStream;
    }

    public Direction getDirection() {
        try {
            input.read(inputChar);
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (inputChar[0]) {
            case '6':
                return Direction.right;
            case '4':
                return Direction.left;
            case '8':
                return Direction.up;
            case '2':
                return Direction.down;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
