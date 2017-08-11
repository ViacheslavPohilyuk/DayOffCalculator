package dayoff.calc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by mac on 04.08.17.
 */
@Controller
@RequestMapping(value = {"/", "/login"})
public class LoginController {
    @RequestMapping(method = GET)
    public String loginForm() {
        return "login";
    }
}
