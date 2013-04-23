package sample.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This displays the welcome screen that shows what will be happening in this chapter.
 *
 * @author Rob Winch
 *
 */
@Controller
public class WelcomeController {

    @RequestMapping("/")
    public String welcome() {
        return "index";
    }
}