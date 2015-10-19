import java.util.Scanner;

/**
 * Created by employee on 10/15/15.
 */
public class Game2048 {

    public static void main(String[] args) {
        Game2048 newGame = new Game2048();
        newGame.game();
    }

    public void game() {
        GameField gameField = new GameField();
        gameField.startNewGame();
        Printer printer;
        while (gameField.hasAvaibleMoves() && !gameField.hasCellWith2048()) {
            printer = new Printer(gameField);
            printer.printGameField();
            GameInputController direction = new GameInputController(System.in);
            gameField.move(direction.getDirection());
            gameField.fillEmptyCell();
        }

    }
}
