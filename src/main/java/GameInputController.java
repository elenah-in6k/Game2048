import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by employee on 10/19/15.
 */
public class GameInputController {

    Scanner inputScanner;

    public GameInputController(InputStream inputStream) {

        inputScanner = new Scanner(inputStream);
    }

    public Direction getDirection() {
        int inputDirection = inputScanner.nextInt();
        if ( inputDirection == 6)
            return Direction.right;
        else if ( inputDirection == 4)
            return Direction.left;
        else if ( inputDirection == 8)
            return Direction.up;
        else
            return Direction.down;

    }
}
