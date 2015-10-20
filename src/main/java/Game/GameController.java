package Game;

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
        while (gameField.hasAvailableMoves() && !gameField.hasCellWith2048()) {
            printer.printGameField();
            gameField.move(inputController.getDirection());
            gameField.fillEmptyCell();
        }

    }

}
