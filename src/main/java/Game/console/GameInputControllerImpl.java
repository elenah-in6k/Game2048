package Game.console;

import core.Direction;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by employee on 10/19/15.
 */
public class GameInputControllerImpl implements GameInputController {

    InputStream input;
    private byte[] inputChar = new byte[1];

    public GameInputControllerImpl(InputStream inputStream) {
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
                return Direction.RIGHT;
            case '4':
                return Direction.LEFT;
            case '8':
                return Direction.UP;
            case '2':
            case '5':
                return Direction.DOWN;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
