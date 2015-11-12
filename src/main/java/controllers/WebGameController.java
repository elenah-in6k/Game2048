package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by employee on 11/12/15.
 */

@Controller
@RequestMapping("/")
public class WebGameController {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome() {
        return "index";
    }
}
