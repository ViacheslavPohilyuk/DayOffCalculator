package dayoff.calc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mac on 03.08.17.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    String home() {
        return "home";
    }
}
