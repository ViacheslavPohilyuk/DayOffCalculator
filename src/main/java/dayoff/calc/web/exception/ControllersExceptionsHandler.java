package dayoff.calc.web.exception;

import dayoff.calc.model.form.RegisterForm;
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
public class ControllersExceptionsHandler {

    @ExceptionHandler(DuplicateUsernameException.class)
    public String duplicateUsernameException(Model model) {
        model.addAttribute(new RegisterForm());
        model.addAttribute("duplicateUsernameError", "error");
        return "signUp";
    }

    @ExceptionHandler(PasswordsNotEqualException.class)
    public String passwordsNotEqualException(Model model) {
        model.addAttribute(new RegisterForm());
        model.addAttribute("PasswordsNotEqualError", "error");
        return "signUp";
    }
}

