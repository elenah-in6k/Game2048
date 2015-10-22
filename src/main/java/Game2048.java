import Game.GameController;
import Game.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by employee on 10/15/15.
 */
public class Game2048 {
    public static void main(String[] args) {

        ApplicationContext factory = new ClassPathXmlApplicationContext("App.xml");
        GameController controller = (GameController)factory.getBean("controller");
        controller.startGame();
    }

}
