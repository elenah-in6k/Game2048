/**
 * Created by employee on 10/15/15.
 */
public class Game2048 {

    public static void main(String[] args) {
        Game2048 newGame = new Game2048();
        newGame.game();
    }
// create interface, packege
    public void game() {
        GameField gameField = new GameField();
        gameField.startNewGame();
        Printer printer = new Printer(gameField);
        GameInputController input = new GameInputController(System.in);
        while (gameField.hasAvailableMoves() && !gameField.hasCellWith2048()) {
            printer.printGameField();
            gameField.move(input.getDirection());
            gameField.fillEmptyCell();
        }

    }
}
