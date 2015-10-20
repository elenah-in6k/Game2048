import Game.*;

/**
 * Created by employee on 10/15/15.
 */
public class Game2048 {
    public static void main(String[] args) {
        GameField gameField = new GameFieldImpl();
        ANSIPrinter printer = new ANSIPrinter(System.out, gameField);
        GameInputControllerImpl input = new GameInputControllerImpl(System.in);
        GameController controller = new GameController(gameField, printer, input);
        controller.startGame();
    }
}
