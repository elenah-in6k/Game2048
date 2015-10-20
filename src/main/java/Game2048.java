import Game.GameField;
import Game.GameInputController;

/**
 * Created by employee on 10/15/15.
 */
public class Game2048 {
    GameField gameField;
    Printer printer;
    GameInputController input;

    Game2048(){
        gameField = new GameField();
        gameField.startNewGame();
        printer = new Printer(gameField);
        input = new GameInputController(System.in);

    }

    public static void main(String[] args) {
        Game2048 newGame = new Game2048();
        newGame.game();
    }

// create interface, packege
    public void game() {
        while (gameField.hasAvailableMoves() && !gameField.hasCellWith2048()) {
            printer.printGameField();
            gameField.move(input.getDirection());
            gameField.fillEmptyCell();
        }

    }
}
