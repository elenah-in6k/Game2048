package controllers;

import core.GameField;
import core.GameFieldImpl;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by employee on 11/13/15.
 */
@SessionAttributes(value = "gameField")
public class GameServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("gameField",  createUser());

        request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request, response);
    }
    @ModelAttribute("gameField")
    public GameFieldImpl createUser() {

        GameFieldImpl gameField = new GameFieldImpl();
        gameField.startNewGame();
        return gameField;
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
    }
}
