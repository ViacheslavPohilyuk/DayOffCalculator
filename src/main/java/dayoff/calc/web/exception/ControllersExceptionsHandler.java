package dayoff.calc.web.exception;

import dayoff.calc.model.form.DateForm;
import dayoff.calc.model.form.RegisterForm;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.DateTimeException;

/**
 * Created by mac on 17.05.17.
 */
@ControllerAdvice
public class ControllersExceptionsHandler {

    @ExceptionHandler(DuplicateUsernameException.class)
    public String duplicateUsernameException(Model model) {
        model.addAttribute(new RegisterForm());
        model.addAttribute("duplicateUsernameError", true);
        return "signUp";
    }

    @ExceptionHandler(PasswordsNotEqualException.class)
    public String passwordsNotEqualException(Model model) {
        model.addAttribute(new RegisterForm());
        model.addAttribute("PasswordsNotEqualError", true);
        return "signUp";
    }

    @ExceptionHandler(EndDateLessThanStartException.class)
    public String endDateLessThanStartException(Model model) {
        model.addAttribute(new DateForm());
        model.addAttribute("EndDateLessThanStartError", true);
        return "calc";
    }

    @ExceptionHandler(DateTimeException.class)
    public String dateInvalidException(Model model) {
        model.addAttribute("dateInvalidError", true);
        return "calc";
    }
}

