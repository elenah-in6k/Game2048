package controllers;

import core.Direction;
import core.GameField;
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


    @RequestMapping(method = RequestMethod.GET)

    public String init(@ModelAttribute("gameField") GameFieldImpl gameField, ModelMap model ){
        model.addAttribute("gameField", gameField);

        return "index";
    }

    @ModelAttribute("gameField")
    public GameFieldImpl createUser() {

        GameFieldImpl gameField = new GameFieldImpl();
        this.gameField = gameField;
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

    @RequestMapping(value = "/game/{option}", method = RequestMethod.POST)
    public @ResponseBody String move(@PathVariable int option,
                              ModelMap model
    ){

        switch (option){
            case 38:
                gameField.move(Direction.UP);
                break;
            case 40:
                gameField.move(Direction.DOWN);
                break;
            case 37:
                gameField.move(Direction.LEFT);
                break;
            case 39:
                gameField.move(Direction.RIGHT);
                break;
        }

        if (!gameField.isGameEnd()) {
            gameField.fillEmptyCell();
        }

        String str = "<table border=\"1px\">";

        int i = 0;
        int j = 0;
        while (i < GameField.SIZE  ) {
            str +="<tr>";
             int k = 0;
            while ((k < GameField.SIZE ) ){
                str += "<td>"+ gameField.getCellValue(j) +"</td>";
                j++; k++;
            }
            str +="</tr>";
              i ++;
        }
        str +="</table>";

        return str;
    }

    public void playGame() {
        while (!gameField.isGameEnd()) {

            Direction direction = Direction.LEFT;

            gameField.move(direction);
            gameField.fillEmptyCell();
        }

    }

}
