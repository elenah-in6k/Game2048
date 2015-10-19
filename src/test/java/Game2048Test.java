import org.junit.Test;

/**
 * Created by employee on 10/19/15.
 */
public class Game2048Test {

    @Test
    public void testMainGame2048(){
        Game2048 game = new Game2048();
        game.main(new String[100]);
    }
}
