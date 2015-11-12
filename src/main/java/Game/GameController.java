package Game;

import Game.console.GameInputController;
import Game.console.Printer;
import core.Direction;
import core.GameField;

/**
 * Created by employee on 10/20/15.
 */
public class GameController {
    GameField gameField;
    Printer printer;
    GameInputController inputController;

    public GameController(GameField gameFieldImpl, Printer ANSIPrinter, GameInputController input){
        gameField = gameFieldImpl;
        gameField.startNewGame();
        printer = ANSIPrinter;
        inputController = input;
    }
    public void startGame() {
        while (!gameField.isGameEnd()) {
            printer.printGameField();
            Direction direction = inputController.getDirection();
            gameField.move(direction);
            gameField.fillEmptyCell();
        }

    }



}
