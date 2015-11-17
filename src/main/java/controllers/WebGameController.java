package controllers;

import core.Direction;
import core.GameField;
import core.GameFieldImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import users.service.MyUserDetailsService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by employee on 11/12/15.
 */

@Controller
@SessionAttributes(value = "gameField")
@RequestMapping("/")
public class WebGameController {

    GameFieldImpl gameField;

    MyUserDetailsService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView init(@ModelAttribute("gameField") GameFieldImpl gameField, ModelAndView model) {
        model.addObject("title", "GAME 2048");
        model.addObject("gameFieldd", getField(gameField));
        model.setViewName("index");

        return model;

    }

    @RequestMapping(value = "/newGame", method = RequestMethod.GET)
    public String newGame() {
        createField();

        return "redirect:/";
    }

    @ModelAttribute("gameField")
    public GameFieldImpl createField() {

        GameFieldImpl gameField = new GameFieldImpl();
        this.gameField = gameField;
        return gameField;
    }

    @RequestMapping(value = "action/{option}", method = RequestMethod.GET)
    public String controlGame(@ModelAttribute("gameField") GameFieldImpl gameField,
                              @PathVariable int option,
                              ModelMap model
    ) {

        switch (option) {
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

    @RequestMapping(value = "/{option}", method = RequestMethod.POST)
    public  @ResponseBody  String move(@PathVariable int option,
                ModelAndView model) {

        switch (option) {
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
            case 0:
                break;
        }

        if (!gameField.isGameEnd()) {
            gameField.fillEmptyCell();
        }

        model.addObject("gameFieldd", "");
        return getField(gameField);
    }

    public String getField(GameFieldImpl gameField) {
    userService = new MyUserDetailsService();
        int maxScore = 0;
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (!(auth instanceof AnonymousAuthenticationToken)) {
//        UserDetails userDetail = (UserDetails) auth.getPrincipal();
//        maxScore = userService.getMaxScore(userDetail.getUsername());
//        }

        String str = "";
        str += "<h3>Score: " + gameField.getScore() + " Max score: " + maxScore + "</h3>";
        str += "<table class=\"table table-striped table-bordered\" >";

        int i = 0;
        int j = 0;
        while (i < GameField.SIZE) {
            str += "<tr>";
            int k = 0;
            while ((k < GameField.SIZE)) {
                str += "<td class =\"" ;
                str += getColor(gameField.getCellValue(j));
                str +=  "\">" ;
                if (gameField.getCellValue(j) != 0){
                str += gameField.getCellValue(j);
                }else{
                    str +=" " ;
                }
                str += "</td>";
                j++;
                k++;
            }
            str += "</tr>";
            i++;
        }
        str += "</table>";

        return str;
    }

    private String getColor(int cellValue) {
        String color = "";
        if ((cellValue == 0)||(cellValue ==  16)||(cellValue ==  256))
            color = "info";
        if ((cellValue == 2)||(cellValue ==  32)||(cellValue ==  512))
            color = "success";
        if ((cellValue ==  4)||(cellValue ==  64)||(cellValue ==  1024))
            color = "warning";
        if ((cellValue ==  8)||(cellValue ==  128)||(cellValue ==  2048))
            color = "error";
        return color;

    }


    public void playGame() {
        while (!gameField.isGameEnd()) {

            Direction direction = Direction.LEFT;

            gameField.move(direction);
            gameField.fillEmptyCell();
        }

    }


    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Game 2048");
        model.addObject("message", "This page is for ROLE_ADMIN only!");
        model.setViewName("admin");

        return model;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration(@RequestParam(value = "error", required = false) String error,
                                     @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("registration");

        return model;

    }

    //	public ModelAndView registerUserAccount(
//			@ModelAttribute("user") User account,
//			BindingResult result, HttpServletRequest request, Errors errors) {
//		return null;
//	}
    // customize the error message
    private String getErrorMessage(HttpServletRequest request, String key) {

        Exception exception = (Exception) request.getSession().getAttribute(key);

        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username and password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Invalid username and password!";
        }

        return error;
    }

    // for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();

        // check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            System.out.println(userDetail);

            model.addObject("username", userDetail.getUsername());

        }

        model.setViewName("403");
        return model;

    }
}
