package dayoff.calc.web.exception;

/**
 * Created by mac on 02.08.17.
 */
public class DuplicateUsernameException extends RuntimeException {
    public DuplicateUsernameException() {
        super("Sorry, but this username is already exist.");
    }
}
