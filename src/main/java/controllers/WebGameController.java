package controllers;

import core.Direction;
import core.GameFieldImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by employee on 11/12/15.
 */

@Controller
@SessionAttributes(value = "gameField")
@RequestMapping("/")
public class WebGameController {
    @Autowired
    GameFieldImpl gameField;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String initGame(@ModelAttribute("gameField") GameFieldImpl gameField, ModelMap model){
        model.addAttribute("gameField", gameField);

        return "index";
    }

    @ModelAttribute("gameField")
    public GameFieldImpl createUser() {

        gameField.startNewGame();
        return gameField;
    }

    public void playGame() {
        while (!gameField.isGameEnd()) {

            Direction direction = Direction.LEFT;
            gameField.move(direction);
            gameField.fillEmptyCell();
        }

    }

}
