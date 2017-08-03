package dayoff.calc.web.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mac on 17.05.17.
 */
@ControllerAdvice
public class ControllersExceptionHandler {

    @ExceptionHandler(DuplicateUsernameException.class)
    public String duplicateUsernameException(Model model) {
        model.addAttribute("duplicateUsernameError", true);
        return "registerForm";
    }

    @ExceptionHandler(PasswordsNotEqualException.class)
    public String resourceNotFound(Model model) {
        model.addAttribute("PasswordsNotEqualError", true);
        return "registerForm";
    }
}
