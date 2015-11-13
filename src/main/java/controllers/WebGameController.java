package controllers;

import core.Direction;
import core.GameFieldImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;


/**
 * Created by employee on 11/12/15.
 */

@Controller
@SessionAttributes(value = "gameField")
@RequestMapping("/")
public class WebGameController  {

    GameFieldImpl gameField;

//    @RequestMapping(method = RequestMethod.GET)
//    public String printWelcome() {
//        return "index";
//    }

    @RequestMapping(method = RequestMethod.GET)

    public String init(@ModelAttribute("gameField") GameFieldImpl gameField, ModelMap model ){
        model.addAttribute("gameField", gameField);

        return "index";
    }

    @ModelAttribute("gameField")
    public GameFieldImpl createUser() {

        GameFieldImpl gameField = new GameFieldImpl();

        return gameField;
    }
    @RequestMapping(value = "action/{option}", method = RequestMethod.GET)
    public String controlGame(@ModelAttribute("gameField") GameFieldImpl gameField,
                              @PathVariable int option,
                              ModelMap model
    ){

        switch (option){
            case 8:
                gameField.move(Direction.UP);
                break;
            case 5:
                gameField.move(Direction.DOWN);
                break;
            case 4:
                gameField.move(Direction.LEFT);
                break;
            case 6:
                gameField.move(Direction.RIGHT);
                break;
        }

        if (!gameField.isGameEnd()) {
            gameField.fillEmptyCell();
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String move(@ModelAttribute("gameField") GameFieldImpl gameField,
                              @PathVariable int option,
                              ModelMap model
    ){

        switch (option){
            case 38:
                gameField.move(Direction.UP);
                break;
            case 40:
                gameField.move(Direction.DOWN);
                break;
            case 4:
                gameField.move(Direction.LEFT);
                break;
            case 6:
                gameField.move(Direction.RIGHT);
                break;
        }

        if (!gameField.isGameEnd()) {
            gameField.fillEmptyCell();
        }

        return "redirect:/";
    }

    public void playGame() {
        while (!gameField.isGameEnd()) {

            Direction direction = Direction.LEFT;

            gameField.move(direction);
            gameField.fillEmptyCell();
        }

    }

}
